package takeScreenshot;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;
public class TakeSreenshot_And_Date {
	public static void main(String[] args) throws IOException, InterruptedException{
		System.setProperty("webdriver.chrome.driver", "F:\\Selenium Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://courses.letskodeit.com/practice");
		WebElement ss=driver.findElement(By.xpath("//select[@id='carselect']"));
		Select s=new Select(ss);
		s.selectByIndex(1);
	      Thread.sleep(2000);
	      screenshot(driver);
 	      s.selectByValue("honda");
	      Thread.sleep(2000);
	      screenshot(driver);
  	      s.selectByVisibleText("BMW");
	      Thread.sleep(2000);
	      screenshot(driver);
	}
	public static void screenshot(WebDriver driver) throws IOException
	{
		SimpleDateFormat f=new SimpleDateFormat("YYYY-MM-dd-hh-mm-ss");
		String currentdate=f.format(new Date());
		//System.out.println(currentdate);
		
		File source=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File Dest=new File("F:\\Selenium Screenshot\\image"+currentdate+".jpg");
		FileHandler.copy(source, Dest);
	}
}
