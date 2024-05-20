package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import codice.articolo;
import codice.gestioneListe;
import eccezioni.articoloException;
import eccezioni.gestioneListeException;
/**
 * @author Alessandro Zappatore matricola:20050889
 */
class articoloTest {

	private static final int DEFAULT_QTY = 1;
	private static final String DEFAULT_CATEGORY = "Non categorizzati";

	@BeforeEach
	@Test
	void aggiuntaCategoriaDefault() throws gestioneListeException {
		gestioneListe gestioneListe = new gestioneListe();
		gestioneListe.aggiungiCategoria("Non categorizzati");
	}

	@Test
	void testAggiuntaArticoloConDefault() throws articoloException {
		articolo articolo = new articolo("pane", 1.0);
		assertEquals("pane", articolo.getNome());
		assertEquals(1.0, articolo.getCosto());
		assertEquals(DEFAULT_QTY, articolo.getQty());
		assertEquals(DEFAULT_CATEGORY, articolo.getCategoria());
	}

	@Test
	void testAggiuntaArticolo() throws articoloException, gestioneListeException {
		gestioneListe gestioneListe = new gestioneListe();
		gestioneListe.aggiungiCategoria("alimentari");
		articolo articolo = new articolo("pane", 2, 1.0, "alimentari");
		assertEquals("pane", articolo.getNome());
		assertEquals(2, articolo.getQty());
		assertEquals(1.0, articolo.getCosto());
		assertEquals("alimentari", articolo.getCategoria());
	}

	@Test
	void testModificaCategoria() throws articoloException, gestioneListeException {
		articolo articolo = new articolo("carne", 1, 6.0);
		gestioneListe gestioneListe = new gestioneListe();
		gestioneListe.aggiungiCategoria("carne");
		assertEquals("carne", articolo.getNome());
		assertEquals("Non categorizzati", articolo.getCategoria());
		articolo.setCategoria("carne");
		assertEquals("carne", articolo.getCategoria());
	}

	@Test
	void testEccezioniCategoria() throws articoloException {
		articoloException ex = assertThrows(articoloException.class, () -> new articolo("pane", 1.0, "alimentari"));
		assertEquals("Categoria non presente", ex.getMessage());
	}

	@Test
	void testModificaQtyCosto() throws articoloException, gestioneListeException {
		gestioneListe gestioneListe = new gestioneListe();
		gestioneListe.aggiungiCategoria("carne");
		articolo articolo = new articolo("carne", 6.0, "carne");
		assertEquals("carne", articolo.getNome());
		assertEquals(DEFAULT_QTY, articolo.getQty());
		assertEquals(6.0, articolo.getCosto());
		assertEquals("carne", articolo.getCategoria());

		articolo.setCosto(10.0);
		articolo.setQty(4);

		assertEquals(10.0, articolo.getCosto());
		assertEquals(4, articolo.getQty());
	}
}
