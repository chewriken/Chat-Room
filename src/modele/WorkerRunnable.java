package modele;

import java.net.Socket;

/*
 * Thread permettant l'affichage du statut du client (connecté)
 */
public class WorkerRunnable implements Runnable{

    protected Socket clientSocket = null;
    protected String serverText   = null;
    /**
     * @param clientSocket
     * @param serverText
     */
    public WorkerRunnable(Socket clientSocket, String serverText) {
        this.clientSocket = clientSocket;
        this.serverText   = serverText;
    }

    public void run() {
    	System.out.println("client connectÃ©");
    }
}
