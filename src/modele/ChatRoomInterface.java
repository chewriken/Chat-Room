package modele;

import java.rmi.RemoteException;

public interface ChatRoomInterface{
	public void inscription(Utilisateur user, String pseudo) throws RemoteException ;
	public void desinscription(String pseudo) throws RemoteException ;
	public void postMessage(String pseudo, String message) throws RemoteException ;
}