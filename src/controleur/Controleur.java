package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.sql.SQLException;

import vue.InscriptionWindow;
import vue.UserWindow;

public class Controleur implements ActionListener {
	
	public Controleur (){
		
	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		switch(evt.getActionCommand()){
			case "connexion":
				try {
					UserWindow.connexion();
				} catch (RemoteException | SQLException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			break;
			
			case "fenetre inscription":
				UserWindow.inscription();
			break;

			case "inscription":
				try {
					InscriptionWindow.inscription();
				} catch (RemoteException | ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				}
			break;

			case "fenetre connexion":
				InscriptionWindow.connexion();
			break;
			
		}
		
	}
	
	
}
