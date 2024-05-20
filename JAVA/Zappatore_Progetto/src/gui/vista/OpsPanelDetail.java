package gui.vista;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import gui.controllo.ControlloListaDetail;
/**
 * @author Alessandro Zappatore matricola:20050889
 */
@SuppressWarnings("serial")
public class OpsPanelDetail extends JPanel{
	public OpsPanelDetail(ControlloListaDetail controllo) {
		setLayout(new FlowLayout());
		JButton addArt = new JButton("Aggiungi articolo");
		JButton modArt = new JButton("Modifica articolo");
		JButton delArt = new JButton("Elimina articolo");
		JButton pref = new JButton("Articoli-Prefisso");
		JButton cat = new JButton("Articoli-Categoria");
		JButton back = new JButton("INDIETRO");
		addArt.addActionListener(controllo);
		add(addArt);
		modArt.addActionListener(controllo);
		add(modArt);
		delArt.addActionListener(controllo);
		add(delArt);
		pref.addActionListener(controllo);
		add(pref);
		cat.addActionListener(controllo);
		add(cat);
		back.addActionListener(controllo);
		add(back);
		
;
	}
}
