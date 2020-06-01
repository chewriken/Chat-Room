package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.sql.SQLException;
import vue.GestionCompte;
import vue.InscriptionWindow;
import vue.NouveauLogin;
import vue.NouveauMdp;
import vue.NouveauPseudo;
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
			
			case "changement login":
				try {
					NouveauLogin.changementLogin();
				} catch (ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				}
			break;
			
			case "changement pseudo":
				try {
					NouveauPseudo.changementPseudo();
				} catch (ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				}
			break;
				
			case "changement mdp":
				try {
					NouveauMdp.changementMDP();
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			break;
			
			case "fenetre pseudo":
				GestionCompte.FenetrePseudo();
			break;
			
			case "fenetre login":
				GestionCompte.FenetreLogin();
			break;
				
			case "fenetre mdp":
				GestionCompte.FenetreMDP();
			break;
			
			case "compte":
				GestionCompte.FenetreGestion();
			break;
			
		}
		
	}
	
	
}
