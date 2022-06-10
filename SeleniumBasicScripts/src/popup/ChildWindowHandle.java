package popup;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChildWindowHandle {
	public static void main(String[]args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "F:\\Selenium Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		
		driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("7020614851");
		Thread.sleep(2000);
		 driver.findElement(By.xpath("//input[@type='password']")).sendKeys("312687");
		Thread.sleep(2000);
		 driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
		 Thread.sleep(2000);
		 
		//getWindowHandle()
		 String address=driver.getWindowHandle(); //imp
		 System.out.println(address); //CDwindow-593FDD2BE9931A6D8F353598F01A0142
         driver.switchTo().window(address);
         System.out.println(driver.getTitle());
         Thread.sleep(2000);
	   
		 driver.findElement(By.xpath("//input[@title='Search for products, brands and more']")).sendKeys("realme");
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//button[@type='submit']")).click();
		 Thread.sleep(2000);
		 
		 List<WebElement> realmelist=driver.findElements(By.xpath("//a[@class='_1fQZEK']"));
		 for(int i=0;i<3;i++)
		 {
			 Thread.sleep(2000);
			 realmelist.get(i).click();
		 }
		 
		 Set<String> adresses=driver.getWindowHandles(); //imp
		 for(String s: adresses)
		 {
			 System.out.println(s);
		 }
		 
//		 for(String s: adresses) //action on all window
//		 {
//			 Thread.sleep(3000);
//			 driver.switchTo().window(s); //main window included
		 //	 try { 
//			 driver.findElement(By.xpath("//button[@class='_2KpZ6l _2U9uOA _3v1-ww']")).click();
//			 }
//			 catch(Exception e)
//			 {
//				 
//			 }
//		 }	 
		 //converting set to list to peform action on perticular window
		 ArrayList <String> setToList=new ArrayList(adresses);
		 Thread.sleep(3000);
		driver.switchTo().window(setToList.get(3));
		 Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2U9uOA ihZ75k _3AWRsL']")).click();
	}

}
