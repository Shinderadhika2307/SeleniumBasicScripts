package WebElement_methods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class isDespayed_demo {

	public static void main(String[] args) throws InterruptedException {
	
System.setProperty("webdriver.chrome.driver", "F:\\Selenium Drivers\\chromedriver_win32\\chromedriver.exe");
WebDriver driver=new ChromeDriver();
driver.manage().window().maximize();
driver.get("https://courses.letskodeit.com/practice");


WebElement inputbox=driver.findElement(By.xpath("//input[@id='displayed-text']"));
System.out.println(inputbox.isDisplayed()); //true

//for hide
driver.findElement(By.xpath("//input[@id='hide-textbox']")).click();

System.out.println(inputbox.isDisplayed()); //false

//for show
Thread.sleep(2000);
driver.findElement(By.xpath("//input[@id='show-textbox']")).click();
System.out.println(inputbox.isDisplayed());  //true

	}

}
