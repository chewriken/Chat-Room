package modele;

import java.rmi.RemoteException;

/**
 * <b> Classe qui permet de gérer les paramètres de l'Utilisateur </b>
 * @author adilbahou
 *
 */
public class Utilisateur extends UnicastRemoteObject implements UtilisateurInterface {

	private ChatRoomGUI ig;
	private String login;
	private String mdp;
	private String pseudo;
	
	/**
	 * 
	 * @param login
	 * @param mdp
	 * @param pseudo
	 */
	public Utilisateur(String login, String mdp, String pseudo) throws RemoteException {
		super();
		this.login = login;
		this.mdp = mdp;
		this.setPseudo(pseudo);
	}
	
	protected Utilisateur() throws RemoteException {
		super();
	}
	
	public void setIg(ChatRoomGUI ig) {
		this.ig = ig;
	}

	@Override
	public void displayMessage(String message) throws RemoteException  {
		ig.display(message);
	}

	public void displayMessage2(String message) throws RemoteException  {
		ig.display2(message);
	}
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
}
