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
	private JLabel ancienPseudoField;
	private Controleur controleur;
	private static JTextField nouveauPseudoField;
	private static DataBaseConnect dB;


	/**
	 * Create the frame.
	 */
	public NouveauPseudo() {
		
		controleur = new Controleur();
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);	
		frame.setSize(400, 600);		
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		Utilisateur user = ChatRoomGUI.getUser();
		
		ancienPseudoField = new JLabel(user.getPseudo());
		ancienPseudoField.setBounds(154, 192, 130, 26);
		frame.getContentPane().add(ancienPseudoField);
		
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
		btnChangerPseudo.setActionCommand("changement pseudo");
		btnChangerPseudo.addActionListener(controleur);
		frame.getContentPane().add(btnChangerPseudo);
		
		JButton btnRetour = new JButton("Retour");
		btnRetour.setBounds(18, 468, 117, 29);
		btnRetour.setActionCommand("retour pseudo");
		btnRetour.addActionListener(controleur);
		frame.getContentPane().add(btnRetour);
		frame.setVisible(true);
	}
	
	public static void changementPseudo() throws ClassNotFoundException, SQLException{
		dB = new DataBaseConnect();
		Utilisateur user = ChatRoomGUI.getUser();
		dB.modification("update public.user set pseudo = '" + nouveauPseudoField.getText() +"' where login = '" + user.getLogin() + "'");
		JOptionPane.showMessageDialog(frame, "pseudo modifié");
		frame.dispose();	
	}
	
	public static void fermeture(){
		frame.dispose();
	}
}
