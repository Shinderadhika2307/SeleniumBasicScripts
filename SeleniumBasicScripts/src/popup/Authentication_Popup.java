package popup;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Authentication_Popup {

			public static void main(String[] args) throws InterruptedException {
			System.setProperty("webdriver.chrome.driver", "F:\\Selenium Drivers\\chromedriver_win32\\chromedriver.exe");
			WebDriver driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://www.redbus.com/");
			driver.findElement(By.xpath("//button[text()='Accept All']")).click();
			Thread.sleep(5000);
			
			driver.findElement(By.xpath("//div[text()='Login']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//li[@id='signInLink']")).click();
			Thread.sleep(2000);
			driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='modalIframe']")));
			Thread.sleep(2000);
			driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@id,'gsi_')]")));
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//span[text()='Sign in with Google'])[1]")).click();
			Set <String> addresses=driver.getWindowHandles();
			for(String s: addresses)
			{
				driver.switchTo().window(s);
				try {
					driver.findElement(By.xpath("//input[@id='identifierId']")).sendKeys("shinderadhika2307@gmail.com");
					driver.findElement(By.xpath("//span[text()='Next']")).click();
				}
				catch(Exception e)
				{
					
				}
			}
				
			

}
}