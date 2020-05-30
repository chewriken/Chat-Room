package interfaceGraphique;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.util.Scanner;

public class UserWindow {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
	 	String scann;
	    String passscan;
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserWindow window = new UserWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		


		   
		    Scanner scan = new Scanner(System.in);
		    Scanner scanner = new Scanner(System.in);

		    Scanner name = new Scanner(System.in);
		    System.out.println("Nom d'utilisateur:");
		    User.username = name.next().toLowerCase();

		    Scanner pass = new Scanner(System.in);
		    System.out.println("Mot de passe :");
		    User.password = pass.next().toLowerCase();


		    System.out.println("You are logged in");

	}

	/**
	 * Create the application.
	 */
	public UserWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setSize(400, 600);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(154, 171, 130, 26);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(154, 250, 130, 26);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNomDutilisateur = new JLabel("Nom d'utilisateur :");
		lblNomDutilisateur.setBounds(19, 176, 118, 16);
		frame.getContentPane().add(lblNomDutilisateur);
		
		JLabel lblMotDePasse = new JLabel("Mot de passe :");
		lblMotDePasse.setBounds(19, 255, 123, 16);
		frame.getContentPane().add(lblMotDePasse);
		
		JButton btnConnexion = new JButton("Connexion");
		btnConnexion.setBounds(154, 348, 117, 29);
		frame.getContentPane().add(btnConnexion);
		
		JLabel lblChatRoom = new JLabel("Chat Room");
		lblChatRoom.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblChatRoom.setBounds(154, 38, 98, 16);
		frame.getContentPane().add(lblChatRoom);
		
		JLabel lblUtilisateurOuMdp = new JLabel("Utilisateur ou mdp incorrect");
		lblUtilisateurOuMdp.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		lblUtilisateurOuMdp.setForeground(Color.RED);
		lblUtilisateurOuMdp.setBounds(138, 302, 164, 16);
		lblUtilisateurOuMdp.setVisible(false);
		frame.getContentPane().add(lblUtilisateurOuMdp);
	}

}
