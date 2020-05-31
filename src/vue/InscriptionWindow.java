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

public class InscriptionWindow {
	
	private static JFrame frame;
	private static JTextField pseudoField;
	private static JTextField utilisateurField;
	private static JTextField mdpField;
	private JButton btnSinscrire;
	private static JLabel lblPseudoDjExistant;
	private static JTextField mdpConfField;
	private static JLabel lblConfirmationMotDe;
	private static JLabel labelError;
	private static JLabel lblDjUnCompte;
	private JButton btnSeConnecter;
	private static JLabel labelLoginExistant;
	private static DataBaseConnect dB;
	private Controleur controleur;
	
	
	 /**
	
	* Initialize the contents of the frame.
	
	*/
	public InscriptionWindow() {
		controleur = new Controleur();
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setSize(400, 600);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		pseudoField = new JTextField();
		pseudoField.setBounds(157, 206, 130, 26);
		frame.getContentPane().add(pseudoField);
		pseudoField.setColumns(10);
		
		JLabel lblPseudo = new JLabel("Pseudo :");
		lblPseudo.setBounds(30, 211, 61, 16);
		frame.getContentPane().add(lblPseudo);
		
		utilisateurField = new JTextField();
		utilisateurField.setBounds(157, 261, 130, 26);
		frame.getContentPane().add(utilisateurField);
		utilisateurField.setColumns(10);
		
		JLabel lblNomDutilisateur = new JLabel("Nom d'utilisateur :");
		lblNomDutilisateur.setBounds(18, 266, 127, 16);
		frame.getContentPane().add(lblNomDutilisateur);
		
		mdpField = new JTextField();
		mdpField.setBounds(157, 306, 130, 26);
		frame.getContentPane().add(mdpField);
		mdpField.setColumns(10);
		
		JLabel lblMotDePasse = new JLabel("Mot de passe :");
		lblMotDePasse.setBounds(18, 311, 116, 16);
		frame.getContentPane().add(lblMotDePasse);
		
		JLabel lblChatRoom = new JLabel("Chat Room - Inscription");
		lblChatRoom.setBounds(129, 60, 158, 16);
		frame.getContentPane().add(lblChatRoom);
		
		btnSinscrire = new JButton("S'inscrire");
		btnSinscrire.setBounds(157, 430, 117, 29);
		btnSinscrire.setActionCommand("inscription");
		btnSinscrire.addActionListener(controleur);
		frame.getContentPane().add(btnSinscrire);
		
		lblPseudoDjExistant = new JLabel("Pseudo déjà existant");
		lblPseudoDjExistant.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		lblPseudoDjExistant.setForeground(Color.RED);
		lblPseudoDjExistant.setBounds(167, 233, 130, 16);
		lblPseudoDjExistant.setVisible(false);
		frame.getContentPane().add(lblPseudoDjExistant);
		
		labelLoginExistant = new JLabel("Nom d'utilisateur déjà existant");
		labelLoginExistant.setForeground(Color.RED);
		labelLoginExistant.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		labelLoginExistant.setBounds(157, 288, 169, 16);
		labelLoginExistant.setVisible(false);
		frame.getContentPane().add(labelLoginExistant);
		
		mdpConfField = new JTextField();
		mdpConfField.setBounds(157, 354, 130, 26);
		frame.getContentPane().add(mdpConfField);
		mdpConfField.setColumns(10);
		
		lblConfirmationMotDe = new JLabel("Confirmation Mdp");
		lblConfirmationMotDe.setBounds(18, 359, 116, 16);
		frame.getContentPane().add(lblConfirmationMotDe);
		
		lblDjUnCompte = new JLabel("Déjà un compte ?");
		lblDjUnCompte.setBounds(18, 505, 120, 16);
		frame.getContentPane().add(lblDjUnCompte);

		btnSeConnecter = new JButton("Se connecter");
		btnSeConnecter.setBounds(157, 500, 117, 29);
		btnSeConnecter.setActionCommand("fenetre connexion");
		btnSeConnecter.addActionListener(controleur);
		frame.getContentPane().add(btnSeConnecter);
		
		labelError = new JLabel("Mot de passes non identiques");
		labelError.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		labelError.setForeground(Color.RED);
		labelError.setBounds(151, 392, 169, 16);
		labelError.setVisible(false);
		frame.getContentPane().add(labelError);
		frame.setVisible(true);

	}
	
	public static void inscription() throws SQLException, RemoteException, ClassNotFoundException {
		
		dB = new DataBaseConnect();
		
		ResultSet rset = dB.query("select login, mdp, pseudo from public.user ");
		ArrayList <Utilisateur> listUtilisateur = new ArrayList<>();
		
		while (rset.next()) {
			listUtilisateur.add(new Utilisateur(rset.getString(1),rset.getString(2),rset.getString(3)));
		}

		
		for(int i=0; i< listUtilisateur.size();i++){
			
			if (listUtilisateur.get(i).getPseudo().equals(pseudoField.getText())){
				labelError.setVisible(false);
				labelLoginExistant.setVisible(false);
				lblPseudoDjExistant.setVisible(true);
			}
			else if (listUtilisateur.get(i).getLogin().equals(utilisateurField.getText())){
				labelError.setVisible(false);
				lblPseudoDjExistant.setVisible(false);
				labelLoginExistant.setVisible(true);
			}
			
			else if(!(mdpField.getText().equals(mdpConfField.getText()))){
				lblPseudoDjExistant.setVisible(false);
				labelLoginExistant.setVisible(false);
				labelError.setVisible(true);
				
			}else {
				dB.modification("INSERT INTO public.user (login, mdp, pseudo) VALUES ('"+ utilisateurField.getText()+"', '"
				+ mdpField.getText()+"', '"+ pseudoField.getText() +"') " );
				frame.dispose();
				new ChatRoomGUI(new Utilisateur(utilisateurField.getText(),mdpField.getText(),pseudoField.getText()));
			}
			
		}
	}
	
	public static void connexion(){
		frame.dispose();
		new UserWindow();
	}

}
