package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import codice.EsMetodi;

class EsMetodiTest {
//
//	@Test
//	void testMiaSomma() {
//		assertEquals(5, EsMetodi.miaSomma(3, 1, 2, 2, 5, 7));
//		assertEquals(0, EsMetodi.miaSomma(0, 1, 2, 2, 5, 7));
//		assertEquals(0, EsMetodi.miaSomma(5));
//		assertEquals(3, EsMetodi.miaSomma(2, 1, 2, 3, 4, 5, 6));
//	}
//	
//	@Test
//	void testOverloading() {
//		//assertEquals(0, EsMetodi.media(3, 4));
//		assertEquals(0, EsMetodi.media((long)3,4));
//		assertEquals(0, EsMetodi.media(3,(long)4));
//	}
//
	@Test
	void testGeneric() {
	    Integer a1[]= {0,1,2,3};
	    EsMetodi.swap(a1, 1, 3);
		assertEquals(1,a1[3]);
		assertEquals(3,a1[1]);
	    Integer a2[]= {0,1,2,3};
	    EsMetodi.swap(a2, 1, 4);
		assertEquals(1,a2[1]);
		assertEquals(3,a2[3]);

//		assertEquals(0, EsMetodi.media((long)3,4));
//		assertEquals(0, EsMetodi.media(3,(long)4));
	}
	
	@Test
	void testSomma() {
		assertEquals(3,EsMetodi.miaSomma(2,1,2,3,4));
		assertEquals(5,EsMetodi.miaSomma(3,1,4));
	}


}