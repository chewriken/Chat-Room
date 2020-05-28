package modele;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JToggleButton;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.JTextPane;
import java.awt.Scrollbar;

public class ihm {

	private JFrame frame;
	private JTextField txtEcrivezVotreMessage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ihm window = new ihm();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ihm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 534, 384);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Envoyer");
		btnNewButton.setBounds(381, 312, 150, 35);
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(new Color(245, 255, 250));
		frame.getContentPane().add(btnNewButton);
		
		txtEcrivezVotreMessage = new JTextField();
		txtEcrivezVotreMessage.setBackground(new Color(255, 255, 255));
		txtEcrivezVotreMessage.setText("Ecrivez votre message");
		txtEcrivezVotreMessage.setFont(new Font("Tahoma", Font.PLAIN, 10));
		txtEcrivezVotreMessage.setBounds(0, 312, 383, 35);
		frame.getContentPane().add(txtEcrivezVotreMessage);
		txtEcrivezVotreMessage.setColumns(10);
		
		JTextPane textPane = new JTextPane();
		textPane.setBackground(new Color(248, 248, 255));
		textPane.setBounds(2, 0, 381, 306);
		frame.getContentPane().add(textPane);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setBackground(new Color(192, 192, 192));
		textPane_1.setBounds(391, 0, 119, 304);
		frame.getContentPane().add(textPane_1);
		
		Scrollbar scrollbar = new Scrollbar();
		scrollbar.setBounds(362, 10, 21, 296);
		frame.getContentPane().add(scrollbar);
	}
}
