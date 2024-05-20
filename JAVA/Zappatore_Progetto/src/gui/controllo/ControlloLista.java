package gui.controllo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;

import codice.gestioneListe;
import eccezioni.articoloException;
import eccezioni.gestioneListeException;
import eccezioni.listaException;
import gui.ListaDetails;
import gui.vista.ContentPanel;
import gui.vista.DialogoFile;
import gui.vista.DialogoLista;
import gui.vista.Errori;
/**
 * @author Alessandro Zappatore matricola:20050889
 */
public class ControlloLista implements ActionListener{
	private gestioneListe model;
	private ContentPanel view;
	public ControlloLista(ContentPanel view, gestioneListe model) {
		this.model=model;
		this.view=view;
	}
	
	public void actionPerformed(ActionEvent e) {
		JButton source = (JButton) e.getSource();
		if(source.getText().equals("Aggiungi lista")) {
			String[] inputs = new DialogoLista().getInputs("Aggiungi lista");
			if(inputs != null) {
				try {
					model.crea(inputs[0]);
				}catch(gestioneListeException e1) {
					Errori err = new Errori("Aggiungi lista", e1.getMessage());
					err.setVisible(true);
				}
			}
		}
			else if(source.getText().equals("Elimina lista")) {
				String[] inputs = new DialogoLista().getInputs("Elimina lista");
				if(inputs != null) {
					try {
						model.cancella(inputs[0]);
					}catch(gestioneListeException e1) {
						Errori err = new Errori("Elimina lista", e1.getMessage());
						err.setVisible(true);
					}
			}
		}
			else if(source.getText().equals("Aggiungi categoria")) {
				String[] inputs = new DialogoLista().getInputs("Aggiungi categoria");
				if(inputs != null) {
					try {
						model.aggiungiCategoria(inputs[0]);
					}catch(gestioneListeException e1) {
						Errori err = new Errori("Aggiungi categoria", e1.getMessage());
						err.setVisible(true);
					}
			}
			}
			else if(source.getText().equals("Elimina categoria")) {
				String[] inputs = new DialogoLista().getInputs("Elimina categoria");
				if(inputs != null) {
					try {
						model.cancellaCategoria(inputs[0]);
					}catch(gestioneListeException e1) {
						Errori err = new Errori("Elimina categoria", e1.getMessage());
						err.setVisible(true);
					} catch(articoloException e1) {
						Errori err = new Errori("Elimina categoria", e1.getMessage());
						err.setVisible(true);
					}
			}
			}else if(source.getText().equals("Salva lista su file")) {
				String[] inputs = new DialogoFile().getInputs("Salva lista su file");
				if(inputs != null) {
					try {
						model.salvaListaSuFile(model.getLista(inputs[0]), inputs[1]);
					}catch(IOException e1) {
						Errori err = new Errori("Salva lista su file", e1.getMessage());
						err.setVisible(true);
					}catch(NullPointerException e1) {
						Errori err = new Errori("Salva lista su file", "Lista non esistente");
						err.setVisible(true);
					}
			}
			}else if(source.getText().equals("Leggi lista da file")) {
				String[] inputs = new DialogoFile().getInputs("Leggi lista da file");
				if(inputs != null) {
					try {
						model.creaListaDaFile(inputs[1], inputs[0]);
					}catch(IOException e1) {
						Errori err = new Errori("Leggi lista da file", e1.getMessage());
						err.setVisible(true);
					} catch (NumberFormatException e1) {
						Errori err = new Errori("Leggi lista da file", e1.getMessage());
						err.setVisible(true);
					} catch (listaException e1) {
						Errori err = new Errori("Leggi lista da file", e1.getMessage());
						err.setVisible(true);
					} catch (articoloException e1) {
						Errori err = new Errori("Leggi lista da file", e1.getMessage());
						err.setVisible(true);
					} catch (gestioneListeException e1) {
						Errori err = new Errori("Leggi lista da file", e1.getMessage());
						err.setVisible(true);
					}catch(Exception e1) {
						Errori err = new Errori("Leggi lista da file", e1.getMessage());
						err.setVisible(true);
					}
			}
			}else if(source.getText().equals("Accedi lista")) {
				String[] inputs = new DialogoLista().getInputs("Accedi lista");
				if(inputs != null) {
					try {
						new ListaDetails(model, inputs[0]);
					}catch(NullPointerException e1) {
						Errori err = new Errori("Aggiungi lista", "Lista non esistente");
						err.setVisible(true);
					}
			}
		}
		view.updateView();
	}
}

