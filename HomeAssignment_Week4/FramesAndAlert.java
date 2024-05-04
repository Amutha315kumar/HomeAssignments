package week4.homeassignment;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class FramesAndAlert {

	public static void main(String[] args) throws InterruptedException 
	{
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(2000);
		driver.switchTo().frame("iframeResult");
		driver.findElement(By.xpath("//button[text()='Try it']")).click();
		Thread.sleep(2000);
		Alert alert = driver.switchTo().alert();
		Thread.sleep(2000);
		String msg = alert.getText();
		System.out.println(msg);
		alert.sendKeys("Amutha Baskara");
		Thread.sleep(2000);
		alert.accept();
		String msg2 = driver.findElement(By.xpath("//p[@id='demo']")).getText();
		System.out.println(msg2);
		if(msg2.contains("Amutha Baskara"))
		{
			System.out.println("Content verified");		
		}
		else System.out.println("Content not verified");
		Thread.sleep(2000);
		driver.close(); 

	}

}
