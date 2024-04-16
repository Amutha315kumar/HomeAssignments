package week2.homeassignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class EditLead 
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
			driver.findElement(By.xpath("//a[text()='Create Lead']")).click();
			driver.findElement(By.xpath("//input[@name='companyName' and @id='createLeadForm_companyName']")).sendKeys("Company1");
			driver.findElement(By.xpath("//input[@name='firstName' and @id='createLeadForm_firstName']")).sendKeys("Firstname1");
			driver.findElement(By.xpath("//input[@name='lastName' and @id='createLeadForm_lastName']")).sendKeys("Lastname1");
			driver.findElement(By.xpath("//input[@name='firstNameLocal' and @id='createLeadForm_firstNameLocal']")).sendKeys("Firstname1_local");
			driver.findElement(By.xpath("//input[@name='departmentName']")).sendKeys("IT");
			driver.findElement(By.xpath("//textarea[@name='description']")).sendKeys("My Description - IT");
			driver.findElement(By.xpath("//input[@name='primaryEmail' and @id='createLeadForm_primaryEmail']")).sendKeys("Firstname1@gmail.com");
			Select state = new Select(driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId")));
			state.selectByVisibleText("New York");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@value='Create Lead']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//a[text()='Edit']")).click();
			driver.findElement(By.xpath("//textarea[@name='description']")).clear();
			driver.findElement(By.xpath("//textarea[@name='importantNote']")).sendKeys("Description removed and Important Notes added");
			driver.findElement(By.xpath("//input[@value='Update']")).click();
			Thread.sleep(2000);
			System.out.println(driver.getTitle());
			driver.close();
	}

}
