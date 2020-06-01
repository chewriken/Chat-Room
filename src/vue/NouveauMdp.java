package vue;


import java.awt.EventQueue;

import javax.swing.JFrame;


import modele.DataBaseConnect;
import modele.Utilisateur;

import javax.swing.JTextField;

import controleur.Controleur;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.SQLException;

import javax.swing.JButton;

public class NouveauMdp extends JFrame {

	private static JFrame frame;
	private JTextField ancienMDPField;
	private static JTextField nouveauMDPField;
	private static DataBaseConnect dB;
	private Controleur controleur;

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
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setSize(400, 600);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		ancienMDPField = new JTextField();
		ancienMDPField.setBounds(244, 204, 130, 26);
		frame.getContentPane().add(ancienMDPField);
		ancienMDPField.setColumns(10);
		
		nouveauMDPField = new JTextField();
		nouveauMDPField.setBounds(244, 280, 130, 26);
		frame.getContentPane().add(nouveauMDPField);
		nouveauMDPField.setColumns(10);
		
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
		btnConfirmerNewPassword.setBounds(137, 390, 117, 29);
		btnConfirmerNewPassword.setActionCommand("Changement mdp");
		btnConfirmerNewPassword.addActionListener(controleur);
		frame.getContentPane().add(btnConfirmerNewPassword);
		
		frame.setVisible(true);
	}
	
	public static void changementMDP() throws ClassNotFoundException, SQLException{
		dB = new DataBaseConnect();
		Utilisateur user = ChatRoomGUI.getUser();
		dB.modification("update publis.user set mdp = '" + nouveauMDPField.getText() +"' where mdp = '" + user.getMdp());
		JOptionPane.showMessageDialog(frame, "mot de passe modifié");
		frame.dispose();	
	}

}
