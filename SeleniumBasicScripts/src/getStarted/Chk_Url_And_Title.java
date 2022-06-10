package getStarted;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Chk_Url_And_Title {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "F:\\Selenium Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver(); //upcasting
		Thread.sleep(2000);
		driver.get("https://www.zomato.com/");
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		String ExpectedUrl="https://www.zomato.com/";
		String ExpectedTitle="Zomato";
		if(driver.getCurrentUrl().equals(ExpectedUrl))
		{
			System.out.println("Test Case Pass");
		}
		else
		{
			System.out.println("Test Case Fail");
		}
		
		if(driver.getTitle().equals(ExpectedTitle))
		{
			System.out.println("Pass");
		}
		else
		{
			System.out.println("Fail");
		}
		Point p=new Point(50,50);
		driver.manage().window().setPosition(p);
		
	System.out.println(driver.getPageSource());
	}
	
}
