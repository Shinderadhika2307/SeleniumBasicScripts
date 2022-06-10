package Synchronization;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StaleException {

	public static void main(String[] args) throws InterruptedException {
		//StaleElementReferenceException
		System.setProperty("webdriver.chrome.driver", "F:\\Selenium Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("7020614851");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("312687");
		driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
		
		
		WebElement element1=driver.findElement(By.xpath("//span[text()='Become a Seller']"));
		Thread.sleep(3000);
		element1.click();

	}

}
