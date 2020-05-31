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

public class NouveauPseudo extends JFrame {
	private JFrame frame;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NouveauPseudo frame = new NouveauPseudo();
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
	public NouveauPseudo() {
		getContentPane().setLayout(null);
		

		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);	
		frame.setSize(400, 600);		
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(154, 192, 130, 26);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(154, 255, 130, 26);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel labelAncienPseudo = new JLabel("Ancien Pseudo :");
		labelAncienPseudo.setBounds(18, 197, 124, 16);
		frame.getContentPane().add(labelAncienPseudo);
		
		JLabel labelNewPseudo = new JLabel("Nouveau pseudo :");
		labelNewPseudo.setBounds(18, 260, 124, 16);
		frame.getContentPane().add(labelNewPseudo);
		
		JLabel lblModificationPseudo = new JLabel("Modification Pseudo");
		lblModificationPseudo.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblModificationPseudo.setBounds(126, 60, 151, 16);
		frame.getContentPane().add(lblModificationPseudo);
		
		JButton btnChangerPseudo = new JButton("Confirmer");
		btnChangerPseudo.setBounds(139, 320, 145, 29);
		frame.getContentPane().add(btnChangerPseudo);
		frame.setVisible(true);
	}
}
