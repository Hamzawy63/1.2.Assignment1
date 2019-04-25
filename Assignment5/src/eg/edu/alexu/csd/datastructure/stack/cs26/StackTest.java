
package eg.edu.alexu.csd.datastructure.stack.cs26;
/*
 * made by eclipse
 * CAN NOT BE OPENED IN INTELLIJ
 * Junit 5
**/

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StackTest {
	
	@Test
	void test() {
		Stack myDamnStack = new Stack();
		myDamnStack.push(10);
        myDamnStack.push(15);
        myDamnStack.push(12);
        myDamnStack.push(13);
        assertEquals(13,myDamnStack.peek());
        assertEquals(4,myDamnStack.size());
        myDamnStack.pop();
        myDamnStack.pop();
        myDamnStack.pop();
        assertEquals(10,myDamnStack.peek());
        assertFalse(myDamnStack.isEmpty());
        myDamnStack.pop();
        assertTrue(myDamnStack.isEmpty());
	}


}
