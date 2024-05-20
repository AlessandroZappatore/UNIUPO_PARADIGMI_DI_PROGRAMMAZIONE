package Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import Codice.Contatto;
import Codice.Rubrica;
import Eccezioni.ContattoException;
import Eccezioni.RubricaException;

class TestRubrica {

    @Test
    void testRubrica() {
        Rubrica r1 = new Rubrica(3, "amici");
        Rubrica r2 = new Rubrica(5, "casa");
        assertEquals("amici", r1.getNome());
        assertEquals("casa", r2.getNome());
        assertEquals(3, r1.getMaxDim());
        assertEquals(5, r2.getMaxDim());
        assertEquals(0, r1.numEl());
        assertEquals(0, r2.numEl());
    }

    @Test
    void testAggiungiRipetuto() throws RubricaException, ContattoException {
        Rubrica r1 = new Rubrica(3, "persone");
        assertEquals(1, r1.aggiungi("mario.rossi@gmail.com", "Mario Rossi"));
        assertEquals(1, r1.numEl());
        RubricaException ex1=assertThrows(RubricaException.class, ()->r1.aggiungi("mario.rossi@gmail.com", "Mario Rossi"));
        assertEquals("Contatto gia' presente!", ex1.getMessage());
        Rubrica r2 = new Rubrica(5, "amici");
        assertEquals(1, r2.aggiungi("mario.rossi@gmail.com", "Mario Rossi"));
        assertEquals(1, r2.numEl());
        RubricaException ex2=assertThrows(RubricaException.class, ()->r1.aggiungi("mario.rossi@gmail.com", "Mario Rossi"));
        assertEquals("Contatto gia' presente!", ex2.getMessage());
    }
    
    @Test
    void testAggiungiOltreAlLimite() throws RubricaException, ContattoException{
    	Rubrica r1=new Rubrica(3, "Persone");
    	assertEquals(1, r1.aggiungi("mario.rossi@gmail.com", "Mario Ros"));
        assertEquals(1, r1.aggiungi("mario.rossi2@gmail.com", "Mario Ross"));
        assertEquals(1, r1.aggiungi("mario.rossi3@gmail.com", "Mario Rossi"));
        
        RubricaException ex1=assertThrows(RubricaException.class, ()->r1.aggiungi("mario.rossi4@gmail.com", "Mario Rossi"));
        assertEquals("Dimensione eccessiva!", ex1.getMessage());
    }

    @Test
    void testAggiungiContatto() throws RubricaException, ContattoException {
        Rubrica r1 = new Rubrica(3, "persone");
        assertEquals(1, r1.aggiungi("mario.rossi@gmail.com", "Mario Rossi"));
        assertEquals(1, r1.numEl());
        Contatto c = new Contatto("giuseppe.garibaldi@gmail.it", "Giuseppe Garibaldi");
        c.inserisciNumTel("1234567");
        assertEquals(1, r1.aggiungi(c));
        assertEquals(2, r1.numEl());
    }


    @Test
    void testCercaPerNome() throws RubricaException, ContattoException {
        Rubrica r1 = new Rubrica(3, "persone");
        assertEquals(1, r1.aggiungi("mario.rossi@gmail.com", "Mario Rossi"));
        assertEquals(1, r1.numEl());
        Contatto c = new Contatto("giuseppe.garibaldi@gmail.it", "Giuseppe Garibaldi");
        c.inserisciNumTel("1234567");
        assertEquals(1, r1.aggiungi(c));
        assertEquals(2, r1.numEl());

        ArrayList<Contatto> risultato = r1.ricercaPerNome("Giuseppe");
        assertEquals("Giuseppe Garibaldi", risultato.get(0).getNome());
        ArrayList<Contatto> risultato2 = r1.ricercaPerNome("Ma");
        ArrayList<Contatto> atteso = new ArrayList<>();
        atteso.add(new Contatto("mario.rossi@gmail.com", "Mario Rossi"));
        assertEquals(atteso, risultato2);
        ArrayList<Contatto> risultato3 = r1.ricercaPerNome("Danilo");
        assertTrue(risultato3.isEmpty());
    }

    @Test
    void testCercaPerEmail() throws RubricaException, ContattoException {
        Rubrica r1 = new Rubrica(3, "persone");
        assertEquals(1, r1.aggiungi("mario.rossi@gmail.com", "Mario Rossi"));
        assertEquals(1, r1.numEl());
        Contatto c = new Contatto("giuseppe.garibaldi@gmail.it", "Giuseppe Garibaldi");
        c.inserisciNumTel("1234567");
        assertEquals(1, r1.aggiungi(c));
        assertEquals(2, r1.numEl());

        ArrayList<Contatto> risultato = r1.ricercaPerEmail("giuseppe.garibaldi@gmail.it");
        assertEquals("Giuseppe Garibaldi", risultato.get(0).getNome());
        ArrayList<Contatto> risultato2 = r1.ricercaPerEmail("Ma");
        assertTrue(risultato2.isEmpty());
    }

    @Test
    void testEliminaPerNome() throws RubricaException, ContattoException {
        Rubrica r1 = new Rubrica(3, "persone");
        assertEquals(1, r1.aggiungi("mario.rossi@gmail.com", "Mario Rossi"));
        assertEquals(1, r1.numEl());
        Contatto c = new Contatto("giuseppe.garibaldi@gmail.it", "Giuseppe Garibaldi");
        c.inserisciNumTel("1234567");
        assertEquals(1, r1.aggiungi(c));
        assertEquals(2, r1.numEl());
        assertTrue(r1.eliminaPerNome("Giuseppe"));
        assertEquals(1, r1.numEl());
        assertFalse(r1.eliminaPerNome("Giuseppe"));
    }

    @Test
    void testEliminaPerEmail() throws RubricaException, ContattoException {
        Rubrica r1 = new Rubrica(3, "persone");
        assertEquals(1, r1.aggiungi("mario.rossi@gmail.com", "Mario Rossi"));
        assertEquals(1, r1.numEl());
        Contatto c = new Contatto("giuseppe.garibaldi@gmail.it", "Giuseppe Garibaldi");
        c.inserisciNumTel("1234567");
        assertEquals(1, r1.aggiungi(c));
        assertEquals(2, r1.numEl());
        assertTrue(r1.eliminaPerEmail("giuseppe.garibaldi@gmail.it"));
        assertEquals(1, r1.numEl());
        assertFalse(r1.eliminaPerEmail("giuseppe.garibaldi@gmail.it"));
        assertFalse(r1.eliminaPerEmail("mario.rossi@libero.it"));
    }
    
    @Test
    void testIterator() throws ContattoException, RubricaException {
        Rubrica rubrica = new Rubrica();
        Contatto contatto1 = new Contatto("mario.rossi@gmail.com", "Mario Rossi");
        Contatto contatto2 = new Contatto("giuseppe.garibaldi@gmail.it", "Giuseppe Garibaldi");
        rubrica.aggiungi(contatto1);
        rubrica.aggiungi(contatto2);

        int count = 0;
        for (Contatto contatto : rubrica) {
            System.out.println("Contatto: " + contatto.getEmail() + ", " + contatto.getNome());
            count++;
        }
        
        assertEquals(2, count);
    }

}
