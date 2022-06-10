package flipkart_project;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login_SearchItem_SelectItem_AddToCart_RemoveFromCart {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "F:\\Selenium Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("7020614851");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("312687");
		driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
		
		// ElementClickInturruptEdexception solution by javascriptExecutor
		 driver.findElement(By.xpath("//input[@title='Search for products, brands and more']")).sendKeys("realme");
		WebElement element1= driver.findElement(By.xpath("//button[@type='submit']"));
		 JavascriptExecutor js=(JavascriptExecutor)driver; //used because ElementClickInturruptEdexception occure
		 js.executeScript("arguments[0].click()", element1);
		 
		// staleElementReferenceException solution explicite Waits
       WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='_1fQZEK']"))).click();
        
        Set<String> address=driver.getWindowHandles();
      
        List< String> addresslist=new ArrayList(address);
        driver.switchTo().window(addresslist.get(1));
         	driver.findElement(By.xpath("//button[@class='_2KpZ6l _2U9uOA _3v1-ww']")).click();
         	
       WebElement e=driver.findElement(By.xpath("//div[@class='_35mLK5']"));
       System.out.println(e.getText());   
       
       js.executeScript("arguments[0].click()", driver.findElement(By.xpath("(//button[@class='_23FHuj'])[2]")));
       js.executeScript("arguments[0].click()", driver.findElement(By.xpath("(//button[@class='_23FHuj'])[1]")));
       js.executeScript("arguments[0].click()", driver.findElement(By.xpath("//div[text()='Remove']")));
       js.executeScript("arguments[0].click()", driver.findElement(By.xpath("(//div[text()='Remove'])[1]")));
       
           	}

}
