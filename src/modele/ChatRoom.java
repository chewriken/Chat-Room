package modele;

import java.rmi.RemoteException;
import java.util.Enumeration;
import java.util.Hashtable;

public class ChatRoom implements ChatRoomInterface{

	Hashtable<String, Utilisateur> utilisateurs;
	
	protected ChatRoom() throws RemoteException {
		super();
		utilisateurs = new Hashtable<String, Utilisateur>();
	}

	
	public void inscription(Utilisateur user, String pseudo) throws RemoteException  {
		if(!utilisateurs.containsKey(pseudo)){
			utilisateurs.put(pseudo, user);
			this.postMessage(pseudo, "connected");
		} 
	}

	public void desinscription(String pseudo) throws RemoteException {
		String message = pseudo+" disconnected";
		if(utilisateurs.containsKey(pseudo)) {
			utilisateurs.remove(pseudo);
			this.postMessage(pseudo, message);
		}
	}

	public void postMessage(String pseudo, String message) throws RemoteException  {
		String messageEntier = pseudo+" >>>> "+message;
		System.out.println(messageEntier);
		Enumeration<Utilisateur> e = utilisateurs.elements();
		while(e.hasMoreElements()){
			Utilisateur user = (Utilisateur)e.nextElement();
			user.displayMessage(messageEntier);
		}
	}

	
}
