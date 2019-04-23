package eg.edu.alexu.csd.datastructure.stack.cs26;

public class infixToPostfix {
	

public int priority(char x)
{
	if(x == '+'||x == '-')
		return 1;
	else if(x == '*'||x == '/')
		return 2;

	return 0;  // in case of we have  character
}
//public boolean is
public boolean isLowerPriority(char x,char y)
{
	if(priority(x) <= priority(y))
		return true;
	return false;
}
public boolean isSymbol(char x)
{
	return x =='+'||x =='-'||x =='*'||x =='/'||x =='('||x ==')';
}
public boolean isOperator(char x)
{
	return x =='+'||x =='-'||x =='*'||x =='/';
}
public boolean validInput(String infix)
{
	Stack paranthesis = new Stack();
	for(int i =0 ;i<infix.length() ;i++)
    {
        if(infix.charAt(i) == '(') {
            paranthesis.push('(');
            if(i == infix.length()-1)
                return false;
            else if(isOperator(infix.charAt(i+1)) )
                return false ;
            else  if (infix.charAt(i+1) == ')') // empty paranthersis
                return false;

        }else if (infix.charAt(i) == ')' )
        {
            if(paranthesis.isEmpty())
                return false;
            else
                paranthesis.pop();
        }else if (isOperator(infix.charAt(i)))
        {
            if(i == (paranthesis.size()-1))
                return false;
            else if(isOperator(infix.charAt(i+1)))
                return false;
        }
    }
	if(paranthesis.isEmpty())
	    return true;
	return false;
}


public String convertToPostfix(String infix)
{
	String postfix = "";
	Stack symbols = new Stack();
	if(validInput(infix) == false)
        System.out.println("Invalid input");

	/*HANDLING EMPTY STRING CASE */
	/*HANDLING  STRING with invalid start */
	/*HANDLING WITH PARANTHESIS UNORGANIZED INPUT*/

	for(int i =0 ;i<infix.length();i++ )
	{
		if(infix.charAt(i) == ' ' )
		{
			continue;
		}
		if(infix.charAt(i) == '(' && i ==0)
		{
			symbols.push(infix.charAt(i));
		}
		else if(!(isSymbol(infix.charAt(i)))) ///  then it is digit e.g 1 ,2 , 3 
		{
			postfix += infix.charAt(i);
		}
		else
		{
			if(symbols.isEmpty() || !(isLowerPriority(infix.charAt(i),(char)symbols.peek())) || infix.charAt(i) == '(') // if for example a * comes after +
			{
				symbols.push(infix.charAt(i));
			}else {
				/// we have to pop some elements 
				/// if we here ,we have 2 cases 
				// first : this operator is lower or equals to the peek
				/// second : it is closed paranthesis
				if(infix.charAt(i) == ')')
				{
					while((char)symbols.peek() != '(')
					{
						postfix = postfix + symbols.pop();

						if((char )symbols.peek() == '(')
							break; /// so that if there is more than one paranthesis
					}
					symbols.pop(); // remove the '('
					// loop to pop until the start of the paranthesis
				}else {
					while(!(symbols.isEmpty()) && isLowerPriority(infix.charAt(i),(char)symbols.peek()) )
					{
						postfix = postfix +  symbols.pop();
					}
					symbols.push(infix.charAt(i));
					// then pop until we reach stability
					
				}
				
			}
			
		}
				
	}
	while(symbols.isEmpty() == false)
	{
		postfix+= symbols.pop();
	}
	
	
	
	
	
	
	
	return postfix;
}
	
	
	
	
}