package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import codice.articolo;
import codice.gestioneListe;
import codice.lista;
import eccezioni.articoloException;
import eccezioni.gestioneListeException;
import eccezioni.listaException;
/**
 * @author Alessandro Zappatore matricola:20050889
 */
class listaTest {

	@BeforeEach
	@Test
	void aggiuntaCategoriaDefault() throws gestioneListeException {
		gestioneListe gestioneListe = new gestioneListe();
		gestioneListe.aggiungiCategoria("Non categorizzati");
		gestioneListe.aggiungiCategoria("alimentari");
	}

	@Test
	void testAggiungiArticoli() throws articoloException, listaException {
		lista lista = new lista("Lista spesa");

		articolo articolo = new articolo("pane", 1.0, "alimentari");
		lista.aggiungi(articolo);

		assertEquals("Lista spesa", lista.getNomeLista());
		assertEquals(1, lista.getArticoli().size());
		assertEquals(articolo, lista.getArticoli().get(0));

		articolo articolo2 = new articolo("carne", 5.0);
		lista.aggiungi(articolo2);

		assertEquals(2, lista.getArticoli().size());
		assertEquals(articolo2, lista.getArticoli().get(1));
	}

	@Test
	void testAggiungiArticoloRipetuto() throws articoloException, listaException {
		lista lista = new lista("Lista spesa");

		articolo articolo = new articolo("pane", 1.0, "alimentari");
		lista.aggiungi(articolo);
		articolo articolo2 = new articolo("pane", 2.0, "alimentari");
		listaException ex = assertThrows(listaException.class, () -> lista.aggiungi(articolo2));
		assertEquals("Articolo gia' presente", ex.getMessage());
	}

	@Test
	void testRimuoviArticolo() throws articoloException, listaException {
		lista lista = new lista("Lista spesa");

		articolo articolo = new articolo("pane", 1.0, "alimentari");
		lista.aggiungi(articolo);
		articolo articolo2 = new articolo("carne", 5.0);
		lista.aggiungi(articolo2);

		lista.rimuovi("pane");
		assertEquals(1, lista.getArticoli().size());
		assertEquals(articolo2, lista.getArticoli().get(0));
	}

	@Test
	void testRimuoviArticoloNonPresente() throws articoloException, listaException {
		lista lista = new lista("Lista spesa");

		articolo articolo = new articolo("pane", 1.0, "alimentari");
		lista.aggiungi(articolo);

		listaException ex = assertThrows(listaException.class, () -> lista.rimuovi("carne"));
		assertEquals("Articolo non presente", ex.getMessage());
	}

	@Test
	void testTrovaArticoliConPrefisso() throws articoloException, listaException {
		lista lista = new lista("Lista spesa");

		articolo articolo = new articolo("pane", 1.0, "alimentari");
		lista.aggiungi(articolo);
		articolo articolo2 = new articolo("carne", 5.0);
		lista.aggiungi(articolo2);
		articolo articolo3 = new articolo("pasta", 5.0, "alimentari");
		lista.aggiungi(articolo3);

		String articoli = lista.trovaArticoliConPrefisso("pa");
		assertTrue(articoli.contains("pane"));
		assertTrue(articoli.contains("pasta"));
	}

	@Test
	void testCalcolaCosto() throws articoloException, listaException {
		lista lista = new lista("Lista spesa");
		articolo articolo = new articolo("pane", 1.0, "alimentari");
		lista.aggiungi(articolo);
		articolo articolo2 = new articolo("carne", 5.0);
		lista.aggiungi(articolo2);
		articolo articolo3 = new articolo("pasta", 5.0, "alimentari");
		lista.aggiungi(articolo3);

		assertEquals(11.0, lista.calcolaCostoTot());
	}

	@Test
	void testGetArticoliPerCategoria() throws articoloException, listaException {
		lista lista = new lista("Lista spesa");
		articolo articolo = new articolo("pane", 1.0, "alimentari");
		lista.aggiungi(articolo);
		articolo articolo2 = new articolo("carne", 5.0);
		lista.aggiungi(articolo2);
		articolo articolo3 = new articolo("pasta", 5.0, "alimentari");
		lista.aggiungi(articolo3);

		String articoli = lista.getArticoliPerCategoria("alimentari");
		assertTrue(articoli.contains("pane"));
		assertTrue(articoli.contains("pasta"));
	}
}
