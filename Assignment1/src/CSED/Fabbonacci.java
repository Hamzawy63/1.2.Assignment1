package CSED;
public class Fabbonacci {
	
	public static  long findFabOfIndex(int index)
	//RETURN LONG TO AVOID INT OVERFLOW
	{
		long fab1 = 0 ;
		long fab2 = 1;
		long temp = 0;
		if(index<=0)
		{
			System.out.print("INVALID THE INDEX ");
			return 0;
		}else if (index==1)
		{
			return 1;
		}else if (index >93)
		{
			System.out.print("THE MAXIMUM INDEX AVAILABLE IS 93");
			System.out.print("FAB OF 93 IS ");
			index = 93;
		}
		
			for(int i =0;i<index-2;i++)
			{
				temp = fab1;
				fab1 = fab2;
				fab2 +=temp; 
			}
			
		
		return fab2; 
	}


}
