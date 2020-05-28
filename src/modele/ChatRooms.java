package modele;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ChatRooms extends Remote{
	public void subscribe(Utilisateur user, String pseudo) throws RemoteException;
	public void unsubscribe(String pseudo) throws RemoteException;
	public void postMessage(String pseudo, String message) throws RemoteException;
}
