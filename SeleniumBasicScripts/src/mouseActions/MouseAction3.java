package mouseActions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseAction3 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "F:\\Selenium Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.globalsqa.com/demo-site/draganddrop/");
		//Drag and drop action
		
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame lazyloaded'] ")));
		Thread.sleep(2000);
		Actions act=new Actions(driver);
		WebElement drag=driver.findElement(By.xpath(" //img[@alt='The peaks of High Tatras']"));
		WebElement drop=driver.findElement(By.xpath("//div[@id='trash']"));
		act.dragAndDrop(drag, drop).perform();
		Thread.sleep(2000);
		
		WebElement nextdrag=driver.findElement(By.xpath("//img[@alt='The chalet at the Green mountain lake']"));
		act.moveToElement(nextdrag).clickAndHold().moveToElement(drop).release().build().perform();  //perfom same operation
		//dragAndDrop()
		//moveToElement()
		//clickAndHold()
		//release()
		//build()
		//perform()
		//click()
		//contextClick()
		//doubleClick()
		
			
	}

}
