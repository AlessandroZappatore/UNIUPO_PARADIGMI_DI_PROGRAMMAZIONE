package modello.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import modello.Contatto;
import modello.Rubrica;
import modello.exceptions.ContattoException;
import modello.exceptions.RubricaException;

class RubricaTest {

	private Rubrica r;

	@BeforeEach
	void setUp() {
		r = new Rubrica(3, "amici");
	}

	@AfterEach
	void tearDown() {
		r.svuota();
		r = null;
	}

	@Test
	void testCostruttoreCompleto() {
		r = new Rubrica(3, "amici");
		assertEquals("amici", r.getNome());

		assertEquals(3, r.getMaxDim());

		assertEquals(0, r.numEl());
	}

	@Test
	void testCostruttoreNome() {
		r = new Rubrica("amici");
		assertEquals("amici", r.getNome());

		assertEquals(Rubrica.getDefaultMaxDim(), r.getMaxDim());

		assertEquals(0, r.numEl());
	}

	@Test
	void testCostruttoreMaxDim() {
		r = new Rubrica(3);
		assertEquals("Rubrica", r.getNome());

		assertEquals(3, r.getMaxDim());

		assertEquals(0, r.numEl());
	}

	@Test
	void testCostruttoreVuoto() {
		r = new Rubrica();
		assertEquals("Rubrica", r.getNome());

		assertEquals(Rubrica.getDefaultMaxDim(), r.getMaxDim());

		assertEquals(0, r.numEl());
	}

	@Test
	void testAggiungiContattoOggetto() throws RubricaException, ContattoException {
		assertEquals(0, r.numEl());
		Contatto c = new Contatto("Test@test.it", "Nometest");
		assertEquals(1, r.aggiungi(c));
		assertEquals(1, r.numEl());

		// assertEquals(0, r.aggiungi(new Contatto("Test@test.it", "Nometest")));
		RubricaException ex = assertThrows(RubricaException.class,
				() -> r.aggiungi(new Contatto("Test@test.it", "Nometest")));
		assertEquals("Contatto già presente", ex.getMessage());
		assertEquals(1, r.numEl());

		assertEquals(1, r.aggiungi(new Contatto("Test@info.com", "Nometest")));
		assertEquals(2, r.numEl());

		assertEquals(1, r.aggiungi(new Contatto("info@test.com", "Nometest")));
		assertEquals(3, r.numEl());

		// assertEquals(-1, r.aggiungi(new Contatto("noreply@test.com", "Nometest")));
		ex = assertThrows(RubricaException.class, () -> r.aggiungi(new Contatto("noreply@test.com", "Nometest")));
		assertEquals("Dimensione massima raggiunta", ex.getMessage());
		assertEquals(3, r.numEl());
	}

	@Test
	void testAggiungiContattoEmail() throws RubricaException, ContattoException {
		assertEquals(0, r.numEl());
		assertEquals(1, r.aggiungi("Test@test.it"));
		assertEquals(1, r.numEl());

		// assertEquals(0, r.aggiungi("Test@test.it"));
		RubricaException ex = assertThrows(RubricaException.class, () -> r.aggiungi("Test@test.it"));
		assertEquals("Contatto già presente", ex.getMessage());
		assertEquals(1, r.numEl());

		assertEquals(1, r.aggiungi("Test@info.com"));
		assertEquals(2, r.numEl());

		assertEquals(1, r.aggiungi("info@test.com"));
		assertEquals(3, r.numEl());

		// assertEquals(-1, r.aggiungi("noreply@test.com"));
		ex = assertThrows(RubricaException.class, () -> r.aggiungi("noreply@test.com"));
		assertEquals("Dimensione massima raggiunta", ex.getMessage());
		assertEquals(3, r.numEl());
	}

	@Test
	void testAggiungiContattoEmailNome() throws RubricaException, ContattoException {
		assertEquals(0, r.numEl());
		assertEquals(1, r.aggiungi("Test@test.it", "Nometest"));
		assertEquals(1, r.numEl());

		// assertEquals(0, r.aggiungi("Test@test.it", "NomeTest"));
		RubricaException ex = assertThrows(RubricaException.class, () -> r.aggiungi("Test@test.it", "Nometest"));
		assertEquals("Contatto già presente", ex.getMessage());
		assertEquals(1, r.numEl());

		assertEquals(1, r.aggiungi("Test@info.com", "Nometest"));
		assertEquals(2, r.numEl());

		assertEquals(1, r.aggiungi("info@test.com", "Nometest"));
		assertEquals(3, r.numEl());

		// assertEquals(-1, r.aggiungi("noreply@test.com", "Nometest"));
		ex = assertThrows(RubricaException.class, () -> r.aggiungi("noreply@test.com", "Nometest"));
		assertEquals("Dimensione massima raggiunta", ex.getMessage());
		assertEquals(3, r.numEl());
	}

	@Test
	void testAggiungiContattoPiuRubriche() throws RubricaException, ContattoException {
		Rubrica r2 = new Rubrica();
		Contatto c = new Contatto("Test@info.it", "Testnome");

		assertEquals(0, r.numEl());
		assertEquals(0, r2.numEl());

		assertEquals(1, r.aggiungi(c));
		assertEquals(1, r.numEl());

		assertEquals(1, r2.aggiungi(c));
		assertEquals(1, r2.numEl());
	}

	@Test
	void testSvuota() throws RubricaException, ContattoException {
		assertEquals(0, r.numEl());
		assertEquals(1, r.aggiungi(new Contatto("Test@test.it", "Nometest")));
		assertEquals(1, r.numEl());
		assertEquals(1, r.aggiungi("Test@info.com"));
		assertEquals(2, r.numEl());
		assertEquals(1, r.aggiungi("info@test.com", "Nometest"));
		assertEquals(3, r.numEl());

		r.svuota();
		assertEquals(0, r.numEl());
	}

	@Test
	void testCercaNome() throws RubricaException, ContattoException {
		r.aggiungi("Eleonora@test.it", "Eleonora");
		r.aggiungi("Giovanni@test.it", "Giovanni");
		r.aggiungi("Gioele@test.it", "Gioele");

		assertEquals(1, r.cercaNome("E").size());
		assertEquals(2, r.cercaNome("Gio").size());
		assertEquals(3, r.cercaNome("").size());
		assertEquals(1, r.cercaNome("Ele").size());
		assertEquals(0, r.cercaNome("A").size());
	}

	@Test
	void testCercaEmail() throws RubricaException, ContattoException {
		r.aggiungi("Eleonora@test.it", "Eleonora");
		r.aggiungi("Giovanni@test.it", "Giovanni");
		r.aggiungi("Gioele@test.it", "Gioele");

		assertEquals(1, r.cercaEmail("Eleonora@test.it").size());
		assertEquals(0, r.cercaEmail("Gio").size());
		assertEquals(0, r.cercaEmail("@test.it").size());
	}

	@Test
	void testEliminaNome() throws RubricaException, ContattoException {
		r.aggiungi("Eleonora@test.it", "Eleonora");
		r.aggiungi("Giovanni@test.it", "Giovanni");
		r.aggiungi("Gioele@test.it", "Gioele");

		assertEquals(3, r.numEl());
		assertTrue(r.eliminaNome("Eleonora"));
		assertEquals(2, r.numEl());
		assertFalse(r.eliminaNome("Andre"));
		assertEquals(2, r.numEl());

		assertTrue(r.eliminaNome("Gio"));
		assertEquals(0, r.numEl());
	}

	@Test
	void testEliminaEmail() throws RubricaException, ContattoException {
		r.aggiungi("Eleonora@test.it", "Eleonora");
		r.aggiungi("Giovanni@test.it", "Giovanni");
		r.aggiungi("Gioele@test.it", "Gioele");

		assertEquals(3, r.numEl());
		assertTrue(r.eliminaEmail("Eleonora@test.it"));
		assertEquals(2, r.numEl());
		assertFalse(r.eliminaEmail("Andre"));
		assertEquals(2, r.numEl());

		assertTrue(r.eliminaEmail("Gioele@test.it"));
		assertEquals(1, r.numEl());
	}

}
