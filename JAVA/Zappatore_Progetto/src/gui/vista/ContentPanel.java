package gui.vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import codice.gestioneListe;
/**
 * @author Alessandro Zappatore matricola:20050889
 */
@SuppressWarnings("serial")
public class ContentPanel extends JPanel{
	private gestioneListe model;
	private JTextArea lista;
	public ContentPanel(gestioneListe model) {
		this.model=model;
		setLayout(new BorderLayout());
		lista = new JTextArea(25,50);
		lista.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
		lista.setFont(new Font("Arial",Font.PLAIN, 13));
		add(lista, BorderLayout.NORTH);
		updateView();
	}
	
	public void updateView() {
		lista.setText(model.toString()+"\n"+model.CategorietoString());
	}
}
