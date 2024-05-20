package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Codice.Giudice;
import Codice.SmartComputer;

class SmartComputerTest {
	SmartComputer smartC;
	
	@BeforeEach
	void setup() {
		smartC = new SmartComputer();
	}

	@Test
	void testCostruttore() {
		assertEquals(Giudice.combValide(Giudice.comb(Giudice.LUNGHEZZA, Giudice.CHARS)).size(), smartC.numTargetPossibili());
	}
	
	@Test
	void testGenGuess() {
		smartC.addTentativo("1234", 1, 1);
		smartC.addTentativo("8259", 0, 1);
		smartC.genGuess();
		assertTrue(smartC.getTargetPossibili().contains("4537"));
		assertTrue(smartC.getTargetPossibili().contains("5430"));
		assertTrue(smartC.getTargetPossibili().contains("0531"));
		assertFalse(smartC.getTargetPossibili().contains("1234"));
		assertFalse(smartC.getTargetPossibili().contains("8524"));
	}
	
	@Test
	void proveTentativi() {
		smartC.addTentativo("1234", 0, 2);
		smartC.addTentativo("8259", 0, 2);
		smartC.addTentativo("5721", 1, 0);
		smartC.addTentativo("6345", 0, 2);
		smartC.addTentativo("7658", 2, 0);		
		smartC.genGuess();
		assertTrue(smartC.getTargetPossibili().contains("4628"));
		assertTrue(smartC.getTargetPossibili().contains("3628"));
		assertFalse(smartC.getTargetPossibili().contains("1628"));
		assertFalse(smartC.getTargetPossibili().contains("3618"));
}
}