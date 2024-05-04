package week4.homeassignment;

import java.util.LinkedHashSet;
import java.util.Set;

public abstract class SetClass implements SetInterface
{
	String companyName = "google";
	public void input()
	{
		System.out.println("Entered String Name : " + companyName);
	}
	public void uniqueCharacters() 
	{
		 Set<Character> uniChar = new LinkedHashSet<Character>();
	     char[] charArray = companyName.toCharArray();
	     for (int i = 0; i < charArray.length; i++) 
	     {
	    	 uniChar.add(charArray[i]);
	     }

	  System.out.print("Unique characters in the string \"" + companyName + "\": ");
	  for (int i = 0; i <= uniChar.size()-1; i++) 
	  {
	        System.out.print(uniChar.toArray()[i]);
	  }
        
	}
	
}

