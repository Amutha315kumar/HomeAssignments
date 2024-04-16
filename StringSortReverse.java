package week3.homeassignment;

import java.util.ArrayList;
import java.util.Collections;

public class StringSortReverse 
{
	public static void main(String[] args) 

	{
		String[] company1 = {"HCL", "Wipro", "Aspire Systems", "CTS"};
		
		ArrayList<String> companyList = new ArrayList<String>();
		
		System.out.println("Original order:");
		for (int i = 0; i < company1.length; i++) 
		{
			companyList.add(company1[i]);
			System.out.println(company1[i]);
        }

		
        Collections.sort(companyList, Collections.reverseOrder());

        System.out.println("\nSorted order:");
        for (int i = 0; i < companyList.size(); i++) {
            String company2 = companyList.get(i);
            System.out.println(company2);
        }
	}

}
