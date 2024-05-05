package week5.homeassignement;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataClass extends W3SchoolBaseClass
{
	@DataProvider(name="getData")
	public String[][] fetchData() throws IOException
	{
	return ExcelToData.excelSheet();
	}
	
	@Test (dataProvider ="getData")
	public void InputData(String fName, String eMail, String address, String city,String state, String zip,String cvv,String cardNum,String cardName) throws InterruptedException 
	{

		//Billing Address
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys(fName); //firstName
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys(eMail); //eMail
		driver.findElement(By.xpath("//input[@name='address']")).sendKeys(address); //address
		driver.findElement(By.xpath("//input[@name='city']")).sendKeys(city); //city
		driver.findElement(By.xpath("//input[@name='zip']")).sendKeys(zip); //zipCode
		driver.findElement(By.xpath("//input[@name='state']")).sendKeys(state); //state
		
		//Payment
		driver.findElement(By.xpath("//input[@name='cardname']")).sendKeys(cardName);
		driver.findElement(By.xpath("//input[@name='cardnumber']")).sendKeys(cardNum);
		driver.findElement(By.xpath("//input[@name='expmonth']")).sendKeys("October");
		driver.findElement(By.xpath("//input[@name='cvv']")).sendKeys(cvv);
		driver.findElement(By.xpath("//input[@name='expyear']")).sendKeys("2018");

}
}
