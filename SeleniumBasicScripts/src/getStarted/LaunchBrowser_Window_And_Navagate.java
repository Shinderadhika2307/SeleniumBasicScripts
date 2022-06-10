package getStarted;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LaunchBrowser_Window_And_Navagate {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
System.setProperty("webdriver.chrome.driver", "F:\\Selenium Drivers\\chromedriver_win32\\chromedriver.exe");
	WebDriver driver=new ChromeDriver(); //upcasting
	Thread.sleep(2000);
	driver.get("https://www.zomato.com/");
	Thread.sleep(2000);
	driver.navigate().refresh();
	Thread.sleep(2000);
	driver.navigate().to("https://www.swiggy.com/");
	Thread.sleep(2000);
	driver.navigate().back();
	Thread.sleep(2000);
	driver.navigate().forward();
	Thread.sleep(2000);
	driver.get("https://www.jio.com/");
	driver.manage().window().maximize();
	Thread.sleep(2000);
	driver.manage().window().minimize();
	Thread.sleep(2000);
	Dimension d=new Dimension(1000,1000);
	driver.manage().window().setSize(d);
	
	System.out.println(driver.manage().window().getSize());//it will match size of our screen
	
	//driver.close(); //stop current browser
	//driver.quit();//stop all browser
	}

}
