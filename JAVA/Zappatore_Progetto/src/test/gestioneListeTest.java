package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

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
class gestioneListeTest {

	@Test
	void testAggiungiLista() throws gestioneListeException {
		gestioneListe gestioneListe = new gestioneListe();
		assertTrue(gestioneListe.crea("Lista spesa"));

		ArrayList<lista> liste = gestioneListe.getListe();
		assertEquals(1, liste.size());
		assertEquals("Lista spesa", liste.get(0).getNomeLista());

		assertTrue(gestioneListe.crea("Lista viaggio"));

		assertEquals(2, liste.size());
		assertEquals("Lista viaggio", liste.get(1).getNomeLista());
	}

	@Test
	void testAggiungiListaRipetuta() throws gestioneListeException {
		gestioneListe gestioneListe = new gestioneListe();
		gestioneListe.crea("Lista spesa");
		gestioneListeException ex = assertThrows(gestioneListeException.class, () -> gestioneListe.crea("Lista spesa"));
		assertEquals("Lista gia' esistente", ex.getMessage());
	}

	@Test
	void testAggiungiCategoria() throws gestioneListeException {
		gestioneListe gestioneListe = new gestioneListe();
		gestioneListe.aggiungiCategoria("alimentari");
		assertEquals(1, codice.gestioneListe.getCategorie().size());
		assertEquals("alimentari", codice.gestioneListe.getCategorie().get(0));
		gestioneListe.aggiungiCategoria("carne");
		assertEquals(2, codice.gestioneListe.getCategorie().size());
		assertEquals("carne", codice.gestioneListe.getCategorie().get(1));
	}

	@Test
	void testAggiungiCategoriaRipetuto() throws gestioneListeException {
		gestioneListe gestioneListe = new gestioneListe();
		gestioneListe.aggiungiCategoria("alimentari");
		gestioneListeException ex = assertThrows(gestioneListeException.class,
				() -> gestioneListe.aggiungiCategoria("alimentari"));
		assertEquals("Categoria gia' presente", ex.getMessage());
	}

	@Test
	void testCancellaCategoria() throws gestioneListeException, articoloException {
		gestioneListe gestioneListe = new gestioneListe();
		gestioneListe.aggiungiCategoria("alimentari");
		gestioneListe.aggiungiCategoria("carne");
		assertEquals(2, codice.gestioneListe.getCategorie().size());
		gestioneListe.cancellaCategoria("alimentari");
		assertEquals(1, codice.gestioneListe.getCategorie().size());
	}

	@Test
	void testCancellaCategoriaNonPresente() throws gestioneListeException {
		gestioneListe gestioneListe = new gestioneListe();
		gestioneListe.aggiungiCategoria("alimentari");
		gestioneListe.aggiungiCategoria("carne");
		gestioneListeException ex = assertThrows(gestioneListeException.class,
				() -> gestioneListe.cancellaCategoria("surgelati"));
		assertEquals("Categoria non presente", ex.getMessage());
	}

	@Test
	void testCancellaLista() throws gestioneListeException {
		gestioneListe gestioneListe = new gestioneListe();
		assertTrue(gestioneListe.crea("Lista spesa"));

		ArrayList<lista> liste = gestioneListe.getListe();
		assertEquals(1, liste.size());
		assertEquals("Lista spesa", liste.get(0).getNomeLista());

		assertTrue(gestioneListe.crea("Lista viaggio"));

		assertEquals(2, liste.size());
		assertEquals("Lista viaggio", liste.get(1).getNomeLista());

		assertTrue(gestioneListe.cancella("Lista spesa"));
		assertEquals(1, liste.size());
		assertEquals("Lista viaggio", liste.get(0).getNomeLista());
	}

	@Test
	void testCancellaCategoriaCascata() throws gestioneListeException, articoloException, listaException {
		gestioneListe gestioneListe = new gestioneListe();
		gestioneListe.aggiungiCategoria("alimentari");
		gestioneListe.aggiungiCategoria("carne");
		gestioneListe.crea("Lista spesa");
		articolo articolo = new articolo("pane", 1.0, "alimentari");
		gestioneListe.getLista("Lista spesa").aggiungi(articolo);
		gestioneListe.cancellaCategoria("alimentari");
		assertEquals("Non categorizzati", gestioneListe.getLista("Lista spesa").getArticoli().get(0).getCategoria());
	}
}
