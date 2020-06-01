package vue;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import modele.ChatRoomInterface;
import modele.Utilisateur;

public class ChatRoomGUI{
	
	private String title = "Chat Room";
    private ChatRoomInterface room = null;
    protected Socket clientSocket = new Socket(); 
    private static Utilisateur user;
    
    private JFrame frame = new JFrame(this.title);
    private JTextArea messageArea = new JTextArea();
    private JTextArea userArea = new JTextArea();
    private JTextField txtEcrivezVotreMessage = new JTextField();
    private JButton btnSend = new JButton("Envoyer");
    
	public ChatRoomGUI(Utilisateur utilisateur) throws RemoteException {
		
		try {
			InetSocketAddress localIpAddrAndPort = new InetSocketAddress(5000);
			InetSocketAddress serverIpAddrAndPort = new InetSocketAddress(InetAddress.getByName("192.168.1.14"),5000);
			clientSocket.connect(serverIpAddrAndPort);
			user = utilisateur;
        	user.setIg(this);
        	
			//obtention d'une r�f�rence sur l'objet distant � partir de son nom
			Remote r = Naming.lookup("TP0");
			this.room = (ChatRoomInterface)r;
			 this.room.inscription(user, user.getPseudo());
			this.initialize();
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
	
		
		/**
		 * Initialize the contents of the frame.
		 */
		private void initialize() {
			
			// Assemblage des composants
			
			frame.setBounds(350, 350, 750, 400);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().setLayout(null);
			
			btnSend.setBounds(381, 312, 150, 35);
			btnSend.setForeground(new Color(0, 0, 0));
			btnSend.setBackground(new Color(175, 238, 238));
			btnSend.setForeground(new Color(0, 0, 0));
			btnSend.setBounds(627, 330, 109, 33);
			frame.getContentPane().add(btnSend);
			
			txtEcrivezVotreMessage.setBackground(new Color(255, 255, 255));
			txtEcrivezVotreMessage.setText("Ecrivez votre message");
			txtEcrivezVotreMessage.setFont(new Font("Tahoma", Font.PLAIN, 10));
			txtEcrivezVotreMessage.setBounds(0, 331, 617, 32);
			txtEcrivezVotreMessage.addFocusListener(new FocusListener() {
				
				@Override
				public void focusGained(FocusEvent e) {
					txtEcrivezVotreMessage.setText("");	
				}

				@Override
				public void focusLost(FocusEvent e) {
					txtEcrivezVotreMessage.setText("Ecrivez votre message");	
				}
			});
			
			frame.getContentPane().add(txtEcrivezVotreMessage);
			txtEcrivezVotreMessage.setColumns(10);
					
			JScrollPane scrollPane_1 = new JScrollPane();
			frame.getContentPane().add(scrollPane_1);
			scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
			scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			scrollPane_1.setBounds(0, 1, 476, 325);
			
			JScrollPane scrollPane_2 = new JScrollPane();
			frame.getContentPane().add(scrollPane_2);
			scrollPane_2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
			scrollPane_2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			scrollPane_2.setBounds(486, 1, 250, 325);
	
			messageArea.setBackground(new Color(240, 255, 240));
			scrollPane_1.setViewportView(messageArea);
			
			userArea.setBackground(new Color(220, 220, 220));
			userArea.setBounds(391, 0, 119, 304);
			scrollPane_2.setViewportView(userArea);

        // Gestion des �v�nements
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                try {
					window_windowClosing(e);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
            }
        });
         	
        btnSend.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btnSend_actionPerformed(e);
            }
        });
	txtEcrivezVotreMessage.addKeyListener(new KeyAdapter() {
		public void keyReleased(KeyEvent event) {
			if (event.getKeyChar() == '\n')
			    btnSend_actionPerformed(null);
		    }
	});

        // Initialisation des attributs
        this.messageArea.setEditable(false);
        this.userArea.setEditable(false);
        this.frame.setVisible(true);
        this.txtEcrivezVotreMessage.requestFocus();
    }

	
    
    //desinscription
    public void window_windowClosing(WindowEvent e) throws IOException {
    	this.room.desinscription(user.getPseudo());
    	clientSocket.close();
    	frame.dispose();
    	System.exit(-1);
    }
    
    //envoi message
    public void btnSend_actionPerformed(ActionEvent e) {
    	try {
			this.room.postMessage(user.getPseudo(), this.txtEcrivezVotreMessage.getText());
		} catch (RemoteException e1) {
			e1.printStackTrace();
			System.out.println("Impossible d envoyer le message");
		}
    	this.txtEcrivezVotreMessage.setText("");
        this.txtEcrivezVotreMessage.requestFocus();
    }


	public void display(String message) throws RemoteException {
		this.messageArea.setText(messageArea.getText()+ message +" \n");
		this.messageArea.moveCaretPosition(this.messageArea.getText().length());
	}
	
	public void display2(String message) {
		this.userArea.setText(userArea.getText()+ message +" \n");
		this.userArea.moveCaretPosition(this.userArea.getText().length());
	}
	
	public static Utilisateur getUser() {
		return user;
	}
	
}
