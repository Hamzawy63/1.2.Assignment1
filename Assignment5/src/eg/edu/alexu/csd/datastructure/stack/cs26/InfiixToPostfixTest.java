
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
		  assertEquals("AB+C+D+",(itp.infixToPostfix(infix)));
		  infix = "(A + B) * (C + D)";
		  assertEquals("AB+CD+*",(itp.infixToPostfix(infix))); 
		  infix = "A + B * C + D";
		  assertEquals("ABC*+D+",(itp.infixToPostfix(infix)));
		  infix = "A * B + C * D"; //<<<<
		  assertEquals("AB*CD*+",(itp.infixToPostfix(infix)));
		  infix = " ";
		  assertEquals("",(itp.infixToPostfix(infix)));
		  infix = "(((A+B)*C)-((D-E)*(F+G)))";
		  assertEquals("AB+C*DE-FG+*-",(itp.infixToPostfix(infix)));
		  infix = "a / b - c + d * e - a * c";
		  assertEquals("ab/c-de*+ac*-",(itp.infixToPostfix(infix)));
		  infix = "(1 + 2) * 7";
		  assertEquals("12+7*",(itp.infixToPostfix(infix)));
		  infix = "2 + 3 * 4";
		  assertEquals("234*+",(itp.infixToPostfix(infix)));
		 //(a / (b - c + d)) * (e - a) * c
		  infix = "(a / (b - c + d)) * (e - a) * c";
		  assertEquals("abc-d+/ea-*c*",(itp.infixToPostfix(infix)));
		
	}

	@Test
	public void test2() {
		infixToPostfix itp = new infixToPostfix();
		String infix;
		infix = "2 + 3 * 4"; ///  out :	A B + C + D +
		assertEquals(14,(itp.evaluate(itp.infixToPostfix(infix))));
		infix = "(1 + 2) * 7";
		assertEquals(21,(itp.evaluate(itp.infixToPostfix(infix))));
		infix = "(1 / 0) * 7";
		assertEquals(-1,(itp.evaluate(itp.infixToPostfix(infix))));



	}



}

