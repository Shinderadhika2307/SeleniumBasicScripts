package WebElement_methods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class isEnable_demo {

	public static void main(String[] args) throws InterruptedException {
	System.setProperty("webdriver.chrome.driver", "F:\\Selenium Drivers\\chromedriver_win32\\chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://courses.letskodeit.com/practice");
	
	WebElement inputbox=driver.findElement(By.xpath("//input[@id='enabled-example-input']"));
	System.out.println(inputbox.isEnabled()); //true
	Thread.sleep(2000);
	driver.findElement(By.xpath("//input[@id='disabled-button']")).click();
	System.out.println(inputbox.isEnabled()); //false
	driver.findElement(By.xpath("//input[@id='enabled-button']")).click();
	System.out.println(inputbox.isEnabled());

	}

}
