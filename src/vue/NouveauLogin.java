package interfaceGraphique;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;

public class NouveauLogin extends JFrame {
	private JFrame frame;
	private JPanel contentPane;
	private JTextField OldLoginField;
	private JTextField NewLoginField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NouveauLogin frame = new NouveauLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public NouveauLogin() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setSize(400, 600);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		OldLoginField = new JTextField();
		OldLoginField.setBounds(224, 217, 130, 26);
		frame.getContentPane().add(OldLoginField);
		OldLoginField.setColumns(10);
		
		NewLoginField = new JTextField();
		NewLoginField.setBounds(224, 267, 130, 26);
		frame.getContentPane().add(NewLoginField);
		NewLoginField.setColumns(10);
		
		JLabel labelOldLogin = new JLabel("Ancien Nom d'utilisateur :");
		labelOldLogin.setBounds(30, 217, 170, 16);
		frame.getContentPane().add(labelOldLogin);
		
		JLabel labelNewLogin = new JLabel("Nouveau Nom d'utilisateur :");
		labelNewLogin.setBounds(30, 272, 182, 16);
		frame.getContentPane().add(labelNewLogin);
		
		JButton btnConfirmer = new JButton("Confirmer");
		btnConfirmer.setBounds(142, 369, 117, 29);
		frame.getContentPane().add(btnConfirmer);
		
		JLabel lblModificationNomDutilisateur = new JLabel("Modification Nom d'utilisateur");
		lblModificationNomDutilisateur.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblModificationNomDutilisateur.setBounds(83, 61, 222, 16);
		frame.getContentPane().add(lblModificationNomDutilisateur);
	
		
		frame.setVisible(true);
		
		
	}

}
