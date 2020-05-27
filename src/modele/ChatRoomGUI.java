package modele;

import java.io.IOException;
import java.net.Socket;
import java.rmi.RemoteException;

public class ChatRoomGUI{
	
	public ChatRoomGUI() {
			int max = 10; 
	        int min = 1; 
	        int range = max - min + 1; 
			int i = (int)(Math.random()*range);
			try {
				final Socket clientSocket = new Socket("127.0.0."+i,5000);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
	 
	}

	public void display(String message) throws RemoteException {
		System.out.println(message);
	}
	
   public static void main(String[] args) throws RemoteException {
      
	 
	  ChatRoomGUI interfaceG = new ChatRoomGUI();
	  Utilisateur user = new Utilisateur(interfaceG,"jo","jo");
      user.displayMessage("salut bg");
	  

  }
}
