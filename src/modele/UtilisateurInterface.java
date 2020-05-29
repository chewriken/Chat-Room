package modele;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface UtilisateurInterface extends Remote {
	public void displayMessage(String message) throws RemoteException;
	public void displayMessage2(String message) throws RemoteException;
}
