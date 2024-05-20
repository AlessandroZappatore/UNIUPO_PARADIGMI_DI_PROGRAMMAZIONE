import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class test {
	@Test
	void testCreazioneConto() {
		Conto c=new Conto(5000);
		
		assertEquals(c.saldo(), 5000);
	}
	
	@Test
	void testDepositaConto() {
		Conto c=new Conto(5000);
		
		c.deposita(6000);
		assertEquals(c.saldo(), 11000);
	}
	
	@Test
	void testPrelievoConto() throws Exception {
		Conto c=new Conto(5000);
		
		c.preleva(6000);
		assertEquals(c.saldo(), 5000);
		
		c.preleva(1000);
		assertEquals(c.saldo(), 4000);
	}
	
	@Test
	void testToStringConto() {
		Conto c=new Conto(5000);
		
		assertEquals("Contenuto=5000", c.toString());
	}
	
	@Test
	void testCreazioneContoEcc() {
		ContoConEccezioni c=new ContoConEccezioni(5000, 500);
		
		assertEquals(c.saldo(), 5000);
		assertEquals(c.getMaxScoperto(), 500);
		
		ContoConEccezioni c1=new ContoConEccezioni(7000);
		assertEquals(c1.saldo(), 7000);
		assertEquals(c1.getMaxScoperto(), 0);
		
	}
	
	@Test
	void testPrelievoContoEcc() throws Exception {
		ContoConEccezioni c=new ContoConEccezioni(5000, 500);
		
		c.preleva(5500);
		assertEquals(c.saldo(), -500);
		
		c.deposita(5500);
		Exception ecc=assertThrows(Exception.class, ()->c.preleva(6000));
		assertEquals("Saldo insufficiente", ecc.getMessage());
	}
	
	@Test
	void testToStringContoEcc() {
		ContoConEccezioni c=new ContoConEccezioni(5000, 500);
		assertEquals("Contenuto=5000, maxScoperto=500", c.toString());
	}

}
