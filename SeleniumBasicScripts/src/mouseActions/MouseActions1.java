package mouseActions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class MouseActions1 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "F:\\Selenium Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.flipkart.com/");
		
		//close login window first
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
		
		Actions act=new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//div[@class='exehdJ']"))).perform(); //move to element
		Thread.sleep(2000);

		act.moveToElement(driver.findElement(By.xpath("//div[text()='24x7 Customer Care']"))).perform(); //move to element which is not visible
		Thread.sleep(2000);
		act.moveToElement(driver.findElement(By.xpath("//div[text()='24x7 Customer Care']"))).click().build().perform(); //move to element and click
		Thread.sleep(2000);

		
		

	}

}
