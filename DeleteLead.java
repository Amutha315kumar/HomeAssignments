package week2.homeassignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DeleteLead 
{

	public static void main(String[] args) throws InterruptedException 
	{
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));			
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.xpath("//a[text()='Leads']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys("8056");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(1000);
		WebElement leadID = driver.findElement(By.xpath("//td[@tabindex='0']//a"));
		String leadIDText = leadID.getText(); 
		System.out.println(leadIDText);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//td[@tabindex='0']//a")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='Delete']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
		WebElement input = driver.findElement(By.xpath("//input[@name='id']"));
		input.sendKeys(leadIDText);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(1000);
		String expectedMessage = "No records to display";
		WebElement message = driver.findElement(By.xpath("//div[text()='No records to display']"));
		String actualMessage = message.getText();
		if (actualMessage.equals(expectedMessage))
		{
			 System.out.println("Presence of the message " + actualMessage + " is verified");
    	} 
		else 
		{
			System.out.println("Presence of the message -" + actualMessage + "- is not verified");
		}
		driver.close();
	}

}
