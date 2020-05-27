package modele;

import java.rmi.RemoteException;

public class Utilisateur implements UtilisateurInterface {

	private ChatRoomGUI ig;
	private String login;
	private String mdp;
	
	protected Utilisateur(ChatRoomGUI interfaceGraphique,String login, String mdp) {
		this.ig = interfaceGraphique;
		this.setLogin(login);
		this.setMdp(mdp);
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
