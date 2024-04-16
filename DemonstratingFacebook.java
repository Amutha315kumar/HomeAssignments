package week2.homeassignments;

import java.time.Duration;
import org.openqa.selenium.By;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DemonstratingFacebook 
{
	public static void main(String[] args) throws InterruptedException 
	{
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://en-gb.facebook.com/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();
				
		//Input
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Firstname");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Lastname");
		driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("Firstname@gmail.com");
		driver.findElement(By.xpath("//input[@name='reg_passwd__']")).sendKeys("password");
		
		//dropdown
		Select date = new Select(driver.findElement(By.id("day")));
		date.selectByVisibleText("2");
		Select month = new Select(driver.findElement(By.id("month")));
		month.selectByVisibleText("Sep");
		Select year = new Select(driver.findElement(By.id("year")));
		year.selectByValue("2009");
		driver.findElement(By.xpath("//label[text()='Female']")).click();
	}

}

