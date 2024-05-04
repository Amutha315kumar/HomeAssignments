package week4.homeassignment;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsSnapdeal {

	public static void main(String[] args) throws InterruptedException, IOException 
	{
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.snapdeal.com/");
		
		//Men's Fashion
		Thread.sleep(2000);
		WebElement category = driver.findElement(By.xpath("//span[@class='catText']"));		
		Actions menFashion = new Actions(driver);
		menFashion.moveToElement(category).perform();
		
		//Sports Shoes
		Thread.sleep(2000);
		WebElement footWear = driver.findElement(By.xpath("//span[@class='linkTest']"));		
		Actions sportShoes = new Actions(driver);
		sportShoes.moveToElement(footWear).click().perform();
		
		//Sport shoe count
		Thread.sleep(2000);
		String count1 = driver.findElement(By.xpath("//span[@class='category-name category-count']")).getText();
		String count2 = count1.replaceAll("[^\\d]", "");
		int shoeCount = Integer.parseInt(count2);
		System.out.println("Total number of Sport Shoes :" + shoeCount);
		
		//training shoes
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[text()='Training Shoes']")).click();
		
		//sort - Low to High
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Sort by:']/parent::div")).click();
		driver.findElement(By.xpath("//li[@class='search-li']")).click();
		
		//verify count is sorted from price low to high
		Thread.sleep(2000);
		List<WebElement> shoePrice = driver.findElements(By.xpath("//span[contains(@class,'product-price')]"));
		List<String> priceAsc1 = new ArrayList<String>();
		List<Integer> sortPrice = new ArrayList<Integer>();
		String priceAsc2;
		int priceAsc3;
		 for(int i=0; i<shoePrice.size(); i++)
		    {		    	
			 priceAsc1.add(shoePrice.get(i).getText());
			 priceAsc2 = priceAsc1.get(i);			 	
			 priceAsc3 = Integer.parseInt(priceAsc2.replaceAll("\\D", ""));
			 sortPrice.add(priceAsc3);
			 System.out.println(priceAsc3);		
		    } 

		 boolean isSorted = true;
	        for (int i = 0; i < sortPrice.size() - 1; i++) {
	            if (sortPrice.get(i) > sortPrice.get(i + 1)) {
	                isSorted = false;
	                break;
	            }
	        }
		
	        if (isSorted) {
	            System.out.println("The displayed items are sorted correctly.");
	        } else {
	            System.out.println("The displayed items are not sorted correctly.");
	        }
		//scroll To - to check range is selected as specified
		Actions scrTo = new Actions(driver);
		Thread.sleep(2000);
		WebElement scrollTo = driver.findElement(By.xpath("(//div[@class='filter-type-name lfloat'])[2]"));
		scrTo.scrollToElement(scrollTo).perform();
		
		//price range
		Thread.sleep(2000);
		WebElement leftSlide = driver.findElement(By.xpath("//a[contains(@class,'left-handle')]"));
		Actions left = new Actions(driver);
		left.dragAndDropBy(leftSlide, 10, 0).perform();
		Thread.sleep(5000);
		
		//price range
		Thread.sleep(2000);
		WebElement rightSlide = driver.findElement(By.xpath("//a[contains(@class,'right-handle')]"));
		Actions right = new Actions(driver);
		right.dragAndDropBy(rightSlide, -100, 0).perform();	
		
		//scroll To size
		Actions scrTo1 = new Actions(driver);
		Thread.sleep(2000);
		WebElement scrollTo1 = driver.findElement(By.xpath("//div[@data-filtername='Size_s']"));
		scrTo1.scrollToElement(scrollTo1).perform();
		
		//filter by any color - choosing first color
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='sdCheckbox filters-list ']")).click();
			
		//verify filters
		Thread.sleep(2000);
		List<WebElement> filter = driver.findElements(By.xpath("//div[@class='filters']"));
		List<String> applyFilter = new ArrayList<String>();
		System.out.println("Filters Applied for :");
		 for(int i=0; i<filter.size(); i++)
		    {		    	
			 applyFilter.add(filter.get(i).getText());
			 String filtersApplied = applyFilter.get(i);
			 System.out.print(filtersApplied); 
		    }
		 
		 //Mouse hover on first result
		 Thread.sleep(2000);
		 WebElement firstResult = driver.findElement(By.xpath("//img[@class='product-image wooble']"));
		 Actions result = new Actions(driver);
		 result.moveToElement(firstResult).perform();
		 
		 //Quick view button
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("//div[contains(@class,'quick-view-bar')]")).click();
		 
		 //Print Cost and discount
		 Thread.sleep(2000);		
		 String cost = driver.findElement(By.xpath("//span[@class='payBlkBig']")).getText();
		 System.out.println("\nCost of the shoe : Rs."+ cost);
		 String discount = driver.findElement(By.xpath("//span[@class='percent-desc ']")).getText();
		 System.out.println("Dicount :"+discount);
		 
		//take screenshot 
		Thread.sleep(2000);
		File src = driver.getScreenshotAs(OutputType.FILE);
		File dest = new File("./snapshot/ActionSnapdeal.png");
		FileUtils.copyFile(src, dest);
		System.out.println("Snapshot is successful");
		 
		//close current window
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//i[@class='sd-icon sd-icon-delete-sign'])[3]")).click();
		 
		driver.close();
		
	}

}
