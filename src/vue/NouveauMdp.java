package vue;


import javax.swing.JFrame;
import controleur.Controleur;
import modele.DataBaseConnect;
import modele.Utilisateur;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.sql.SQLException;
import javax.swing.JButton;
import java.awt.Color;

public class NouveauMdp extends JFrame {

	private static JFrame frame;
	private static JLabel ancienMDPField;
	private static JTextField nouveauMDPField;
	private static JTextField confirmPasswordField;
	private static JLabel lblPasswordFalse;
	private Controleur controleur;
	private static DataBaseConnect dB;
	

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
		
		Utilisateur user = ChatRoomGUI.getUser();
		
		ancienMDPField = new JLabel(user.getMdp());
		ancienMDPField.setBounds(244, 204, 130, 26);
		frame.getContentPane().add(ancienMDPField);
		
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
		btnConfirmerNewPassword.setActionCommand("changement mdp");
		btnConfirmerNewPassword.addActionListener(controleur);
		btnConfirmerNewPassword.setBounds(137, 416, 117, 29);
		frame.getContentPane().add(btnConfirmerNewPassword);
		
		confirmPasswordField = new JTextField();
		confirmPasswordField.setBounds(244, 330, 130, 26);
		frame.getContentPane().add(confirmPasswordField);
		confirmPasswordField.setColumns(10);
		
		JLabel lblConfirmerNewPassword = new JLabel("Confirmer Mot de Passe :");
		lblConfirmerNewPassword.setBounds(27, 335, 165, 16);
		frame.getContentPane().add(lblConfirmerNewPassword);
		
		lblPasswordFalse = new JLabel("Mot de passe non identique");
		lblPasswordFalse.setForeground(Color.RED);
		lblPasswordFalse.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		lblPasswordFalse.setBounds(114, 384, 166, 16);
		lblPasswordFalse.setVisible(false);
		frame.getContentPane().add(lblPasswordFalse);
		
		JButton btnRetour = new JButton("Retour");
		btnRetour.setBounds(27, 490, 117, 29);
		btnRetour.setActionCommand("retour mdp");
		btnRetour.addActionListener(controleur);
		frame.getContentPane().add(btnRetour);
		
		frame.setVisible(true);
	}

	public static void changementMDP() throws ClassNotFoundException, SQLException {
		
		if(nouveauMDPField.getText().equals(confirmPasswordField.getText())){
			dB = new DataBaseConnect();
			Utilisateur user = ChatRoomGUI.getUser();
			dB.modification("update public.user set mdp = '" + nouveauMDPField.getText() +"' where login = '" + user.getLogin()+ "'");
			JOptionPane.showMessageDialog(frame, "mdp modifié");
			frame.dispose();
		}
		else{
			lblPasswordFalse.setVisible(true);
		}
	}
	
	public static void fermeture(){
		frame.dispose();
	}
}
