package modele;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;


public class Serveur implements Runnable {
 
	protected int serverPort = 5000;
	protected ServerSocket serverSocket = null;
	protected InetSocketAddress ipAddrAndPort;
	protected boolean isStopped = false;
	protected Thread runningThread = null;

	       public Serveur(int port) throws UnknownHostException{
	           this.serverPort = port;
	           ipAddrAndPort = new InetSocketAddress(InetAddress.getByName("192.168.1.14"),5000);
	       }
	       
	       public Serveur() throws UnknownHostException{
	    	   ipAddrAndPort = new InetSocketAddress(InetAddress.getByName("192.168.1.14"),5000);
	       }

	       public void run(){
	           synchronized(this){
	               this.runningThread = Thread.currentThread();
	           }
	    	   
	           openServerSocket();
	           
	           while(! isStopped()){
	               Socket clientSocket = null;
	               try {
	                   clientSocket = this.serverSocket.accept();
	               } catch (IOException e) {
	                   if(isStopped()) {
	                       System.out.println("Server Stopped.") ;
	                       return;
	                   }
	                   throw new RuntimeException(
	                       "Error accepting client connection", e);
	               }
	               new Thread(
	                   new WorkerRunnable(
	                       clientSocket, "Multithreaded Server")
	               ).start();
	           }
	           System.out.println("Server Stopped.") ;
	       }


	       private synchronized boolean isStopped() {
	           return this.isStopped;
	       }

	       public synchronized void stop(){
	           this.isStopped = true;
	           try {
	               this.serverSocket.close();
	           } catch (IOException e) {
	               throw new RuntimeException("Error closing server", e);
	           }
	       }

	       private void openServerSocket() {
	           try {
	               this.serverSocket = new ServerSocket();
	               this.serverSocket.bind(ipAddrAndPort,1);
	           } catch (IOException e) {
	               throw new RuntimeException("Cannot open port "+ this.serverPort , e);
	           }
	       }

	       
	       public static void main(String[] test) throws UnknownHostException {
			   Serveur server = new Serveur();
			   new Thread(server).start();
			   
			 //lancement dynamique du registre de noms RMI
				try {
					LocateRegistry.createRegistry(1099);
					//instanciation d'un objet de la classe distante
					ChatRoom chatRoomImpl = new ChatRoom();
					//enregistrement dans le registre de noms RMI
					//String url = "rmi://" + InetAddress.getLocalHost().getHostAddress() + "/TP0";
					//System.out.println("Enregistrement de l'objet avec l'url : " + url);
					Naming.rebind("TP0", chatRoomImpl);
					System.out.println("Serveur lanc�");
				} catch (RemoteException e) {
					e.printStackTrace();
				} catch (MalformedURLException e) {
					e.printStackTrace();
				}
				

	       }
}
