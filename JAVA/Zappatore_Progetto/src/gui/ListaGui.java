package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;

import codice.gestioneListe;
import gui.vista.ListaPanel;
/**
 * @author Alessandro Zappatore matricola:20050889
 */
@SuppressWarnings("serial")
public class ListaGui extends JFrame{
	public ListaGui(gestioneListe model) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 200, 920, 600);
		setTitle("Gestore liste");
		
		JPanel listaPanel = new ListaPanel(model);
		setContentPane(listaPanel);
		setVisible(true);
	}
}
