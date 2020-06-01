package vue;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import controleur.Controleur;
import modele.Utilisateur;
import javax.swing.JButton;

public class GestionCompte extends JFrame{

	private static JFrame frame;
	private JLabel lblPseudo;
	private JLabel lblLogin;
	private JLabel lblMDP;
	private Controleur controleur;
	
	/**
	 * Initialize the contents of the frame.
	 */
	 public GestionCompte()  {
		 
		controleur = new Controleur();
		frame = new JFrame();
		frame.setTitle("Information du compte");
		frame.setBounds(100, 100, 565, 307);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Pseudo:");
		lblNewLabel.setBounds(47, 48, 63, 40);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Login:");
		lblNewLabel_1.setBounds(47, 98, 80, 40);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Mot de passe:");
		lblNewLabel_2.setBounds(47, 148, 80, 32);
		frame.getContentPane().add(lblNewLabel_2);
		
		JButton btnPseudo = new JButton("Modifier le pseudo");
		btnPseudo.setActionCommand("fenetre pseudo");
		btnPseudo.addActionListener(controleur);
		btnPseudo.setBounds(283, 58, 161, 21);
		frame.getContentPane().add(btnPseudo);
		
		JButton btnLogin = new JButton("Modifier le login");
		btnLogin.setActionCommand("fenetre login");
		btnLogin.addActionListener(controleur);
		btnLogin.setBounds(283, 108, 141, 21);
		frame.getContentPane().add(btnLogin);
		
		JButton bntMDP = new JButton("Modifer le mot de passe");
		bntMDP.setActionCommand("fenetre mdp");
		bntMDP.addActionListener(controleur);
		bntMDP.setBounds(283, 153, 194, 22);
		frame.getContentPane().add(bntMDP);
		
		Utilisateur user = ChatRoomGUI.getUser();
		
		lblPseudo = new JLabel(user.getPseudo());
		lblPseudo.setBounds(111, 53, 131, 31);
		frame.getContentPane().add(lblPseudo);
		
		lblLogin = new JLabel(user.getLogin());
		lblLogin.setBounds(111, 105, 131, 26);
		frame.getContentPane().add(lblLogin);
		
		lblMDP = new JLabel(user.getMdp());
		lblMDP.setBounds(137, 148, 131, 32);
		frame.getContentPane().add(lblMDP);
		
		JButton btnFermer = new JButton("Fermer");
		btnFermer.setBounds(47, 211, 85, 21);
		btnFermer.setActionCommand("fermeture");
		btnFermer.addActionListener(controleur);
		frame.getContentPane().add(btnFermer);
		
		frame.setVisible(true);
	}
	
	public static void FenetrePseudo(){
		new NouveauPseudo();
	}
	
	public static void FenetreLogin(){
		new NouveauLogin();
	}
	
	public static void FenetreMDP(){
		new NouveauMdp();
	}
	
	public static void FenetreGestion(){
		new GestionCompte();
	}
	
	public static void Fermeture(){
		frame.dispose();
	}
}
