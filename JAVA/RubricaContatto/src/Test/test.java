package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Codice.Contatto;
import Eccezioni.ContattoException;
class test {

	@Test
	void testEmailSbagliata() throws ContattoException{
		ContattoException ex1=assertThrows(ContattoException.class, ()->new Contatto("@gmail.com", "Mario Rossi"));
		assertEquals("Email non valida!", ex1.getMessage());
	}
	
	@Test
	void testNomeSbagliato() throws ContattoException{
		ContattoException ex1=assertThrows(ContattoException.class, ()->new Contatto("mario.rossi@gmail.com", "Mario Rossi12"));
		assertEquals("Nome non valido!", ex1.getMessage());
	}
	
	@Test
	void testNumeroSbagliato() throws ContattoException{
		Contatto c = new Contatto("mario.rossi@gmail.com", "Mario Rossi");
		ContattoException ex1=assertThrows(ContattoException.class, ()->c.inserisciNumTel("123adsa4567"));
		assertEquals("Numero non valido!", ex1.getMessage());
	}
	@Test
	void testCostruttoreCompleto() throws ContattoException {
		Contatto c = new Contatto("mario.rossi@gmail.com", "Mario Rossi");
		assertEquals("mario.rossi@gmail.com", c.getEmail());
		assertEquals("Mario Rossi", c.getNome());
		Contatto c2 = new Contatto("giuseppe.garibaldi@gmail.it", "Giuseppe Garibaldi");
		assertEquals("giuseppe.garibaldi@gmail.it", c2.getEmail());
		assertEquals("Giuseppe Garibaldi", c2.getNome());
	}

	@Test
	void testAggiungiNumero() throws ContattoException {
		Contatto c = new Contatto("mario.rossi@gmail.com", "Mario Rossi");
		assertTrue(c.inserisciNumTel("1234567"));
		assertFalse(c.inserisciNumTel("1234567"));
	}

	@Test
	void testEliminaNumeroAssente() throws ContattoException {
		Contatto c = new Contatto("mario.rossi@gmail.com", "Mario Rossi");
		assertFalse(c.eliminaNumTel("1234567"));
	}

	@Test
	void testEliminaNumeroPresente() throws ContattoException {
		Contatto c = new Contatto("mario.rossi@gmail.com", "Mario Rossi");
		c.inserisciNumTel("1234567");
		assertTrue(c.eliminaNumTel("1234567"));
	}

	@Test
	void testNumToString() throws ContattoException {
		Contatto c = new Contatto("mario.rossi@gmail.com", "Mario Rossi");
		c.inserisciNumTel("1234567");
		c.inserisciNumTel("2345678");
		c.inserisciNumTel("3456789");
		assertEquals("[1234567, 2345678, 3456789]", c.numTel());
	}

	@Test
	void testmatchNome() throws ContattoException {
		Contatto c = new Contatto("mario.rossi@gmail.com", "Mario Rossi");
		assertTrue(c.matchNome("Mario Rossi"));
		assertTrue(c.matchNome("Mario"));
		assertTrue(c.matchNome("Mar"));
		assertFalse(c.matchNome("Giuseppe"));
	}

	@Test
	void testmatchEMail() throws ContattoException {
		Contatto c = new Contatto("mario.rossi@gmail.com", "Mario Rossi");
		assertTrue(c.matchEmail("mario.rossi@gmail.com"));
		assertFalse(c.matchEmail("mario.rossi"));
	}

	@Test
	void testEquals() throws ContattoException {
		Contatto c = new Contatto("mario.rossi@gmail.com", "Mario Rossi");
		Contatto c2 = new Contatto("mario.rossi@gmail.com", "Mario Rossi");
		Contatto c3 = new Contatto("mario.rossi@libero.it", "Mario Rossi");
		assertTrue(c.equals(c2));
		assertFalse(c.equals(c3));
	}
	
	

}
