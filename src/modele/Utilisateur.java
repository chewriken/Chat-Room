package modele;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Utilisateur extends UnicastRemoteObject implements UtilisateurInterface {

	private ChatRoomGUI ig;
	private String login;
	private String mdp;
	
	protected Utilisateur(String login, String mdp) throws RemoteException {
		super();
		this.login = login;
		this.mdp = mdp;
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
}
