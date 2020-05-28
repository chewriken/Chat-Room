package modele;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatRoomGUI{
	
	private String title = "Logiciel de discussion en ligne";
    private String pseudo = null;
    private ChatRoomInterface room = null;
    
    private JFrame frame = new JFrame(this.title);
    private JTextArea txtOutput = new JTextArea();
    private JTextField txtMessage = new JTextField();
    private JButton btnSend = new JButton("Envoyer");
    Utilisateur user;
	
	public ChatRoomGUI() throws RemoteException {
		
		this.createIHM();
		int max = 10; 
	    int min = 1; 
	    int range = max - min + 1; 
		int i = (int)(Math.random()*range);
		
		try {
			final Socket clientSocket = new Socket("127.0.0."+i,5000);
			user = new Utilisateur();
        	user.setIg(this);
        	
			//obtention d'une r�f�rence sur l'objet distant � partir de son nom
			Remote r = Naming.lookup("TP0");
			this.room = (ChatRoomInterface)r;
			this.requestPseudo();
		} catch (MalformedURLException e) {
			System.out.println("Impossible de joindre la salle de discussion");
			System.exit(0);
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	 
	}
	
	public void createIHM() {
        // Assemblage des composants
        JPanel panel = (JPanel)this.frame.getContentPane();
        JScrollPane sclPane = new JScrollPane(txtOutput);
        panel.add(sclPane, BorderLayout.CENTER);
        JPanel southPanel = new JPanel(new BorderLayout());
        southPanel.add(this.txtMessage, BorderLayout.CENTER);
        southPanel.add(this.btnSend, BorderLayout.EAST);
        panel.add(southPanel, BorderLayout.SOUTH);

        // Gestion des �v�nements
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                try {
					window_windowClosing(e);
				} catch (RemoteException e1) {
					e1.printStackTrace();
				}
            }
        });
        btnSend.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btnSend_actionPerformed(e);
            }
        });
	txtMessage.addKeyListener(new KeyAdapter() {
		public void keyReleased(KeyEvent event) {
			if (event.getKeyChar() == '\n')
			    btnSend_actionPerformed(null);
		    }
	});

        // Initialisation des attributs
        this.txtOutput.setBackground(new Color(220,220,220));
        this.txtOutput.setEditable(false);
		this.frame.setSize(500,400);
        this.frame.setVisible(true);
        this.txtMessage.requestFocus();
    }

	/*public void display(String message) throws RemoteException {
		System.out.println(message);
	}*/
	
	//inscription
    public void requestPseudo() throws RemoteException {
        this.pseudo = JOptionPane.showInputDialog(
            this.frame, "Entrez votre pseudo : ",
            this.title,  JOptionPane.OK_OPTION
        );
        if (this.pseudo == null) System.exit(0);
        this.room.inscription(user, pseudo);
        
    }
    
    //desinscription
    public void window_windowClosing(WindowEvent e) throws RemoteException {
    	this.room.desinscription(pseudo);
    	System.exit(-1);
    }
    
    //envoi message
    public void btnSend_actionPerformed(ActionEvent e) {
    	try {
			this.room.postMessage(this.pseudo, this.txtMessage.getText());
		} catch (RemoteException e1) {
			e1.printStackTrace();
			System.out.println("Impossible d envoyer le message");
		}
    	this.txtMessage.setText("");
        this.txtMessage.requestFocus();
    }


	public void display(String message) throws RemoteException {
		this.txtOutput.append(message +" \n");
		this.txtOutput.moveCaretPosition(this.txtOutput.getText().length());
	}
	
	public static void main(String[] args) throws RemoteException {
	  /*ChatRoomGUI interfaceG = new ChatRoomGUI();
	  Utilisateur user = new Utilisateur(interfaceG,"jo","jo");
      user.displayMessage("salut bg");*/
		new ChatRoomGUI();
	}
}
