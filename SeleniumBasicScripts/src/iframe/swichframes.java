package iframe;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class swichframes {
	public static void main(String[]args) throws InterruptedException
	{
			System.setProperty("webdriver.chrome.driver", "F:\\Selenium Drivers\\chromedriver_win32//chromedriver.exe");
			WebDriver driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://demoqa.com/nestedframes");
			
			//switch to parent frame from main frame	
			driver.switchTo().frame("frame1");
			Thread.sleep(1000);
			WebElement element1=driver.findElement(By.xpath("//body[text()='Parent frame']"));
			System.out.println(element1.getText());
				//switch to child frame from parent frame
			driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@srcdoc,'Child Iframe')]")));
			WebElement element2=driver.findElement(By.xpath("//p[text()='Child Iframe']"));
			System.out.println(element2.getText());
			
			//switch to parent frame from, child frame
			driver.switchTo().parentFrame();
			WebElement element3=driver.findElement(By.xpath("//body[text()='Parent frame']"));
			System.out.println(element3.getText());
			
			//move to main frame from parent frame
			driver.switchTo().parentFrame();
			WebElement element4=driver.findElement(By.xpath("//div[@id='framesWrapper']"));
			System.out.println(element4.getText());
			
			//or
			driver.switchTo().defaultContent(); //move to main frame from any frame
			WebElement element5=driver.findElement(By.xpath("//div[@id='framesWrapper']"));
			System.out.println(element5.getText());
						refreshPage(driver);
			WebElement element6=driver.findElement(By.xpath("//p[text()='Child Iframe']"));
			System.out.println(element6.getText());
				}
	public static void refreshPage(WebDriver driver)
	{//after refresh frame automatically switch to main frame so to avoid this use method
		driver.navigate().refresh();
		driver.switchTo().frame("frame1");
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@srcdoc,'Child Iframe')]")));
	}
}
