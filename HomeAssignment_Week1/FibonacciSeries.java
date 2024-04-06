package week1.homeassignments;

public class FibonacciSeries 
{
	public static void main(String[] args) 
	{

            int n = 8, num1 = 0, num2 = 1, num3;

            for (int i = 1; i <= n; i++) 
            {
              System.out.println(num1);
              num3 = num1 + num2;
              num1 = num2;
              num2 = num3;
            }
	}
}
