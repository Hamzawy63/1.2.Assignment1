package eg.edu.alexu.csd.datastructure.stack.cs26;

import static org.junit.Assert.*;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.*;


public class InfiixToPostfixTest {

	@Test
	public void test() {
		
		 // >> ALL THOSE CASES GENERATED CORRECT ANSWER
		 infixToPostfix itp = new infixToPostfix();
		 String infix;
		  infix = "A +B + C+ D"; ///  out :	A B + C + D +
		  assertEquals("AB+C+D+",(itp.convertToPostfix(infix)));
		  infix = "(A + B) * (C + D)";
		  assertEquals("AB+CD+*",(itp.convertToPostfix(infix))); 
		  infix = "A + B * C + D";
		  assertEquals("ABC*+D+",(itp.convertToPostfix(infix)));
		  infix = "A * B + C * D"; //<<<<
		  assertEquals("AB*CD*+",(itp.convertToPostfix(infix)));
		  infix = " ";
		  assertEquals("",(itp.convertToPostfix(infix)));
		  infix = "(((A+B)*C)-((D-E)*(F+G)))";
		  assertEquals("AB+C*DE-FG+*-",(itp.convertToPostfix(infix)));
		  infix = "a / b - c + d * e - a * c";
		  assertEquals("ab/c-de*+ac*-",(itp.convertToPostfix(infix)));
		  infix = "(1 + 2) * 7";
		  assertEquals("12+7*",(itp.convertToPostfix(infix)));
		  infix = "2 + 3 * 4";
		  assertEquals("234*+",(itp.convertToPostfix(infix)));
		 //(a / (b - c + d)) * (e - a) * c
		  infix = "(a / (b - c + d)) * (e - a) * c";
		  assertEquals("abc-d+/ea-*c*",(itp.convertToPostfix(infix)));
		  
		/**
		 String infix8 = " "; // out no response
		 System.out.println(itp.convertToPostfix(infix8));
		 String infix = "(((A+B)*C)-((D-E)*(F+G)))";  // out : 
		 System.out.println(itp.convertToPostfix(infix));
		 String wrong = ";
		 System.out.println(itp.convertToPostfix(wrong));
		 
		 **/
		
	}

	

	
}
