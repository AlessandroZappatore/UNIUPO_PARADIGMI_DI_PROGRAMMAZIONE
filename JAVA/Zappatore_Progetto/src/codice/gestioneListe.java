package codice;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import eccezioni.articoloException;
import eccezioni.gestioneListeException;
import eccezioni.listaException;

/**
 * @author Alessandro Zappatore matricola:20050889
 */
public class gestioneListe {
	private static ArrayList<lista> liste;
	private static ArrayList<String> categorie;

	/**
	 * Costruttore della classe gestioneListe.
	 */
	public gestioneListe() {
		liste = new ArrayList<>();
		categorie = new ArrayList<>();
	}

	/**
	 * Lo scopo del metodo crea &egrave; quello di creare una nuova lista.
	 * 
	 * @return Restituisce true se la creazione della nuova lista &egrave; andata a buon fine, 
	 * altrimenti genera un eccezione.
	 * 
	 * @param nome il nome della nuova lista da creare.
	 * 
	 * @exception gestioneListeException viene generata questa eccezione nel caso in cui esista
	 * gia' una lista con lo stesso nome.
	 */
	public boolean crea(String nome) throws gestioneListeException {
		if (getLista(nome) == null) {
			liste.add(new lista(nome));
			return true;
		}
		throw new gestioneListeException("Lista gia' esistente");
	}
	/**
	 * Lo scopo del metodo cancella &egrave; quello di cancellare una lista esistente.
	 * 
	 * @return Resitituisce true se la cancellazione &egrave; andata a buon fine, 
	 * altrimenti genera un eccezione.
	 * 
	 * @param nomeLista il nome della lista da cancellare.
	 * 
	 * @exception gestioneListeException viene generata questa eccezione nel caso in cui la lista 
	 * con nome nomeLista non dovesse esistere.
	 */
	public boolean cancella(String nomeLista) throws gestioneListeException {
		lista temp = getLista(nomeLista);
		if (temp != null) {
			liste.remove(temp);
			return true;
		}
		throw new gestioneListeException("Lista non esistente");
	}
	/**
	 * Lo scopo del metodo getLista &grave; quello di restituire una lista ben precisa.
	 * 
	 * @return Restituisce la lista se trova una lista con un determinato nome, 
	 * altrimenti restituisce null.
	 * 
	 * @param nomeLista il nome della lista da restituire.
	 */
	public lista getLista(String nomeLista){
		for (lista lista : liste) {
			if (lista.getNomeLista().equals(nomeLista)) {
				return lista;
			}
		}
		return null;
	}
	/**
	 * Lo scopo del metodo aggiugniCategoria &egrave; quello di creare e aggiungere una nuova categoria.
	 * 
	 * Non restituisce niente ma genera un eccezione nel caso in cui la categoria dovesse esistere gia'.
	 * 
	 * @param categoria il nome della categoria da aggiugnere.
	 * 
	 * @exception gestioneListeException viene generata questa eccezione nel caso in cui la categoria
	 * con quel determinato nome dovesse esistente gia'.
	 */
	public void aggiungiCategoria(String categoria) throws gestioneListeException {
		if (categorie.contains(categoria)) {
			throw new gestioneListeException("Categoria gia' presente");
		}
		categorie.add(categoria);
	}

	/**
	 * Lo scopo del metodo getListe &egrave; quello di resituire tutte le liste presenti.
	 * 
	 * @return Restituisce l'arrayList<lista> con tutte le liste create.
	 */
	public ArrayList<lista> getListe() {
		return liste;
	}
	/**
	 * Lo scopo del metodo getCategorie &egrave; quello di resituire tutte le categorie presenti.
	 * 
	 * @return Restituisce l'arrayList<String> con tutte le categorie create.
	 */
	public static ArrayList<String> getCategorie() {
		return categorie;
	}
	/**
	 * Lo scopo del metodo cancellaCategoria &egrave; quello di eliminare una categoria specifica e cambiare in tutti gli articoli
	 * con quella categoria a Non categorizzati.
	 * 
	 * Non restituisce niente ma genera un eccezione nel caso in cui non dovesse esistere quella categoria, 
	 * l'utente volesse cancellare la categoria di default.
	 * 
	 * @param categoria il nome della categoria da eliminare.
	 * 
	 * @exception gestioneListeException viene generata questa eccezione nel caso in cui la categoria
	 * con quel determinato nome non dovesse esistere, oppure se si sta cancellando la categoria di default.
	 * @throws articoloException viene generata nel caso in cui l'articolo non dovesse esistenre
	 */
	public void cancellaCategoria(String categoria) throws gestioneListeException, articoloException {
		if (!categorie.contains(categoria)) {
			throw new gestioneListeException("Categoria non presente");
		}
		if(categoria.equals("Non categorizzati")) {
			throw new gestioneListeException("Impossibile cancellare la categoria di default");
		}
		else {
			categorie.remove(categoria);
		}
		for (lista lista : liste) {
			for (articolo articolo : lista.getArticoli()) {
				if (articolo.getCategoria().equals(categoria)) {
					if (!categorie.contains("Non categorizzati")) {
						categorie.add("Non categorizzati");
					}
					articolo.setCategoria("Non categorizzati");
				}
			}
		}
	}
	/**
	 * Lo scopo del metodo salvaListaSuFile &egrave; quello di scrivere i dati di una lista su un file.
	 * 
	 * Non restituisce niente ma genera eccezioni nel caso in cui il file non dovesse essere accessibile.
	 * 
	 * @param lista la lista da salvare sul file.
	 * @param nomeFile il nome del file su cui salvare la lista
	 * 
	 * @exception IOException viene generata nel caso in cui il file non dovesse essere accessibile.
	 */
	public void salvaListaSuFile(lista lista, String nomeFile) throws IOException {
		FileWriter writer = new FileWriter(nomeFile);
		for (articolo articolo : lista.getArticoli()) {
			writer.write(articolo.getNome() + "," + articolo.getQty() + "," + articolo.getCosto() + ","
					+ articolo.getCategoria() + "\n");
		}
		writer.close();
	}
	/**
	 * Lo scopo del metodo creaListaDaFile &egrave; quello di creare una lista presente su un file.
	 * 
	 * Non restituisce niente ma genera eccezioni.
	 * 
	 * @param nomeFile il nome del file da cui prelevare le informazioni.
	 * @param nomeLista il nome nome della nuova lista da creare.
	 * 
	 * @exception FileNotFoundException viene generata se il file non dovesse esistere.
	 */
	public void creaListaDaFile(String nomeFile, String nomeLista) throws NumberFormatException, listaException,
			FileNotFoundException, IOException, articoloException, gestioneListeException {
		
		try (FileReader reader = new FileReader(nomeFile)) {
			crea(nomeLista);
			BufferedReader bufferedReader = new BufferedReader(reader);
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				String[] campi = line.split(",");
				getLista(nomeLista).aggiungi(
						new articolo(campi[0], Integer.parseInt(campi[1]), Double.parseDouble(campi[2]), campi[3]));
			}
		}catch(FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Lo scopo del metodo toString &egrave; quello di stampare i nomi delle liste presenti.
	 * 
	 * @return Restituisce la parola "Liste: \n" seguita dalle liste separate da degli spazi.
	 */
	@Override
	public String toString() {
	StringBuilder sb = new StringBuilder();
			
			for (lista list : liste) {
				sb.append("          ").append(list.getNomeLista()).append("\n");
			}
		return "Liste: \n"+sb.toString()+"\n";
	}
	/**
	 * Lo scopo del metodo CategorietoString &egrave; quello di stampare i nomi delle categorie presenti.
	 * 
	 * @return Restituisce la parola "Categorie: \n" seguita dalle categorie separate da degli spazi.
	 */
	public String CategorietoString() {
		StringBuilder sb = new StringBuilder();
		
		for(String cat: categorie) {
			sb.append("          ").append(cat).append("\n");
		}
		return "Categorie: \n"+sb.toString()+"\n";
	}

}
