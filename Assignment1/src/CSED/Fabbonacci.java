package CSED;

import java.math.BigInteger;

public class Fabbonacci {
	
	public  BigInteger findFabOfIndex(int index)
	{
		BigInteger fab1 = new BigInteger("0");
		BigInteger fab2 = new BigInteger("1");
		BigInteger temp = new BigInteger("0");
		//long fab1 = 0 ;
		//long fab2 = 1;
		//long temp = 0;
		if(index<=0)
		{
			System.out.print("INVALID THE INDEX ");
			return BigInteger.ZERO;
		}else if (index==1)
		{
			return BigInteger.ONE;
		}else if (index >930)
		{
			System.out.print("THE MAXIMUM INDEX AVAILABLE IS 93");
			System.out.print("FAB OF 93 IS ");
			index = 93;
		}
		
			for(int i =0;i<index-2;i++)
			{
				temp = fab1;
				fab1 = fab2;
				fab2 =fab2.add(temp); 
			//BigInteger add(BigInteger val)
			}
			
		
		return fab2; 
	}



}
