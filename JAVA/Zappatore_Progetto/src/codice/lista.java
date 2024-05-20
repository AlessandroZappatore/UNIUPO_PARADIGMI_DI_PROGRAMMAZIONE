package codice;

import java.util.ArrayList;

import java.util.Iterator;

import eccezioni.listaException;

/**
 * @author Alessandro Zappatore matricola:20050889
 */
public class lista implements Iterable<articolo> {
	private final String nomeLista;
	private ArrayList<articolo> articoli;
	/**
	 * Costruttore della classe lista.
	 * 
	 * @param nomeLista il nome della lista 
	 */
	public lista(String nomeLista) {
		this.nomeLista = nomeLista;
		articoli = new ArrayList<>();
	}
	/**
	 * Lo scopo del metodo aggiungi &egrave; quello di aggiungere un articolo ad una lista.
	 * 
	 * @param articolo oggetto articolo da aggiugnere alla lista
	 * 
	 * @throws listaExcpetion viene generata nel caso in cui l'articolo è gia' presente
	 */
	public void aggiungi(articolo articolo) throws listaException {
		for (articolo temp : articoli) {
			if (temp.getNome().equals(articolo.getNome())) {
				throw new listaException("Articolo gia' presente");
			}
		}
		articoli.add(articolo);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		for (articolo a : articoli) {
			sb.append(a.toString());
		}
	return sb.toString();
	}
	/**
	 * Lo scopo del metodo rimuovi &egrave; quello di rimuovere un articolo dalla lista.
	 * 
	 * 
	 * @throws listaException viene generata nel momento in cui l'articolo non dovesse esistere
	 */
	public void rimuovi(String nome) throws listaException {
		for (articolo articolo : articoli) {
			if (articolo.getNome().equals(nome)) {
				articoli.remove(articolo);
				return;
			}
		}
		throw new listaException("Articolo non presente");
	}
	/**
	 * Lo scopo del metodo trovaArticoliConPregisso &egrave; quello di trovare una lista di articoli il cui nome inizia per un certo prefisso.
	 * 
	 * @param prefisso il prefisso da cercare
	 * 
	 * @return Restituisce una stringa contenente tutti gli articoli che iniziano con il prefisso
	 */
	public String trovaArticoliConPrefisso(String prefisso) {
		StringBuilder sb = new StringBuilder();
		for (articolo articolo : articoli) {
			if (articolo.getNome().startsWith(prefisso)) {
				sb.append(articolo);
			}
		}
		return sb.toString();
	}
	/**
	 * Lo scopo del metodo toString &egrave; quello di calcolare il costo di tutti gli articoli di una lista.
	 * 
	 * @return Restituisce il risultato della somma del costo per la quantita' di tutti gli articoli della lista
	 */
	public double calcolaCostoTot() {
		double tot = 0;
		for (articolo articolo : articoli) {
			tot += articolo.getCosto() * articolo.getQty();
		}
		return tot;
	}
	/**
	 * Lo scopo del metodo getArticoliPerCategoria &egrave; quello di trovare una lista si articoli la cui categoria corrisponde a quella di input.
	 * 
	 * @param categoria la categoria da cercare
	 * 
	 * @return Restituisce una stringa contente tutti gli articoli con la categoria di input
	 */
	public String getArticoliPerCategoria(String categoria) {
		StringBuilder sb = new StringBuilder();
		for (articolo articolo : articoli) {
			if (articolo.getCategoria().equals(categoria)) {
				sb.append(articolo);
			}
		}
		return sb.toString();
	}
	/**
	 * Lo scopo del metodo toString &egrave; quello di restituire un determinato articolo.
	 * 
	 * @return Restituisce un ben preciso articolo presente nella lista
	 * 
	 * @throws listaException viene generata nel caso in cui l'articolo non dovesse esistere
	 */
	public articolo getArticolo(String nomeArticolo) throws listaException {
		for (articolo articolo : articoli) {
			if (articolo.getNome().equals(nomeArticolo)) {
				return articolo;
			}
		}
		throw new listaException("Articolo non presente");
	}

	@Override
	public Iterator<articolo> iterator() {
		return articoli.iterator();
	}

	public String getNomeLista() {
		return nomeLista;
	}

	public ArrayList<articolo> getArticoli() {
		return articoli;
	}

}
