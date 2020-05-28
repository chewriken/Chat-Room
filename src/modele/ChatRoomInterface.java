package modele;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ChatRoomInterface extends Remote{
	public void inscription(UtilisateurInterface user, String pseudo) throws RemoteException ;
	public void desinscription(String pseudo) throws RemoteException ;
	public void postMessage(String pseudo, String message) throws RemoteException ;
}