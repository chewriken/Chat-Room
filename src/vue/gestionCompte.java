package ihm;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class gestionCompte {

	private JFrame frmInformationDuCompte;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gestionCompte window = new gestionCompte();
					window.frmInformationDuCompte.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public gestionCompte() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmInformationDuCompte = new JFrame();
		frmInformationDuCompte.setTitle("Information du compte");
		frmInformationDuCompte.setBounds(100, 100, 565, 307);
		frmInformationDuCompte.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmInformationDuCompte.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Pseudo:");
		lblNewLabel.setBounds(47, 48, 63, 40);
		frmInformationDuCompte.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Login:");
		lblNewLabel_1.setBounds(47, 98, 80, 40);
		frmInformationDuCompte.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Mot de passe:");
		lblNewLabel_2.setBounds(47, 148, 80, 32);
		frmInformationDuCompte.getContentPane().add(lblNewLabel_2);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(118, 56, 131, 22);
		frmInformationDuCompte.getContentPane().add(textArea);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(118, 106, 131, 22);
		frmInformationDuCompte.getContentPane().add(textArea_1);
		
		JTextArea textArea_2 = new JTextArea();
		textArea_2.setBounds(135, 152, 131, 22);
		frmInformationDuCompte.getContentPane().add(textArea_2);
		
		JButton btnNewButton = new JButton("Modifier le pseudo");
		btnNewButton.setBounds(25, 210, 161, 21);
		frmInformationDuCompte.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Modifier le login");
		btnNewButton_1.setBounds(196, 210, 141, 21);
		frmInformationDuCompte.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Modifer le mot de passe");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.setBounds(347, 209, 194, 22);
		frmInformationDuCompte.getContentPane().add(btnNewButton_2);
	}
}
