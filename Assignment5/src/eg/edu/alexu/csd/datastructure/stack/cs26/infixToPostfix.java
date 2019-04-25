package eg.edu.alexu.csd.datastructure.stack.cs26;

/**
 * Person
 * Created on July,4,2019
 * @author Hamza Hassan <a href ="https://www.facebook.com/profile.php?id=100008794203326">Click for Facebook</a>
 */
public class infixToPostfix implements IExpressionEvaluator {
/**
 * we use it to make it easy for determining the priority in the stack
 * @param x a symbol character 
 * @return priority of the character entered 
 */
public int priority(char x)
{
	if(x == '+'||x == '-')
		return 1;
	else if(x == '*'||x == '/')
		return 2;

	return 0;  // in case of we have  character
}
//public boolean is
/**
 * @param x  a symbol character
 *  @param y  a symbol character
 * @return a boolean of lower priority
 */
public boolean isLowerPriority(char x,char y)
{
	if(priority(x) <= priority(y))
		return true;
	return false;
}
/**
 * @param x  a symbol 
 * @return true if it is one of symbols allowed to exsist in the expression  (+,-,&amp;,/,(,)) 
 */
public boolean isSymbol(char x)
{
	return x =='+'||x =='-'||x =='*'||x =='/'||x =='('||x ==')';
}
/**
 * @param x a symbol 
 * @return true if it is one of operaors allowed to exsist in the expression (+,-,&amp;,/)
 */
public boolean isOperator(char x)
{
	return x =='+'||x =='-'||x =='*'||x =='/';
}
/**
 * check if the user entered a valid input or not 
 * invalid inputs may be like an open parenthesis or more than one operator in sequence or empty parenthesis
 * @param infix the string the user entered
 * @return true if there is no problems (e.g. all parentheses are closed..)
 */
public boolean validInput(String infix)
{
	Stack paranthesis = new Stack();
	for(int i =0 ;i<infix.length() ;i++)
    {
        if((Character.isDigit(infix.charAt(i)) || Character.isAlphabetic(infix.charAt(i)) || isSymbol(infix.charAt(i)) || infix.charAt(i) == ' ')||infix.charAt(i) == '\t')
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
        }else
        {
            return false;
        }

    }
	if(paranthesis.isEmpty())
	    return true;
	return false;
}

/**
 * @param infix the string the user entered
 * @return  postfix expression 
 */
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

/**
 * @param expression the string the user entered
 * @return  postfix expression 
 */
public String infixToPostfix(String expression)
{
	return convertToPostfix(expression);
}
/**
 * @param  postfix expression 
 * @return the value of the expression
 */
public int evaluate(String postfix)
{
	int result=0;
	Stack expression = new Stack();
	for(int i =0 ;i<postfix.length() ;i++)
	{
		if(isOperator(postfix.charAt(i)) == false && Character.isLetter((char)postfix.charAt(i) ) == false )
		{
			expression.push(Character.getNumericValue(postfix.charAt(i)));
		}else if (isOperator(postfix.charAt(i)))
		{
			int x = (int) expression.pop();
			int y = (int)expression.pop();
				switch(postfix.charAt(i))
				{
				case '+':
					expression.push(x+y); //Character.forDigit(a,10);
					break;
				case '-':
					expression.push(y-x);
					break;
				case '*':
					expression.push(x*y);
					break;
				case '/':
					if(x == 0){
					System.out.println("Division by zero is not allowed");
					return -1;
					}
					expression.push(y/x);
					break;
				default : // can not happen
					System.out.println("Error occured");					
				}
			
		}else
		{
			System.out.println("Error occured \nYour expressions can not be evaluated ");
			return -1;

		}
			
	}
	result =(int) expression.pop();
	return result;
}
	
	
	
	
}