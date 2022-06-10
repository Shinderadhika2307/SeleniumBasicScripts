package ScrollUpDownLeftRight;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class scroll {
	public static void main(String[]args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "F:\\\\Selenium Drivers\\\\chromedriver_win32\\\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		
		//close login window first
				driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
				Thread.sleep(2000);
				
	JavascriptExecutor js=(JavascriptExecutor)driver;
	
	//*********by using scrollby method**************
	//vertical scrolling
	js.executeScript("window.scrollBy(0,1000)"); //scroll down
	Thread.sleep(3000);
	js.executeScript("window.scrollBy(0,-500)");//scroll up
	
	//Horizontal Scrolling
	Dimension d=new Dimension(500,500);
	driver.manage().window().setSize(d);
		Thread.sleep(3000);
		js.executeScript("window.scrollBy(300,0)");
		Thread.sleep(3000);
				
		//*********by using argumements************
		driver.manage().window().maximize();
		js.executeScript("arguments[0].scrollIntoView(true)",driver.findElement(By.xpath("//h2[text()='Flipkart Plus']")) ); //imp
		Thread.sleep(3000);

		WebElement loginbtn=driver.findElement(By.xpath("//a[text()='Login']"));
		js.executeScript("arguments[0].click()", loginbtn);
		Thread.sleep(3000);
		
		WebElement mobile=driver.findElement(By.xpath("(//input[@type='text'])[2]"));
		js.executeScript("arguments[0].value='7020614851'",mobile);
		Thread.sleep(3000);
		
		WebElement pass=driver.findElement(By.xpath("//input[@type='password']"));
		js.executeScript("arguments[0].value='312687'", pass);
		Thread.sleep(3000);
		
		WebElement loginbtnclick=driver.findElement(By.xpath("(//button[@type='submit'])[2]"));
		js.executeScript("arguments[0].click()", loginbtnclick);
		Thread.sleep(3000);
		
		//input field ways 1.sendkeys() 2.action class sendkeys() 3.javascript
		//button click ways 1.click() 2.Javascript 3.action class click() method
		
		
	}

}
