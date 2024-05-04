package week3.homeassignment;

import java.util.ArrayList;
import java.util.List;

public class ListIntersection {

	public static void main(String[] args) 
	{	
		 int[] firstArray = {3, 2, 11, 4, 6, 7};
	     int[] secondArray = {1, 2, 8, 4, 9, 7};

	     List<Integer> equalValues = new ArrayList<Integer>();

	     for (int i = 0; i < firstArray.length; i++) 
	     {
	       if (firstArray[i] == secondArray[i]) 
	       {
	          equalValues.add(firstArray[i]);
	       }
	     }

	      System.out.println("Values that are equal:");
	      for (int i = 0; i < equalValues.size(); i++) 
	      {
	    	    System.out.println(equalValues.get(i));
	      }
	}

}
