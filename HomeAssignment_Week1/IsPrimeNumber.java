package week1.homeassignments;

public class IsPrimeNumber 
{	    
	 public static void main(String[] args)
    	    {
    	    	  int n = 13;

    	          for (int i = 2; i < n-1; i++) 
    	          {
    	              if (i <= 1) 
    	              {
    	                  continue;
    	              }
    	              int j;
    	              for (j = 2; j <= i / 2; j++) 
    	              {
    	                  if (i % j == 0) 
    	                  {
    	                      break;
    	                  }
    	              }
    	              if (j > i / 2) 
    	              {
    	                  System.out.println("Prime Numbers are :"+i);
    	              }
    	              
    	          }
    	    }
}