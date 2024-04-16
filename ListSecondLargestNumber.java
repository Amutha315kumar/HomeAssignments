package week3.homeassignment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListSecondLargestNumber {

	public static void main(String[] args) 
	{
	    List<Integer> arr = new ArrayList<Integer>();    
	    arr.add(3);
        arr.add(2);
        arr.add(11);
        arr.add(4);
        arr.add(6);
        arr.add(7);
        System.out.println("Original Array : " + arr);
        
		Collections.sort(arr);
		int size = arr.size()-2;
		int value = arr.get(size);
		
		System.out.println("Sorted Array : " + arr);
		System.out.println("Second Largest : " + value);

	}
	}

