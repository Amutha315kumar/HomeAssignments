package week5.homeassignement;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class W3SchoolBaseClass 
{

public RemoteWebDriver driver;

	@BeforeMethod
	public void preCondition()
			{
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			driver.get("https://www.w3schools.com/howto/tryit.asp?filename=tryhow_css_checkout_form");
			driver.findElement(By.xpath("//button[@id='runbtn']")).click();
			driver.switchTo().frame(1);
			}
			
			@AfterMethod
			public void postCondition()
			{
				driver.close();
			}
	}

