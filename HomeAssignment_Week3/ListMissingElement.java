package week3.homeassignment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListMissingElement 
{
	public static void main(String[] args) 
	{
		 List<Integer> arr = new ArrayList<Integer>();    
		    arr.add(1);
	        arr.add(2);
	        arr.add(3);
	        arr.add(4);
	        arr.add(10);
	        arr.add(6);
	        arr.add(8);
	     System.out.println("Original Array : " + arr);
		 Collections.sort(arr);
		 System.out.println("Sorted Array : " + arr);
		 for (int i = 0; i < arr.size() - 1; i++) 
		 {
	            int current = arr.get(i);
	            int next = arr.get(i + 1);
	            if (current + 1 != next) 
	            {
	            	for (int j = current + 1; j < next; j++) 
	            	{
	                System.out.println(j);
	            	}
	            }
		 }
	}
}
