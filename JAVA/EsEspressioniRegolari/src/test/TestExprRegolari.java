package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;




public class TestExprRegolari {
   String expreg1="[\\s;]+";
   String expreg2="[\\s;]*";
   char c2=',';
   String expreg3="[\\s,]+"; // "[\\s,]+"
   String s1="  ;; ;";
   String s2="  , ,";
   String s3="2345, 7888 , 99:99 10000  ";
     
	@Test
	public void testMatches() {
		assertFalse("".matches(expreg1));
		assertTrue("".matches(expreg2));
		assertTrue(s1.matches(expreg1));
		assertTrue(s1.matches(expreg2));
		assertTrue(s2.matches(expreg3));
		assertTrue("ab_Dc".matches("[\\w]*"));
		assertTrue((s1.replace(";;",",")).equals("  , ;"));
		}
	
	@Test
	public void testSplit() {
		String[] res;
		res= s3.split(expreg3);
		assertTrue(res.length==4);
		assertTrue(res[0].equals("2345"));
		assertTrue(res[1].equals("7888"));
		assertTrue(res[2].equals("99:99"));
		assertTrue(res[3].equals("10000"));

		}
	
	public void testReplace() {
		String res;
		res= s3.replace(expreg3,",");
		assertTrue(res.equals("2345,7888,99:99,10000"));

		}

}

