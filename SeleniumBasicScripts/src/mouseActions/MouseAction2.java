package mouseActions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseAction2 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "F:\\Selenium Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/test/simple_context_menu.html");
		
		//rightClick
		Actions act=new Actions(driver);
		WebElement rightclick=driver.findElement(By.xpath("//span[text()='right click me']"));
		act.contextClick(rightclick).perform();
		
		//doubleclick
		Thread.sleep(2000);
		WebElement doubleclick=driver.findElement(By.xpath("//button[text()='Double-Click Me To See Alert']"));
		act.doubleClick(doubleclick).perform();
	}
	

}
