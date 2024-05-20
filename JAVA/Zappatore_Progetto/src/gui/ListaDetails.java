package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;

import codice.gestioneListe;
import gui.vista.ListaDetailPanel;
/**
 * @author Alessandro Zappatore matricola:20050889
 */
@SuppressWarnings("serial")
public class ListaDetails extends JFrame{
	public ListaDetails(gestioneListe model, String list) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(400, 280, 920, 600);
		setTitle("Lista: "+model.getLista(list).getNomeLista());
		
		JPanel listaDetailPanel = new ListaDetailPanel(model.getLista(list));
		setContentPane(listaDetailPanel);
		setVisible(true);
	}
}
