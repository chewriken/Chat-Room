package ihm;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GestionnaireWindow {

	private JFrame frmInformationDuCompte;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestionnaireWindow window = new GestionnaireWindow();
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
	public GestionnaireWindow() {
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
		
		JButton btnNewButton = new JButton("Modifier le pseudo");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(283, 58, 161, 21);
		frmInformationDuCompte.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Modifier le login");
		btnNewButton_1.setBounds(283, 108, 141, 21);
		frmInformationDuCompte.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Modifer le mot de passe");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.setBounds(283, 153, 194, 22);
		frmInformationDuCompte.getContentPane().add(btnNewButton_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(111, 53, 131, 31);
		frmInformationDuCompte.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setBounds(111, 105, 131, 26);
		frmInformationDuCompte.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setBounds(137, 148, 131, 32);
		frmInformationDuCompte.getContentPane().add(lblNewLabel_5);
		
		JButton btnNewButton_3 = new JButton("Fermer");
		btnNewButton_3.setBounds(47, 211, 85, 21);
		frmInformationDuCompte.getContentPane().add(btnNewButton_3);
	}
}
