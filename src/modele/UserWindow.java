package modele;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTextField;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class UserWindow implements ActionListener {

	private JFrame frame;
	private JTextField loginField;
	private JTextField mdpField;
	private DataBaseConnect dB;
	private JLabel lblUtilisateurOuMdp;
	private JButton btnConnexion;
 

 /**

* Launch the application.

*/

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserWindow window = new UserWindow();
					window.frame.setVisible(true);
				
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}	
		});

	}
	

	 /**
	
	* Create the application.
	
	*/
	
	public UserWindow() {
		initialize();
	}
	
	
	 
	 /**
	
	* Initialize the contents of the frame.
	
	*/
	
	private void initialize() {
	
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);	
		frame.setSize(400, 600);		
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		loginField = new JTextField();
		loginField.setBounds(154, 171, 130, 26);
		frame.getContentPane().add(loginField);
		loginField.setColumns(10);
		
		mdpField = new JTextField();
		mdpField.setBounds(154, 250, 130, 26);
		frame.getContentPane().add(mdpField);
		mdpField.setColumns(10);
		
		JLabel lblNomDutilisateur = new JLabel("Nom d'utilisateur :");
		lblNomDutilisateur.setBounds(19, 176, 118, 16);
		frame.getContentPane().add(lblNomDutilisateur);
		
		JLabel lblMotDePasse = new JLabel("Mot de passe :");
		lblMotDePasse.setBounds(19, 255, 123, 16);
		frame.getContentPane().add(lblMotDePasse);
		
		btnConnexion = new JButton("Connexion");
		btnConnexion.setBounds(154, 348, 117, 29);
		btnConnexion.addActionListener(this);
		frame.getContentPane().add(btnConnexion);
		
		JLabel lblChatRoom = new JLabel("Chat Room");
		lblChatRoom.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblChatRoom.setBounds(154, 38, 98, 16);
		frame.getContentPane().add(lblChatRoom);
		
		lblUtilisateurOuMdp = new JLabel("Login ou mot de passe incorrect");
		lblUtilisateurOuMdp.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		lblUtilisateurOuMdp.setForeground(Color.RED);
		lblUtilisateurOuMdp.setBounds(138, 302, 164, 16);
		lblUtilisateurOuMdp.setVisible(false);
		frame.getContentPane().add(lblUtilisateurOuMdp);
	}
	
	 
	
	public void connexion() throws SQLException, RemoteException, ClassNotFoundException {
	
		dB = new DataBaseConnect();
		ResultSet rset = dB.query("select login, mdp, pseudo from public.user ");
		
		ArrayList <Utilisateur> listUtilisateur = new ArrayList<>();

		while (rset.next()) {
			listUtilisateur.add(new Utilisateur(rset.getString(1),rset.getString(2),rset.getString(3)));
		}

		
		for(int i=0; i< listUtilisateur.size();i++){
			if (listUtilisateur.get(i).getLogin().equals(loginField.getText()) && listUtilisateur.get(i).getMdp().equals(mdpField.getText())){
				frame.dispose();
				new ChatRoomGUI(listUtilisateur.get(i));
			}
			
			else{ lblUtilisateurOuMdp.setVisible(true); }
		}
	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		if(evt.getSource() == btnConnexion){
			try {
				connexion();
			} catch (RemoteException | SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	 
	
	 


 

}