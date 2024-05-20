package gui.controllo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.SwingUtilities;

import codice.articolo;
import codice.lista;
import eccezioni.articoloException;
import eccezioni.listaException;
import gui.vista.ContentDetailPanel;
import gui.vista.DialogoArticolo;
import gui.vista.DialogoLista;
import gui.vista.Errori;
import gui.vista.Risultati;
/**
 * @author Alessandro Zappatore matricola:20050889
 */
public class ControlloListaDetail implements ActionListener{
	private lista model;
	private ContentDetailPanel view;
	public ControlloListaDetail(ContentDetailPanel view, lista model) {
		this.model=model;
		this.view=view;
	}
	
	public void actionPerformed(ActionEvent e) {
		JButton source = (JButton) e.getSource();
		if(source.getText().equals("Aggiungi articolo")) {
			String[] inputs = new DialogoArticolo().getInputs("Aggiungi articolo");
			if(inputs != null) {
				try {
					articolo art;
					if(inputs[1].isEmpty()&&inputs[3].isEmpty()) {
						 art = new articolo(inputs[0], Double.parseDouble(inputs[2]));
					} else if(inputs[1].isEmpty()&&!inputs[3].isEmpty()) {
						 art = new articolo(inputs[0], Double.parseDouble(inputs[2]), inputs[3]);
					} else if(!inputs[1].isEmpty()&&inputs[3].isEmpty()) {
						 art = new articolo(inputs[0], Integer.parseInt(inputs[1]), Double.parseDouble(inputs[2]));
					}else {
						 art = new articolo(inputs[0], Integer.parseInt(inputs[1]), Double.parseDouble(inputs[2]), inputs[3]);
					}
					model.aggiungi(art);
				}catch(listaException e1) {
					Errori err = new Errori("Aggiungi articolo", e1.getMessage());
					err.setVisible(true);
				} catch (NumberFormatException e1) {
					Errori err = new Errori("Aggiungi articolo", "Parametro mancante");
					err.setVisible(true);
				} catch (articoloException e1) {
					Errori err = new Errori("Aggiungi articolo", e1.getMessage());
					err.setVisible(true);
				}
			}
		}else if(source.getText().equals("Modifica articolo")) {
			String[] inputs = new DialogoArticolo().getInputs("Modifica articolo");
			if(inputs != null) {
				try {
					if(!inputs[1].isEmpty()){
						model.getArticolo(inputs[0]).setQty(Integer.parseInt(inputs[1]));
					}
					if(!inputs[2].isEmpty()) {
						model.getArticolo(inputs[0]).setCosto(Double.parseDouble(inputs[2]));
					}
					if(!inputs[3].isEmpty()) {
						model.getArticolo(inputs[0]).setCategoria(inputs[3]);
					}
				}catch(listaException e1) {
					Errori err = new Errori("Modifica articolo", e1.getMessage());
					err.setVisible(true);
				} catch (NumberFormatException e1) {
					Errori err = new Errori("Modifica articolo", e1.getMessage());
					err.setVisible(true);
				} catch (articoloException e1) {
					Errori err = new Errori("Modifica articolo", e1.getMessage());
					err.setVisible(true);
				} 
			}
		}else if(source.getText().equals("Elimina articolo")) {
			String[] inputs = new DialogoLista().getInputs("Elimina articolo");
			if(inputs != null) {
				try {
					model.rimuovi(inputs[0]);
				}catch(listaException e1) {
					Errori err = new Errori("Elimina articolo", e1.getMessage());
					err.setVisible(true);
				} catch (NumberFormatException e1) {
					Errori err = new Errori("Elimina articolo", e1.getMessage());
					err.setVisible(true);
				} 
			}
		}else if(source.getText().equals("Articoli-Prefisso")) {
			String[] inputs = new DialogoLista().getInputs("Articoli-Prefisso");
			if(inputs != null) {
				try {
					String result=model.trovaArticoliConPrefisso(inputs[0]);
					Risultati res = new Risultati(result, "prefisso: "+inputs[0], "Trova articoli per prefisso");
					res.setVisible(true);
				} catch (NumberFormatException e1) {
					Errori err = new Errori("Articoli-Prefisso", e1.getMessage());
					err.setVisible(true);
				} 
			}
		}else if(source.getText().equals("Articoli-Categoria")) {
			String[] inputs = new DialogoLista().getInputs("Articoli-Categoria");
			if(inputs != null) {
				try {
					String result=model.getArticoliPerCategoria(inputs[0]);
					Risultati res = new Risultati(result, "categoria: "+inputs[0], "Trova articoli per categoria");
					res.setVisible(true);				} 
				catch (NumberFormatException e1) {
						Errori err = new Errori("Articoli-Categoria", e1.getMessage());
						err.setVisible(true);
				} 
			}
		}else if(source.getText().equals("INDIETRO")) {
		    SwingUtilities.getWindowAncestor(view).dispose();
		}
		view.updateView();
	}
}
