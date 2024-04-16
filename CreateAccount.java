package week2.homeassignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateAccount 
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
		driver.findElement(By.xpath("(//div[@class='x-panel-header']/a)[4]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='Create Account']")).click();
		driver.findElement(By.xpath("//input[@id='accountName']")).sendKeys("Test_5");
		driver.findElement(By.name("description")).sendKeys("Selenium Automation Tester.");
		
		Select dropdown = new Select(driver.findElement(By.name("industryEnumId")));
		dropdown.selectByVisibleText("Computer Software");
		
		Select dropdown2 = new Select(driver.findElement(By.name("ownershipEnumId")));
		dropdown2.selectByVisibleText("S-Corporation");
		
		Select dropdown3 = new Select(driver.findElement(By.id("dataSourceId")));
		dropdown3.selectByValue("LEAD_EMPLOYEE");
		
		Select dropdown4 = new Select(driver.findElement(By.id("marketingCampaignId")));
		dropdown4.selectByIndex(6);

		Select dropdown5 = new Select(driver.findElement(By.name("generalStateProvinceGeoId")));
		dropdown5.selectByValue("TX");

		driver.findElement(By.xpath("//input[@class='smallSubmit']")).click();
		
		WebElement e = driver.findElement(By.xpath("//table[@class='fourColumnForm']//span[@class='tabletext']"));
		System.out.println(e.getText());
		
		System.out.println("Success");

	}

}
