package CSED;

public class MySpecialArrayUtils {
	 public static  void reverse(int[] arr)
	 {
		 int i,temp,j; ///counter 
		 for(i=0,j=arr.length-1;i<arr.length/2;i++,j--)
		 {
			 temp = arr[i];
			 arr[i]= arr[j];
			 arr[j] = temp;
			
		 }
		 
	 }
	 public static  int[] sumEvenOdd(int[] arr)
	 {
		 //int Final[] = new int [2];
		int [] Final = {0,0};
		 for(int i=0;i<arr.length;i++)
		 {
			 if(arr[i]%2==0)
				 {Final[0] +=arr[i];}
			 else 
				 {Final[1]+=arr[i];}

			
		 }
		 return Final;
		 
	 }
	 public static  double average(int[] arr)
	{
		 double average=0;
		 int i;
		 for(i =0;i<arr.length;i++)
		 {
			 average += arr[i]; ///THE AVERAGE IS THE SUM OF ARRAY ELEMENTS  TILL NOW
			 
		 }
		 return average/i;
		
	}
	 
	 public  static void moveValue(int[] arr, int val) 
		{
			int i,j,k=1,temp; ///counters
			for(i =0;i<arr.length+1-k;i++)
			{
				if(arr[i]==val)
				{

					///A LOOP TO SHIFT ALL THE REST ELEMENT
					for(j=i;j<arr.length-k;j++)
					{
						temp = arr[j];
						arr[j]= arr[j+1];
						arr[j+1] = temp;
					}
					/// IMPORTANT
					i--;
					k++;
				}
			}
			
		}
		
	
	public  static void transpose(int[][] arr) 
	{
		
		int m = arr.length; ///THE ARRAY IS M*M
		for(int i = 0;i<arr.length;i++)
		{
			for(int j = i;j<arr.length;j++)
			{				
				 int temp  = arr[i][j];
				 arr[i][j] = arr[j][i];
				 arr[j][i] = temp;				
			}
		}	
	}
		
			
	}
	


