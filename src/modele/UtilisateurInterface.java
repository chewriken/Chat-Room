package modele;

import java.rmi.Remote;
import java.rmi.RemoteException;
/*
 * Cr�ation de l'interface permettant d'afficher les messages  
 */
public interface UtilisateurInterface extends Remote {
	public void displayMessage(String message) throws RemoteException;
	public void displayMessage2(String message) throws RemoteException;
}
