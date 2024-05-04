package week4.homeassignment;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ActionsAmazon 
{
	public static void main(String[] args) throws InterruptedException, IOException 
	{	
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.amazon.in/");
		//passing search text
		WebElement searchBar = driver.findElement(By.id("twotabsearchtextbox"));
		searchBar.sendKeys("oneplus 9 pro",Keys.ENTER);		
		Thread.sleep(2000);
		//get price for first product
		WebElement price1 = driver.findElement(By.xpath("//span[@class='a-price-whole']"));
		String price2 = price1.getText();
		String price3 = price2.replaceAll(",", "");
		int getPrice = Integer.parseInt(price3);
		System.out.println("Price of the first product : " +getPrice);
		//get customer rating for first product
		WebElement rating = driver.findElement(By.xpath("//span[@class='a-size-base s-underline-text']"));
		String custRating = rating.getText();
		System.out.println("Customer rating of the first product : " +custRating);
		//click on the first link for the first product
		WebElement link = driver.findElement(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
		Actions act = new Actions(driver);
		act.moveToElement(link).click().perform();
		
		//Handling window to switch to child tab/window
		Set<String> windowCount = driver.getWindowHandles();
		List<String> windowList= new ArrayList<String>(windowCount);
		driver.switchTo().window(windowList.get(1));
		//take screenshot 
		Thread.sleep(2000);
		File src = driver.getScreenshotAs(OutputType.FILE);
		File dest = new File("./snapshot/ActionAmazon.png");
		FileUtils.copyFile(src, dest);
		System.out.println("Snapshot is successful");
		Thread.sleep(2000);
		//Add to cart 
		driver.findElement(By.xpath("(//input[@id='add-to-cart-button'])[2]")).click();
		
		//Closing the Sub Cart
		Thread.sleep(2000);
		WebElement subCart = driver.findElement(By.id("attach-close_sideSheet-link"));
		if (subCart.isDisplayed())
		{
			driver.findElement(By.id("attach-close_sideSheet-link")).click();
		}
		//Navigating to cart
		driver.findElement(By.xpath("//div[@id='nav-cart-count-container']")).click();
		
		//subtotal
		Thread.sleep(2000);
		WebElement SubPrice1 = driver.findElement(By.xpath("//span[@class='currencyINR']/parent::span"));

		String SubPrice2 = SubPrice1.getText();
		String SubPrice3 = SubPrice2.replaceAll(",", "");
		
		double number = Double.parseDouble(SubPrice3); 
		int subTotal = (int) number;
		System.out.println("Price in the cart : "+subTotal);
		
		
		if (getPrice == subTotal)
		{
			System.out.println("Price verified and it is correct");
		}
		else
		{System.out.println("Price NOT verified");}
		driver.quit();
	}
}

