package week1.homeassignments;

public class FindMissingElement 
{
  	    public static void main(String[] args) 
  	    {
	        int[] input =  {1, 4,3,2,8, 6,7};
	        
	        //sorting
	        int n = input.length;
	        for (int i = 0; i < n - 1; i++) 
	        {
	            for (int j = i + 1; j < n; j++) 
	            {
	                if (input[j] < input[i]) 
	                {
	                    int temp = input[i];
	                    input[i] = input[j];
	                    input[j] = temp;
	                }
	            }
	        }
	        
	        // missing number
	        System.out.println("Missing numbers:");
	        for (int i = 1; i < n; i++) 
	        {
	            for (int j = input[i - 1] + 1; j < input[i]; j++) 
	            
	            {
	               System.out.println(j);
	            }

	        }
	    }
}