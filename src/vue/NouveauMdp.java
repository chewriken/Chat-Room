package interfaceGraphique;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;

public class NouveauMdp extends JFrame {

	private JPanel contentPane;
	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField confirmPasswordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NouveauMdp frame = new NouveauMdp();
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
	public NouveauMdp() {
		
		controleur = new Controleur();
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setSize(400, 600);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		textField = new JTextField();
		textField.setBounds(244, 204, 130, 26);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(244, 280, 130, 26);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel labelOldPassword = new JLabel("Ancien Mot de passe :");
		labelOldPassword.setBounds(35, 209, 157, 16);
		frame.getContentPane().add(labelOldPassword);
		
		JLabel lblNouveauMotDe = new JLabel("Nouveau Mot de Passe :");
		lblNouveauMotDe.setBounds(35, 285, 157, 16);
		frame.getContentPane().add(lblNouveauMotDe);
		
		JLabel lblModificationMotDe = new JLabel("Modification Mot de Passe");
		lblModificationMotDe.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblModificationMotDe.setBounds(103, 64, 200, 16);
		frame.getContentPane().add(lblModificationMotDe);
		
		JButton btnConfirmerNewPassword = new JButton("Confirmer");
		btnConfirmerNewPassword.setBounds(137, 416, 117, 29);
		frame.getContentPane().add(btnConfirmerNewPassword);
		
		confirmPasswordField = new JTextField();
		confirmPasswordField.setBounds(244, 330, 130, 26);
		frame.getContentPane().add(confirmPasswordField);
		confirmPasswordField.setColumns(10);
		
		JLabel lblConfirmerNewPassword = new JLabel("Confirmer Mot de Passe :");
		lblConfirmerNewPassword.setBounds(27, 335, 165, 16);
		frame.getContentPane().add(lblConfirmerNewPassword);
		
		JLabel lblPasswordFalse = new JLabel("Mot de passe non identique");
		lblPasswordFalse.setForeground(Color.RED);
		lblPasswordFalse.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		lblPasswordFalse.setBounds(114, 384, 166, 16);
		frame.getContentPane().add(lblPasswordFalse);
		
		frame.setVisible(true);
	}
}
