package modele;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Enumeration;
import java.util.Hashtable;


/**
 * <b> Cette classe gère la salle de Chat </b>
 * 
 *  
 * 
 * @author adilbahou
 *
 */
public class ChatRoom extends UnicastRemoteObject implements ChatRoomInterface{

	Hashtable<String, UtilisateurInterface> utilisateurs;
	
	protected ChatRoom() throws RemoteException {
		super();
		utilisateurs = new Hashtable<String, UtilisateurInterface>();
	}
	/**
	 * Méthode utilisée lorsque l'utilisateur entre ses identifiants pour se connecter
	 * @param user
	 * @param pseudo
	 */
	public void inscription(UtilisateurInterface user, String pseudo) throws RemoteException  {
		if(!utilisateurs.containsKey(pseudo)){
			utilisateurs.put(pseudo, user);
			this.messageInscription(pseudo, "connected");
		} 
	}

	/** 
	 * Cette méthode est utilisée pour déconnecter l'utilisateur
	 * @param pseudo
	 */
	public void desinscription(String pseudo) throws RemoteException {
		String message = pseudo+" disconnected";
		if(utilisateurs.containsKey(pseudo)){
			utilisateurs.remove(pseudo);
			this.messageInscription(pseudo, message);
		}
	}
	/** 
	 * Méthode permettant de poster le message sur l'interface
	 * @param pseudo
	 * @param message
	 */
	public void postMessage(String pseudo, String message) throws RemoteException  {
		String messageEntier = pseudo + " : \n" + message + " \n ";
		System.out.println(messageEntier);
		Enumeration<UtilisateurInterface> e = utilisateurs.elements();
		while(e.hasMoreElements()){
			UtilisateurInterface user = (UtilisateurInterface)e.nextElement();
			user.displayMessage(messageEntier);
		}
	}
	/**
	 * Méthode qui permet d'afficher la connexion d'un nouvel utilisateur
	 * @param pseudo
	 * @param message
	 */
	private void messageInscription(String pseudo, String message) throws RemoteException {
		String messageEntier = pseudo + " >>> " +message;
		System.out.println(messageEntier);
		Enumeration<UtilisateurInterface> e = utilisateurs.elements();
		while(e.hasMoreElements()){
			UtilisateurInterface user = (UtilisateurInterface)e.nextElement();
			user.displayMessage2(messageEntier);
		}
		
	}

	
}
