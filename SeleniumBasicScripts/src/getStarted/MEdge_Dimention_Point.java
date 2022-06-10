/*Test Case
open browser
open website
enter username
enter password
click on login button
capture title of home page
verify title with expected title
close browser
*/
package getStarted;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class MEdge_Dimention_Point {

	public static void main(String[] args) {
	//1.	Open Browser
		//for chrome
		//System.setProperty("webdriver.chrome.driver","F:\\Selenium Drivers\\chromedriver_win32\\chromedriver.exe");
		//WebDriver driver=new ChromeDriver();
		
		//for microsoft edge driver
		System.setProperty("webdriver.edge.driver","F:\\Selenium Drivers\\edgedriver_win64\\msedgedriver.exe");
		WebDriver driver=new EdgeDriver();
	//2. open website	
		driver.get("https://opensource-demo.orangehrmlive.com/");
	//3. enter username
		
	WebElement Username=driver.findElement(By.name("txtUsername"));
Username.sendKeys("Admin");
//or
//4.Enter Password
driver.findElement(By.id("txtPassword")).sendKeys("admin123"); 

driver.findElement(By.name("Submit")).click();
	String Exp_Title="OrangeHRM";
	String Act_title=driver.getTitle();
	System.out.println(Act_title);
	if(Exp_Title.equalsIgnoreCase(Act_title))
	{
		System.out.println("Test Case Pass");
	}
	else
	{
		System.out.println("Test Case fail");
	}
	
	Dimension d=new Dimension(800,600);
	driver.manage().window().setSize(d);
	System.out.println(driver.manage().window().getSize());
	
	Point p=new Point(40,40);
	driver.manage().window().setPosition(p);
	System.out.println(driver.manage().window().getPosition());
	driver.close(); //close current tab
	//driver.quit(); //close multiple tabs,multiple browser
}
}
