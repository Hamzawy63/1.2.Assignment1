
package eg.edu.alexu.csd.datastructure.stack.cs26;
/*
 * made by eclipse
 * CAN NOT BE OPENED IN INTELLIJ
 */

import org.junit.jupiter.api.Test;

class StackTest {
	
	@Test
	void test() {
		Stack myDamnStack = new Stack();
		myDamnStack.push(10);
        myDamnStack.push(15);
        myDamnStack.push(12);
        myDamnStack.push(13);
        assassertEquals(13,myDamnStack.peek());
        assassertEquals(4,myDamnStack.size());
        myDamnStack.pop();
        myDamnStack.pop();
        myDamnStack.pop();
        assassertEquals(10,myDamnStack.peek());
        assassertFalse(myDamnStack.isEmpty());
        myDamnStack.pop();
        assassertTrue(myDamnStack.isEmpty());
	}

	private void assassertTrue(boolean empty) {
		// TODO Auto-generated method stub
		
	}

	private void assassertFalse(boolean empty) {
		// TODO Auto-generated method stub
		
	}

	private void assassertEquals(int i, Object peek) {
		// TODO Auto-generated method stub
		
	}
}
