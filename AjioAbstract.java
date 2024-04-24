package week3.homeassignment;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class AjioAbstract implements AjioInterface 
{
	ChromeDriver driver = new ChromeDriver();
	
	public void LaunchUrl()
	{		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		driver.manage().window().maximize();
		driver.get("https://www.ajio.com/");
	}
	public void SearchBox() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='searchVal']")).sendKeys("Bags");
		driver.findElement(By.xpath("//button[@class='rilrtl-button']")).click();
	}
	public void filter() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.findElement(By.xpath("//label[@for='Men']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//label[contains(@for,'Men - Fashion Bags')]")).click();
		Thread.sleep(2000);
	}

	public void CountItems() throws InterruptedException
	{		
		String searchResult = driver.findElement(By.xpath("//div[@class='length']")).getText();
		System.out.println(searchResult); 		
	}

	public void GetList()  throws InterruptedException
	{	
		 Thread.sleep(2000);
		 List<WebElement> brand = driver.findElements(By.xpath("//div[@class='brand']"));
		 List<WebElement> bag = driver.findElements(By.xpath("//div[@class='nameCls']"));
			
		 Thread.sleep(2000);
		 List<String> brandName = new ArrayList<String>();		//Brand name list    
		 System.out.println("\nList of Brand Names : " );
		 for(int i=0; i<brand.size(); i++)
		    {		    	
			 brandName.add(brand.get(i).getText());
			 System.out.println(brandName.get(i));
		    }
		 
		 List<String> bagName = new ArrayList<String>();		//Bag name list    
		 System.out.println("\n \nList of Bag Names : " );
		 for(int i=0; i<bag.size(); i++)
		    {		    	
			 bagName.add(bag.get(i).getText()); 
			 System.out.println(bagName.get(i));
		    }
		 
	}
}
