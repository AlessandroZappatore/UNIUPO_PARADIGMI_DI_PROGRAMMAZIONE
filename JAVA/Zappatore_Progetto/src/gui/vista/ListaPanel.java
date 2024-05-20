package gui.vista;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import codice.gestioneListe;
import gui.controllo.ControlloLista;
/**
 * @author Alessandro Zappatore matricola:20050889
 */
@SuppressWarnings("serial")
public class ListaPanel extends JPanel{
	public ListaPanel(gestioneListe model) {
		ContentPanel contenutoLista = new ContentPanel(model);
		ControlloLista controllo = new ControlloLista(contenutoLista, model);
		OpsPanel operazioniLista = new OpsPanel(controllo);
		add(operazioniLista, BorderLayout.NORTH);
		add(contenutoLista, BorderLayout.CENTER);
		
	}
}
