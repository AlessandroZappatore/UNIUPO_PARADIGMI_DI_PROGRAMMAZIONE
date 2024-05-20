package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import rubrica.Rubrica;

class RubricaTest {

	@BeforeEach
	void init() {
		Rubrica.crea();
	}

	@AfterEach
	void teardown() {
		Rubrica.svuota();
	}

	@Test
	void testCreazione() {
		Rubrica.crea();
		assertEquals(0, Rubrica.numEl());
	}

	@Test
	void testAggiungiCorretto() {
		assertEquals(1, Rubrica.aggiungi("Giovanni=345778800"));
		assertEquals(1, Rubrica.numEl());
		assertEquals(1, Rubrica.aggiungi("Giovanni=345778801"));
		assertEquals(2, Rubrica.numEl());
		assertEquals(1, Rubrica.aggiungi("Pietro=345778800"));
		assertEquals(3, Rubrica.numEl());
	}

	@Test
	void testAggiungiRipetuto() {
		Rubrica.aggiungi("Giovanni=345778800");
		assertEquals(0, Rubrica.aggiungi("Giovanni=345778800"));
		assertEquals(1, Rubrica.numEl());
	}

	@Test
	void testAggiungiOltreLimite() {
		Rubrica.aggiungi("Giovanni=345778800");
		Rubrica.aggiungi("Giovanni1=345778800");
		Rubrica.aggiungi("Giovanni2=345778800");
		assertEquals(-1, Rubrica.aggiungi("Giovanni3=345778800"));
		assertEquals(3, Rubrica.numEl());
	}

	@Test
	void testRicercaPiena() {
		Rubrica.aggiungi("Giovanni=345778800");
		Rubrica.aggiungi("Pietro=345778800");
		Rubrica.aggiungi("Luca=347758800");
		ArrayList<String> risultatoRicerca = Rubrica.ricerca("345");
		assertTrue(risultatoRicerca.contains("Giovanni=345778800"));
		assertTrue(risultatoRicerca.contains("Pietro=345778800"));
		assertFalse(risultatoRicerca.contains("Luca=347758800"));
	}

	@Test
	void testRicercaVuota() {
		ArrayList<String> risultatoRicerca = Rubrica.ricerca("345");
		assertFalse(risultatoRicerca.contains("Giovanni=345778800"));
		assertFalse(risultatoRicerca.contains("Pietro=346778800"));
		assertFalse(risultatoRicerca.contains("Luca=347758800"));
	}

	@Test
	void testPrimaUltima() {
		Rubrica.aggiungi("Giovanni=345778800");
		Rubrica.aggiungi("Pietro=346778800");
		Rubrica.aggiungi("Luca=345758800");
		ArrayList<String> risultatoRicerca = Rubrica.ricerca("345");
		assertTrue(risultatoRicerca.contains("Giovanni=345778800"));
		assertFalse(risultatoRicerca.contains("Pietro=346778800"));
		assertTrue(risultatoRicerca.contains("Luca=345758800"));
	}

	@Test
	void testRimuovi() {
		Rubrica.aggiungi("Giovanni=345778800");
		Rubrica.aggiungi("Pietro=346778800");
		Rubrica.aggiungi("Luca=345758800");
		assertFalse(Rubrica.elimina("s"));
		assertTrue(Rubrica.elimina("G"));
	}

}
