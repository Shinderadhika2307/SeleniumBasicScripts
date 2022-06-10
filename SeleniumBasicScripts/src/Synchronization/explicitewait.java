
package Synchronization;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//resolved staleElementReferenceException and ElementClickInturruptEdexception
public class explicitewait {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "F:\\Selenium Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("7020614851");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("312687");
		driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
		
		// ElementClickInturruptEdexception solution by javascriptExecutor
		 driver.findElement(By.xpath("//input[@title='Search for products, brands and more']")).sendKeys("realme");
		WebElement element1= driver.findElement(By.xpath("//button[@type='submit']"));
		 JavascriptExecutor js=(JavascriptExecutor)driver; //used because ElementClickInturruptEdexception occure
		 js.executeScript("arguments[0].click()", element1);
		 
		// staleElementReferenceException solution explicite Waits
       WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='_1fQZEK']"))).click();

// staleElementReferenceException solution by try catch
//for(int i=0;i<2;i++)
//{
//	 try
//	 {
//		 driver.findElement(By.xpath("//button[@type='submit']")).click();
//		 break;
//	 }
//	 catch(Exception e)
//	 {
//		System.out.println(e.getMessage()); 
//	 }
//}

			
		
		 
	}

}
