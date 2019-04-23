package eg.edu.alexu.csd.datastructure.stack.cs26;

public class myMain {

    public static void main(String[] args) {
    	
    	infixToPostfix itp = new infixToPostfix();
    	//String infix = "(A+B/C*(D+E)-F)";
    	//String infix = "((A+B)- C*(D/E))+F";
    	//String infix = "A +B + C+ D"; ///  out :	A B + C + D +
    	//String infix = "(A + B) * (C + D)"; // out :	A B + C D + *
    	// infix = "A + B * C + D"; // out : 	A B C * + D +
    	//String infix = "A * B + C * D"; // out : A B * C D * +
    	//String infix = "A * B + C * D"; // out : A B * C D * +
    	//String infix = " "; // out no response
    	String infix = "(((A+B)*C)-((D-E)*(F+G)))";  // out : AB+C*DE-FG+*-
    	System.out.println(itp.convertToPostfix(infix));
    
    }
    
}
