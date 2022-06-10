package mouseActions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseAction4_dragddroplist {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "F:\\Selenium Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.globalsqa.com/demo-site/draganddrop/");
		
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame lazyloaded'] ")));
		Thread.sleep(2000);
		Actions act=new Actions(driver);
		
		WebElement drop=driver.findElement(By.id("trash"));
		
List<WebElement> draglist=driver.findElements(By.xpath("//ul[@id='gallery']/li"));
for(WebElement i:draglist)
{
	System.out.println(i.getText());
	act.dragAndDrop(i, drop).perform();
	Thread.sleep(3000);
}
	}

}
