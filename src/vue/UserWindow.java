package vue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import controleur.Controleur;
import modele.DataBaseConnect;
import modele.Utilisateur;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.rmi.RemoteException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/*
 * Classe permettant d'acceder à la fenêtre de connexion/inscription
 */

public class UserWindow {

	private static JFrame frame;
	private static JTextField loginField;
	private static JTextField mdpField;
	private static DataBaseConnect dB;
	private static JLabel lblUtilisateurOuMdp;
	private JButton btnConnexion;
	private JButton btnSinscrire;
	private Controleur controleur = new Controleur();
	 
	 /**
	
	* Initialize the contents of the frame.
	
	*/
	
	public UserWindow() {
	
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);	
		frame.setSize(400, 600);		
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		loginField = new JTextField();
		loginField.setBounds(154, 171, 130, 26);
		frame.getContentPane().add(loginField);
		loginField.setColumns(10);
		
		mdpField = new JTextField();
		mdpField.setBounds(154, 250, 130, 26);
		frame.getContentPane().add(mdpField);
		mdpField.setColumns(10);
		
		JLabel lblNomDutilisateur = new JLabel("Nom d'utilisateur :");
		lblNomDutilisateur.setBounds(19, 176, 118, 16);
		frame.getContentPane().add(lblNomDutilisateur);
		
		JLabel lblMotDePasse = new JLabel("Mot de passe :");
		lblMotDePasse.setBounds(19, 255, 123, 16);
		frame.getContentPane().add(lblMotDePasse);
		
		btnConnexion = new JButton("Connexion");
		btnConnexion.setBounds(154, 348, 117, 29);
		btnConnexion.setActionCommand("connexion");
		btnConnexion.addActionListener(controleur);
		frame.getContentPane().add(btnConnexion);
		
		JLabel lblChatRoom = new JLabel("Chat Room");
		lblChatRoom.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblChatRoom.setBounds(154, 38, 98, 16);
		frame.getContentPane().add(lblChatRoom);
		
		lblUtilisateurOuMdp = new JLabel("Login ou mot de passe incorrect");
		lblUtilisateurOuMdp.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		lblUtilisateurOuMdp.setForeground(Color.RED);
		lblUtilisateurOuMdp.setBounds(138, 302, 164, 16);
		lblUtilisateurOuMdp.setVisible(false);
		frame.getContentPane().add(lblUtilisateurOuMdp);
		
		JLabel labelRedirection = new JLabel("Pas encore de compte ?");
		labelRedirection.setBounds(130, 423, 154, 16);
		frame.getContentPane().add(labelRedirection);

		btnSinscrire = new JButton("S'inscrire");
		btnSinscrire.setBounds(154, 451, 117, 29);
		btnSinscrire.setActionCommand("fenetre inscription");
		btnSinscrire.addActionListener(controleur);
		frame.getContentPane().add(btnSinscrire);
		frame.setVisible(true);
		
	}
	
	/**
	 * Méthode permettant la connexion au Chat Room 
	 */
	 
	
	public static void connexion() throws SQLException, RemoteException, ClassNotFoundException {
	
		dB = new DataBaseConnect();
		ResultSet rset = dB.query("select login, mdp, pseudo from public.user ");
		
		ArrayList <Utilisateur> listUtilisateur = new ArrayList<>();

		while (rset.next()) {
			listUtilisateur.add(new Utilisateur(rset.getString(1),rset.getString(2),rset.getString(3)));
		}

		
		for(int i=0; i< listUtilisateur.size();i++){
			if (listUtilisateur.get(i).getLogin().equals(loginField.getText()) && listUtilisateur.get(i).getMdp().equals(mdpField.getText())){
				frame.dispose();
				new ChatRoomGUI(listUtilisateur.get(i));
			}
			
			else{ lblUtilisateurOuMdp.setVisible(true); }
		}
			
	}
	
	public static void inscription(){
		frame.dispose();
		new InscriptionWindow();
	}
	
	public static void main (String[] args){
		new UserWindow();
	}
	
}