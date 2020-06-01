package vue;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTextField;
import controleur.Controleur;
import modele.DataBaseConnect;
import modele.Utilisateur;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.sql.SQLException;

import javax.swing.JButton;

public class NouveauPseudo extends JFrame {
	private static JFrame frame;
	private JTextField ancienPseudoField;
	private Controleur controleur;
	private static JTextField nouveauPseudoField;
	private static DataBaseConnect dB;

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
		
		ancienPseudoField = new JTextField();
		ancienPseudoField.setBounds(154, 192, 130, 26);
		frame.getContentPane().add(ancienPseudoField);
		ancienPseudoField.setColumns(10);
		
		nouveauPseudoField = new JTextField();
		nouveauPseudoField.setBounds(154, 255, 130, 26);
		frame.getContentPane().add(nouveauPseudoField);
		nouveauPseudoField.setColumns(10);
		
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
		btnChangerPseudo.setActionCommand("Changement pseudo");
		btnChangerPseudo.addActionListener(controleur);
		frame.getContentPane().add(btnChangerPseudo);
		frame.setVisible(true);
	}
	
	public static void changementPseudo() throws ClassNotFoundException, SQLException{
		dB = new DataBaseConnect();
		Utilisateur user = ChatRoomGUI.getUser();
		dB.modification("update publis.user set pseudo = '" + nouveauPseudoField.getText() +"' where pseudo = '" + user.getPseudo());
		JOptionPane.showMessageDialog(frame, "pseudo modifié");
		frame.dispose();	
	}
}
