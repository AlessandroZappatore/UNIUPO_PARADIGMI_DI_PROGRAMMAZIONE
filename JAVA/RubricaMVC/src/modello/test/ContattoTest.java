package modello.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import modello.Contatto;
import modello.exceptions.ContattoException;

class ContattoTest {
	private Contatto c;

	@BeforeEach
	void setUp() throws ContattoException {
		c = new Contatto("test@test.it", "Test");
	}

	@AfterEach
	void tearDown() {
		c = null;
	}

	// Test costruttori
	@Test
	void testCostruttoreCompleto() throws ContattoException {
		c = new Contatto("test@test.it", "Test");

		assertEquals("test@test.it", c.getEmail());
		assertEquals("Test", c.getNome());
		// assertEquals("[]", c.numTel());
	}

	@Test
	void testCostruttoreEmail() throws ContattoException {
		c = new Contatto("test@info.it");

		assertEquals("test@info.it", c.getEmail());
		assertEquals(Contatto.getDefaultName(), c.getNome());
		// assertEquals("[]", c.numTel());
	}

	@Test
	void testCostruttoreEccezioni() {
		ContattoException ex = assertThrows(ContattoException.class,
				() -> new Contatto("test__errato?@test.it", "Test"));
		assertEquals("Formato email errato", ex.getMessage());

		ex = assertThrows(ContattoException.class, () -> new Contatto("test@test.it", "test"));
		assertEquals("Formato nome errato", ex.getMessage());

		ex = assertThrows(ContattoException.class, () -> new Contatto("test__errato?@test.it"));
		assertEquals("Formato email errato", ex.getMessage());
	}

	@Test
	void testMatchNome() {
		assertTrue(c.matchNome("Test"));
		assertTrue(c.matchNome("Te"));
		assertFalse(c.matchNome("st"));
		assertFalse(c.matchNome("Testr"));
	}

	@Test
	void testMatchEmail() {
		assertTrue(c.matchEmail("test@test.it"));
		assertFalse(c.matchEmail("test@test.itr"));
		assertFalse(c.matchEmail("test"));
	}

	@Test
	void testEquals() throws ContattoException {
		Contatto nC = new Contatto("test@test.it", "Test");
		assertTrue(c.equals(nC));
		nC = new Contatto("test2@test.it", "Testest");
		assertFalse(c.equals(nC));
	}

	@Test
	void testSetNome() throws ContattoException {
		c.setNome("Antonino");
		assertEquals("Antonino", c.getNome());

		ContattoException ex = assertThrows(ContattoException.class, () -> c.setNome("test"));
		assertEquals("Formato nome errato", ex.getMessage());

		assertEquals("Antonino", c.getNome());
	}
}
