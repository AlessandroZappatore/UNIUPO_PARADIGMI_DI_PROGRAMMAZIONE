package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Codice.Computer;
import Codice.Giocatore;
import Codice.Giudice;
import Codice.Tentativo;
import Codice.Umano;

class testGiocatore {

	@Test
	void testCostruttoreComputer() {
		Computer c=new Computer();
		assertNotNull(c);
	}
	
	@Test
	void testCostruttoreUmano() {
		Umano u=new Umano();
		assertNotNull(u);
	}
	
	@Test
    public void testInizializzaUmano() {
        Umano giocatoreUmano = new Umano();
        String targetPrimaDiInizializza = giocatoreUmano.getTarget();
        giocatoreUmano.inizializza();
        assertNotEquals(targetPrimaDiInizializza, giocatoreUmano.getTarget());
    }

    @Test
    public void testInizializzaComputer() {
        Computer giocatoreComputer = new Computer();
        String targetPrimaDiInizializza = giocatoreComputer.getTarget();
        giocatoreComputer.inizializza();
        assertNotEquals(targetPrimaDiInizializza, giocatoreComputer.getTarget());
    }
	
	@Test
	void testGenTarget() {
		Computer c=new Computer();
		for (int i=0; i<100; i++) {
			assertTrue(Giudice.valida(c.genTarget()));
		}
	}
	
	@Test
	void testGenGuess() {
		Computer c=new Computer();
		for (int i=0; i<100; i++) {
			assertTrue(Giudice.valida(c.generaGuess()));
		}
	}
	
	@Test
	void testAddTentativo() {
		Giocatore giocatore=new Umano();
		giocatore.inizializza();
        Tentativo tentativoValido = new Tentativo("1234", Giudice.LUNGHEZZA, 0);
        assertTrue(giocatore.addTentativo(tentativoValido.getGuess(), tentativoValido.getNumBulls(), tentativoValido.getNumMaggots()));
        assertTrue(tentativoValido.getNumBulls() == Giudice.LUNGHEZZA);

	}
}
