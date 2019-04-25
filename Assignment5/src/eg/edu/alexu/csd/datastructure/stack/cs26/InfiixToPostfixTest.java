
package eg.edu.alexu.csd.datastructure.stack.cs26;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;



public class InfiixToPostfixTest {

	@Test
	public void test() {
		
		 // >> ALL THOSE CASES GENERATED CORRECT ANSWER
		 infixToPostfix itp = new infixToPostfix();
		 String infix;
		  infix = "A +B + C+ D"; ///  out :	A B + C + D +
		  assertEquals("A B + C + D + ",(itp.infixToPostfix(infix)));
		  infix = "(A + B) * (C + D)";
		  assertEquals("A B + C D + * ",(itp.infixToPostfix(infix)));
		  infix = "A + B * C + D";
		  assertEquals("A B C * + D + ",(itp.infixToPostfix(infix)));
		  infix = "A * B + C * D"; //<<<<
		  assertEquals("A B * C D * + " ,(itp.infixToPostfix(infix)));
		  infix = " ";
		  assertEquals("",(itp.infixToPostfix(infix)));
		  infix = "(((A+B)*C)-((D-E)*(F+G)))";
		  assertEquals("A B + C * D E - F G + * - ",(itp.infixToPostfix(infix)));
		  infix = "a / b - c + d * e - a * c";
		  assertEquals("a b / c - d e * + a c * - ",(itp.infixToPostfix(infix)));
		  infix = "(1 + 2) * 7";
		  assertEquals("1 2 + 7 * ",(itp.infixToPostfix(infix)));
		  infix = "2 + 3 * 4";
		  assertEquals("2 3 4 * + ",(itp.infixToPostfix(infix)));
		 //(a / (b - c + d)) * (e - a) * c
		  infix = "(a / (b - c + d)) * (e - a) * c";
		  assertEquals("a b c - d + / e a - * c * ",(itp.infixToPostfix(infix)));
		
	}

	@Test
	public void test2() {
		infixToPostfix itp = new infixToPostfix();
		String infix;
		infix = "2 + 3 * 4"; ///  out :	A B + C + D +
		assertEquals(14,(itp.evaluate(itp.infixToPostfix(infix))));
		infix = "(1 + 2) * 7";
		assertEquals(21,(itp.evaluate(itp.infixToPostfix(infix))));
		infix = "(12 / 3) * 7";
		assertEquals(28,(itp.evaluate(itp.infixToPostfix(infix))));
		infix = "(12 / 0) * 7";
		assertEquals(-1,(itp.evaluate(itp.infixToPostfix(infix))));
		infix = "(100 / 04) * 5";
		assertEquals(125,(itp.evaluate(itp.infixToPostfix(infix))));



	}



}

