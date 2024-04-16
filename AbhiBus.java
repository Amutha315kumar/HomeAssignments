package marathon1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class AbhiBus 
{

	public static void main(String[] args) throws InterruptedException 
	{
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.get("https://www.abhibus.com/");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@placeholder='From Station']")).sendKeys("chennai");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//li[contains(@class,'collection-item auto-complete-list-item')]")).click();
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@placeholder='To Station']")).sendKeys("bangalore");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//li[contains(@class,'collection-item auto-complete-list-item ')]")).click();
		
		driver.findElement(By.xpath("//button[text()='Tomorrow']")).click();
		Thread.sleep(2000);
		String name = driver.findElement(By.xpath("//div[contains(@class,'col')]//h5[@class='title']")).getText();
		System.out.println(name);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='row filter-wrapper']//a[4]")).click();
		Thread.sleep(2000);
		String seatCount = driver.findElement(By.xpath("//div[contains(@id,'service-operator-select-seat')]//small")).getText();
		System.out.println(seatCount);
		
		driver.findElement(By.xpath("//button[text()='Show Seats']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@class='seat sleeper']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[contains(@class,'container')]//input[@type='checkbox'])[2]")).click();
		driver.findElement(By.xpath("(//div[contains(@class,'container')]//input[@type='checkbox'])[2]")).click();
		Thread.sleep(2000);
		//seat selected and price
		String seatSelected = driver.findElement(By.xpath("//div[@class='row selectedSeatDetails']/span")).getText();
		System.out.println(seatSelected);
		Thread.sleep(2000);
		String price = driver.findElement(By.xpath("(//div[@class='row selectedSeatDetails']//span[2][@class='text-primary'])")).getText();
		System.out.println(price);
		Thread.sleep(2000);
		System.out.println(driver.getTitle());
		
		Thread.sleep(3000);
		driver.close();
	}

}
