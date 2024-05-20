import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class test {
	final double EPSILON=0.00001;

	private boolean differenza(float a, float b) {
		return ((a-b)<EPSILON);
	}
	
	
	@Test
	void testCreazioneQuadrato() {
		Quadrato q=new Quadrato(1, 1, 2);
		
		assertEquals(q.getX(), 1);
		assertEquals(q.getY(), 1);
		assertEquals(q.getLunghezza(), 2);
		
		assertTrue(differenza(q.getX(), q.getY()));
	}
	
	@Test 
	void testArea(){
		Quadrato q=new Quadrato(1, 1, 2);

		assertEquals(q.area(), 4);
		assertTrue(differenza(q.area(),4));
	}
	
	@Test
	void testPerimetro() {
		Quadrato q=new Quadrato(1, 1, 2);

		assertEquals(q.perimetro(), 8);
	}
	
	@Test
	void testContenuto() {
		Quadrato q=new Quadrato(1, 1, 2);

		assertTrue(q.contenuto(2, 2));
	}

}
