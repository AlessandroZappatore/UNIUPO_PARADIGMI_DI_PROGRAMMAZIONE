package gui.vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JTextArea;
/**
 * @author Alessandro Zappatore matricola:20050889
 */
@SuppressWarnings("serial")
public class Errori extends JFrame{
	private JTextArea error;
	
	public Errori(String title, String err) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("ERRORE: "+title);
		setLayout(new BorderLayout());
		setBounds(700, 300, 300, 200);
		
		error = new JTextArea(err);
		error.setBorder(BorderFactory.createLineBorder(Color.RED, 5));
		error.setFont(new Font("Arial", Font.BOLD, 20));
		error.setBackground(Color.RED);
		add(error, BorderLayout.CENTER);
	}
	
}
