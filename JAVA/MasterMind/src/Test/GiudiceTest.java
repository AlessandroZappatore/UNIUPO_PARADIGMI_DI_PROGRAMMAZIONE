package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Codice.Giudice;

class GiudiceTest {

	@Test
	void testValidaLunghezza() {
		assertTrue(Giudice.valida("3617"));
		assertFalse(Giudice.valida("361789"));
		assertFalse(Giudice.valida("36"));
		assertFalse(Giudice.valida(""));
		assertTrue(Giudice.valida("3124"));
	}

	@Test
	void testValidaCaratteri() {
		assertTrue(Giudice.valida("3617"));
		assertFalse(Giudice.valida("567!"));
		assertFalse(Giudice.valida("ab%t"));
		assertTrue(Giudice.valida("3124"));
	}

	@Test
	void testValidaNonRipetuti() {
		assertTrue(Giudice.valida("3617"));
		assertFalse(Giudice.valida("9923"));
		assertFalse(Giudice.valida("5667"));
		assertFalse(Giudice.valida("1233"));
	}

	@Test
	void testValidaNumBulls() {
		assertEquals(0, Giudice.numBulls("1234", "5678"));
		assertEquals(1, Giudice.numBulls("1234", "1876"));
		assertEquals(1, Giudice.numBulls("1234", "9874"));
		assertEquals(1, Giudice.numBulls("1234", "9243"));
		assertEquals(1, Giudice.numBulls("9876", "5573"));
		assertEquals(2, Giudice.numBulls("1234", "1256"));
		assertEquals(2, Giudice.numBulls("1234", "1537"));
		assertEquals(2, Giudice.numBulls("1234", "1764"));
		assertEquals(2, Giudice.numBulls("1234", "8237"));
		assertEquals(2, Giudice.numBulls("1234", "9834"));
		assertEquals(3, Giudice.numBulls("9264", "9261"));
		assertEquals(3, Giudice.numBulls("9264", "9284"));
		assertEquals(3, Giudice.numBulls("9264", "9764"));
		assertEquals(3, Giudice.numBulls("9264", "5264"));
		assertEquals(4, Giudice.numBulls("9264", "9264"));
		assertEquals(4, Giudice.numBulls("8725", "8725"));
	}
	
	@Test
	void testNumMaggots() {
		assertEquals(0, Giudice.numMaggots("1234", "1234"));
		assertEquals(4, Giudice.numMaggots("1234", "4321"));
		assertEquals(2, Giudice.numMaggots("8234", "3746"));
		assertEquals(1, Giudice.numMaggots("8234", "9763"));
		assertEquals(3, Giudice.numMaggots("1234", "2345"));
		assertEquals(2, Giudice.numMaggots("8643", "2465"));
		assertEquals(3, Giudice.numMaggots("9210", "0194"));
		assertEquals(0, Giudice.numMaggots("3213", "0897"));
		assertEquals(1, Giudice.numMaggots("3176", "1845"));
		assertEquals(4, Giudice.numMaggots("5943", "3459"));
	}
	
	@Test
	void testGenTarget() {
		for (int i=0; i<100; i++) {
			assertTrue(Giudice.valida(Giudice.genTarget()));
		}
	}
}
