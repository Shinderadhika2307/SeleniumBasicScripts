package iframe;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class count_iframe {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "F:\\Selenium Drivers\\chromedriver_win32//chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/nestedframes");
		
		Thread.sleep(1000);
		List<WebElement> elements=driver.findElements(By.xpath("//iframe")); //not mandatory
       int count=driver.findElements(By.xpath("//iframe")).size();
       System.out.println("no of frames are: "+count);
		
	}

}
