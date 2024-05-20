import java.io.FileNotFoundException;
import java.io.IOException;

import codice.articolo;
import codice.gestioneListe;
import eccezioni.articoloException;
import eccezioni.gestioneListeException;
import eccezioni.listaException;
import gui.ListaGui;
import jbook.util.Input;

/**
 * @author Alessandro Zappatore matricola:20050889
 */
public class Main {
	private static gestioneListe gestioneListe = new gestioneListe();

	public static void main(String[] args)
			throws articoloException, listaException, gestioneListeException, IOException {
		gestioneListe.aggiungiCategoria("Non categorizzati");
		gestioneListe.aggiungiCategoria("Alimentari");
		gestioneListe.aggiungiCategoria("Carne");
		gestioneListe.aggiungiCategoria("Dolci");
		gestioneListe.aggiungiCategoria("Igiene personale");
		gestioneListe.aggiungiCategoria("Abbigliamento");
		gestioneListe.aggiungiCategoria("Documenti");



		gestioneListe.crea("Lista viaggio");
		gestioneListe.crea("Lista spesa");
		articolo articolo1 = new articolo("pane", 4, 1.0, "Alimentari");
		articolo articolo2 = new articolo("pasta", 1.0, "Alimentari");
		articolo articolo3 = new articolo("hamburger", 2, 5.0, "Carne");
		articolo articolo4 = new articolo("pollo", 3, 4.0, "Carne");
		articolo articolo5 = new articolo("torta", 1, 25.0, "Dolci");
		articolo articolo6 = new articolo("spazzolino", 1, 2.0, "Igiene personale");
		articolo articolo7 = new articolo("dentifricio", 1, 1.5, "Igiene personale");
		articolo articolo8 = new articolo("pigiama", 1, 15.0, "Abbigliamento");
		articolo articolo9 = new articolo("maglietta", 5, 10.0, "Abbigliamento");
		articolo articolo10 = new articolo("pantalone", 3, 20.0, "Abbigliamento");
		articolo articolo11 = new articolo("calzini", 5, 3.0, "Abbigliamento");
		articolo articolo12 = new articolo("carta d'identità", 1, 22.21, "Documenti");

		gestioneListe.getLista("Lista spesa").aggiungi(articolo1);
		gestioneListe.getLista("Lista spesa").aggiungi(articolo2);
		gestioneListe.getLista("Lista spesa").aggiungi(articolo3);
		gestioneListe.getLista("Lista spesa").aggiungi(articolo4);
		gestioneListe.getLista("Lista spesa").aggiungi(articolo5);
		gestioneListe.getLista("Lista spesa").aggiungi(articolo6);
		gestioneListe.getLista("Lista spesa").aggiungi(articolo7);


		gestioneListe.getLista("Lista viaggio").aggiungi(articolo6);
		gestioneListe.getLista("Lista viaggio").aggiungi(articolo7);
		gestioneListe.getLista("Lista viaggio").aggiungi(articolo8);
		gestioneListe.getLista("Lista viaggio").aggiungi(articolo9);
		gestioneListe.getLista("Lista viaggio").aggiungi(articolo10);
		gestioneListe.getLista("Lista viaggio").aggiungi(articolo11);
		gestioneListe.getLista("Lista viaggio").aggiungi(articolo12);

		int scelta = Input.readInt("Inserire 1 per avviare l'interfaccia grafica, 2 per avviare l'interfaccia da riga di comando: ");
		if(scelta == 1) interfacciaGrafica();
		else interfacciaComando();
	}

	private static void interfacciaComando()
			throws gestioneListeException, articoloException, listaException, IOException {
		System.out.println("Benvenuto nel gestore di Liste\n");
		// gestioneListe.aggiungiCategoria("Non categorizzati");
		int scelta = 0;
		do {
			try {
				System.out.println(
						"------------------------------------------------------------------------------------\n");
				scelta = Input.readInt(
						"Inserire 1 per visualizzare tutte le liste presenti\nInserire 2 per creare una nuova lista\nInserire 3 per eliminare una lista\n"
								+ "Inserire 4 per aggiungere una nuova categoria\nInserire 5 per cancellare una categoria\nInserire 6 per salvare una lista su file\n"
								+ "Inserire 7 per leggere una lista da file\nInserire 8 per visualizzare tutte le categorie\nInserire 9 per accedere ad una lista\nInserire 0 per concludere\n");
				switch (scelta) {
				case 1:
					stampaListe();
					break;
				case 2:
					creaLista();
					break;
				case 3:
					eliminaLista();
					break;
				case 4:
					String categoria = Input.readString("Inserire la categoria: ");
					aggiungiCategoria(categoria);
					break;
				case 5:
					cancellaCategoria();
					break;
				case 6:
					salvaFile();
					break;
				case 7:
					leggiFile();
					break;
				case 8:
					stampaCategorie();
					break;
				case 9:
					accedereLista();
					break;
				default:
					break;
				}
			} catch (NumberFormatException e) {
				System.out.println("Scelta non presente: " + e.getMessage());
				scelta = 10;
			}

		} while (scelta != 0);

	}
	 private static void interfacciaGrafica() {
	 new ListaGui(gestioneListe);
	 }

	private static void stampaListe() {
		System.out.println(gestioneListe.toString());
	}

	private static void accedereLista() throws articoloException, listaException, gestioneListeException {
		String list = Input.readString("Inserire il nome della lista da accedere: ");
		if (gestioneListe.getLista(list) == null) {
			System.out.println("Lista non esistente\n");
		} else {
			int scelta = 0;
			do {
				try {
					scelta = Input.readInt(
							"Inserire 1 per visualizzare tutti gli articoli della lista\nInserire 2 per aggiungere un articolo alla lista\nInserire 3 per eliminare un articolo"
									+ "\nInserire 4 per modificare un articolo\nInserire 5 per avere la lista degli articoli aventi un determinato prefisso\n"
									+ "Inserire 6 per avere il costo totale degli articoli della lista\nInserire 7 per avere la lista degli articoli con la stessa categoria\n"
									+ "Inserire 0 per tornare al menu' principale\n");
					switch (scelta) {
					case 1:
						stampaArticoli(list);
						break;
					case 2:
						aggiungiArticolo(list);
						break;
					case 3:
						eliminaArticolo(list);
						break;
					case 4:
						modificaArticolo(list);
						break;
					case 5:
						listaPrefisso(list);
						break;
					case 6:
						costoTotale(list);
						break;
					case 7:
						articoliCategoria(list);
						break;
					default:
						break;
					}
				} catch (NumberFormatException e) {
					System.out.println("Scelta non presente: " + e.getMessage());
					scelta = 10;
				}

			} while (scelta != 0);
		}
	}

	private static void stampaArticoli(String list) {
			System.out.println(gestioneListe.getLista(list).toString());
	}

	private static void creaLista() throws gestioneListeException {
		try {
			String list = Input.readString("Inserire il nome della lista: ");
			gestioneListe.crea(list);
			stampaListe();
		} catch (gestioneListeException e) {
			System.out.println(e.getMessage());
			creaLista();
		}
	}

	private static void eliminaLista() throws gestioneListeException {
		try {
			stampaListe();
			String list = Input.readString("Inserire il nome della lista da eliminare: ");
			gestioneListe.cancella(list);
			stampaListe();
		} catch (gestioneListeException e) {
			System.out.println(e.getMessage());
			eliminaLista();
		}
	}

	private static void aggiungiArticolo(String list) throws listaException, articoloException, gestioneListeException{
		stampaArticoli(list);
		String nome = Input.readString("Inserire il nome: ");
		try {
			gestioneListe.getLista(list).getArticolo(nome);
		}catch(listaException e) {
			String qty = Input.readString("Inserire la quantita': ");
			String costo = Input.readString("Inserire il costo: ");
			if(costo.isEmpty()) {
				System.out.println("Costo obbligatorio!");
				aggiungiArticolo(list);
			}
			String categoria = Input.readString("Inserire la categoria: ");
			articolo art=null;
			try {
				if(qty.isEmpty()&&categoria.isEmpty()) {
					 art = new articolo(nome, Double.parseDouble(costo));
				} else if(!qty.isEmpty()&&categoria.isEmpty()) {
					 art = new articolo(nome,Integer.parseInt(qty), Double.parseDouble(costo));
				} else if(qty.isEmpty()&&!categoria.isEmpty()) {
					 art = new articolo(nome, Double.parseDouble(costo), categoria);
				} else {
					 art = new articolo(nome,Integer.parseInt(qty), Double.parseDouble(costo), categoria);		
				}
			}catch(articoloException e1) {
				System.out.println(e1.getMessage());
				int scelta = Input.readInt("Inserire 1 se si vuole aggiungere la nuova categoria, 2 per annullare: ");
				switch(scelta) {
				case 1:
					gestioneListe.aggiungiCategoria(categoria);
					if(qty.isEmpty()) {
						 art = new articolo(nome, Double.parseDouble(costo), categoria);		
					}else {
						 art = new articolo(nome,Integer.parseInt(qty), Double.parseDouble(costo), categoria);		
					}
					break;
				default:
					return;
				}
			}
			try {
				gestioneListe.getLista(list).aggiungi(art);		
			}catch(listaException e1) {
				System.out.println(e1.getMessage());
			}
		}
	}

	private static void eliminaArticolo(String list) throws listaException {
		try {
			stampaArticoli(list);
			String nome = Input.readString("Inserire il nome dell' articolo da eliminare: ");
			gestioneListe.getLista(list).rimuovi(nome);
			stampaArticoli(list);
		} catch (listaException e) {
			System.out.println(e.getMessage());
			eliminaArticolo(list);}
	}

	private static void modificaArticolo(String list) throws articoloException {
			stampaArticoli(list);
			String nome = Input.readString("Inserire il nome dell' articolo da modificare: ");
			try {
				int choice = 0;
				choice = Input
						.readInt("Per modificare: QUANTITA' inserire 1, CATEGORIA inserire 2, COSTO inserire 3: ");
				switch (choice) {
				case 1:
					int qty = Input.readInt("Inserire la nuova quantita': ");
					try {
						gestioneListe.getLista(list).getArticolo(nome).setQty(qty);
					} catch (listaException e) {
						System.out.println(e.getMessage());
						modificaArticolo(list);
					}
					break;
				case 2:
					String categoria = Input.readString("Inserire la nuova categoria: ");
					try {
						gestioneListe.getLista(list).getArticolo(nome).setCategoria(categoria);
					} catch (listaException e) {
						System.out.println(e.getMessage());
						modificaArticolo(list);
					}
					break;
				case 3:
					double costo = Input.readDouble("Inserire il nuovo costo: ");
					try {
						gestioneListe.getLista(list).getArticolo(nome).setCosto(costo);
					} catch (listaException e) {
						System.out.println(e.getMessage());
						modificaArticolo(list);
					}
					break;
				}
			} catch (NumberFormatException e) {
				System.out.println("Scelta non presente: " + e.getMessage());
			}
	}

	private static void listaPrefisso(String list) {
			stampaArticoli(list);
			String nome = Input.readString("Inserire il prefisso: ");
			String temp = gestioneListe.getLista(list).trovaArticoliConPrefisso(nome);
			System.out.println(temp);

	}

	private static void costoTotale(String list) {
			stampaArticoli(list);
			System.out.println("Costo totale articolo = " + gestioneListe.getLista(list).calcolaCostoTot());
	}

	private static void articoliCategoria(String list) {
			stampaArticoli(list);
			String categoria = Input.readString("Inserire la categoria da trovare: ");
			String tp = gestioneListe.getLista(list).getArticoliPerCategoria(categoria);
			System.out.println(tp);
	}

	private static void aggiungiCategoria(String categoria) throws gestioneListeException {
		try {
			gestioneListe.aggiungiCategoria(categoria);
		} catch (gestioneListeException e) {
			System.out.println(e.getMessage());
			categoria = Input.readString("Inserire la categoria: ");
			aggiungiCategoria(categoria);
		}
	}

	private static void cancellaCategoria() throws gestioneListeException, articoloException {
		try {
			String categoria = Input.readString("Inserire la categoria da cancellare: ");
			gestioneListe.cancellaCategoria(categoria);
		} catch (gestioneListeException e) {
			System.out.println(e.getMessage());
			cancellaCategoria();
		} catch(articoloException e) {
			System.out.println(e.getMessage());
			cancellaCategoria();
		}
	}

	private static void salvaFile() throws IOException {
		try {
			String list = Input.readString("Inserire il nome della lista da salvare su file: ");
			String file = Input.readString("Inserire il nome del file: ");
			gestioneListe.salvaListaSuFile(gestioneListe.getLista(list), file);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (NullPointerException e) {
			System.out.println("Lista non esistente\n");
		}
	}

	private static void leggiFile() throws NumberFormatException, FileNotFoundException, listaException, IOException,
			articoloException, gestioneListeException {
		try {
			String file = Input.readString("Inserire il nome del file: ");
			String list = Input.readString("Inserire il nome della lista da creare: ");
			gestioneListe.creaListaDaFile(file, list);
		} catch (listaException e) {
			System.out.println(e.getMessage());
			leggiFile();
		} catch (articoloException e) {
			System.out.println(e.getMessage());
			leggiFile();
		} catch (gestioneListeException e) {
			System.out.println(e.getMessage());
			leggiFile();
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
			leggiFile();
		} catch (NumberFormatException e) {
			System.out.println(e.getMessage());
			leggiFile();
		} catch (IOException e) {
			System.out.println(e.getMessage());
			leggiFile();
		}
		stampaListe();
	}

	private static void stampaCategorie() {
		System.out.println(gestioneListe.CategorietoString());
	}

}
