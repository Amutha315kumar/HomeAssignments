package week1.homeassignments;

public class IsPalindrome {

	public static void main(String[] args) 
	{
		int input=22522, output = 0, rem;
		int temp = input;
	    for (;input>0; input/=10)
	    {
	    rem = input % 10;
	      output = (output * 10) + rem;
	    }

	    if (temp == output) 
	    {
	      System.out.println(temp + " is Palindrome.");
	    }
	    else  
	    {
	      System.out.println(temp + " is not Palindrome.");
	    }

	}
}
