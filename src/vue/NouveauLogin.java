package vue;

import javax.swing.JFrame;
import controleur.Controleur;
import modele.DataBaseConnect;
import modele.Utilisateur;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import java.sql.SQLException;
/**
 * Classe permettant le changement de login avec l'interface correspondante
 */
public class NouveauLogin extends JFrame {
	private static JFrame frame;
	private JLabel oldLoginField;
	private static JTextField newLoginField;
	private Controleur controleur;
	private static DataBaseConnect dB;
	private JButton btnRetour;


	/**
	 * Create the frame.
	 */
	public NouveauLogin() {
		
		controleur = new Controleur();
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setSize(400, 600);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		Utilisateur user = ChatRoomGUI.getUser();
		
		oldLoginField = new JLabel(user.getLogin());
		oldLoginField.setBounds(224, 217, 130, 26);
		frame.getContentPane().add(oldLoginField);
		
		newLoginField = new JTextField();
		newLoginField.setBounds(224, 267, 130, 26);
		frame.getContentPane().add(newLoginField);
		newLoginField.setColumns(10);
		
		JLabel labelOldLogin = new JLabel("Ancien Nom d'utilisateur :");
		labelOldLogin.setBounds(30, 217, 170, 16);
		frame.getContentPane().add(labelOldLogin);
		
		JLabel labelNewLogin = new JLabel("Nouveau Nom d'utilisateur :");
		labelNewLogin.setBounds(30, 272, 182, 16);
		frame.getContentPane().add(labelNewLogin);
		
		JButton btnConfirmer = new JButton("Confirmer");
		btnConfirmer.setBounds(142, 369, 117, 29);
		btnConfirmer.setActionCommand("changement login");
		btnConfirmer.addActionListener(controleur);
		frame.getContentPane().add(btnConfirmer);
		
		JLabel lblModificationNomDutilisateur = new JLabel("Modification Nom d'utilisateur");
		lblModificationNomDutilisateur.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblModificationNomDutilisateur.setBounds(83, 61, 222, 16);
		frame.getContentPane().add(lblModificationNomDutilisateur);		
		
		btnRetour = new JButton("Retour");
		btnRetour.setBounds(18, 468, 117, 29);
		btnRetour.setActionCommand("retour login");
		btnRetour.addActionListener(controleur);
		frame.getContentPane().add(btnRetour);
		frame.setVisible(true);
	}
	
	public static void changementLogin() throws ClassNotFoundException, SQLException{
		dB = new DataBaseConnect();
		Utilisateur user = ChatRoomGUI.getUser();
		dB.modification("update public.user set login = '" + newLoginField.getText() +"' where login = '" + user.getLogin() + "'");
		dB.modification("update public.chat set login = '" + newLoginField.getText() +"' where login = '" + user.getLogin() + "'");
		JOptionPane.showMessageDialog(frame, "login modifié");
		frame.dispose();	
	}
	
	public static void fermeture(){
		frame.dispose();
	}
}
