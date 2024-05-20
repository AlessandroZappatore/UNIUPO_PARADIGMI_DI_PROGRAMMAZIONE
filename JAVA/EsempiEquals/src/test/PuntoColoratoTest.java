package test;


import jbook.util.Input;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import codice.Punto;
import codice.PuntoColorato;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PuntoColoratoTest {

	@Test
	void test() {
		Punto p1 = new Punto (0 ,1, "P1");
		PuntoColorato pC1 = new PuntoColorato(0,1,"pC1"); 
		PuntoColorato pC2 = new PuntoColorato(0,1,"pC2");
		Input.readString("**** Esecuzione pC1.equals(p1)****\n");
		assertEquals(false,pC1.equals(p1));
		Input.readString("\n\n**** Esecuzione pC1.equals(pc2)****\n");
		assertEquals(true,pC1.equals(pC2));
	}

}
