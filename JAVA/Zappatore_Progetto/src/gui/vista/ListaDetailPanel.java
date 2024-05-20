package gui.vista;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import codice.lista;
import gui.controllo.ControlloListaDetail;
/**
 * @author Alessandro Zappatore matricola:20050889
 */
@SuppressWarnings("serial")
public class ListaDetailPanel extends JPanel{
	public ListaDetailPanel(lista model) {
		ContentDetailPanel contenutoListaDetail = new ContentDetailPanel(model);
		ControlloListaDetail controllo = new ControlloListaDetail(contenutoListaDetail, model);
		OpsPanelDetail operazioniListaDetail = new OpsPanelDetail(controllo);
		add(operazioniListaDetail, BorderLayout.NORTH);
		add(contenutoListaDetail, BorderLayout.CENTER);
	}
}
