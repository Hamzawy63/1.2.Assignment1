package eg.edu.alexu.csd.datastructure.stack.cs26;

import java.sql.SQLOutput;
import java.util.Scanner;

public class myMain {

    public static void main(String[] args) {
    	infixToPostfix ptr = new infixToPostfix();

		//System.out.println(ptr.infixToPostfix("(-100 / 04) * 5"));
		//System.out.println(ptr.evaluate(ptr.infixToPostfix("10+2")));

		System.out.println("Simple USER interface for testing stack");
		System.out.println("Press 1 to push an element in the stack");
		System.out.println("Press 2 to pop an element in the stack");
		System.out.println("Press 3 for the top an element in the stack");
		System.out.println("Press 4 to check if it is empty");
		System.out.println("Press 5 to check the size");
		System.out.println("Press -1 to end");
		System.out.println("==============================================");
		int x;
		Object o = new Object();
		Scanner sc = new Scanner(System.in);
		Stack stk = new Stack();

		while ((x = sc.nextInt()) != -1)
		{
			switch (x) {
				case 1:
					System.out.println("Enter the object to push");
					o = sc.next();
					stk.push(o);
					break;
				case 2:
					if (stk.peek() == null)
						System.out.println("Empty stack");
					else
						System.out.println(stk.pop());
					break;
				case 3:
					System.out.println(stk.peek());
					break;
				case 4:
					System.out.println(stk.isEmpty());
					break;
				case 5:
					System.out.println(stk.size());
					break;
				default:
					System.out.println("Invalid output");
					break;
			}
			System.out.println("==============================================");
			System.out.println("Press 1 to push an element in the stack");
			System.out.println("Press 2 to pop an element in the stack");
			System.out.println("Press 3 for the top an element in the stack");
			System.out.println("Press 4 to check if it is empty");
			System.out.println("Press 5 to check the size");
			System.out.println("Press -1 to end");
			System.out.println("==============================================");
		}
		
	}

}

 
