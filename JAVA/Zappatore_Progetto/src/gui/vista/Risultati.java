package gui.vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
/**
 * @author Alessandro Zappatore matricola:20050889
 */
@SuppressWarnings("serial")
public class Risultati extends JFrame{
	private JLabel nomeLista;
	private JTextArea risultato;
 
	public Risultati(String res, String nome, String op) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Risultato "+op);
		setLayout(new BorderLayout());
	nomeLista = new JLabel("Risultato lista "+nome);
	add(nomeLista, BorderLayout.NORTH);
	
	risultato = new JTextArea(res);
	setBounds(600, 300, 500, 300);
	
	risultato.setBorder(BorderFactory.createLineBorder(Color.GREEN, 3));
	risultato.setFont(new Font("Arial",Font.PLAIN, 13));

	add(risultato, BorderLayout.CENTER);

	}
}
