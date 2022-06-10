package DatePicker;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CurrentFuturePastDatePicker{

	public static WebDriver driver;
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "F:\\Selenium Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.redbus.com/");
		
		driver.manage().window().maximize();
		
		//String year="2018";
		String month="June";
		String date="25";
		
		driver.findElement(By.xpath("//button[text()='Accept All']")).click();
		driver.findElement(By.id("onward_cal")).click();
		
		selectCurrentDate(driver);
		//selectFutureDate(date,month);
		//selectPastDate(date,month);
	}

	
	static void selectCurrentDate(WebDriver driver)
	{
		Calendar cal=Calendar.getInstance();
		
		int d=cal.get(Calendar.DATE); // return the current date in int format
		String date=String.valueOf(d); //convert int to string
		System.out.println(date);
		//driver.findElement(By.linkText(date)).click();
	driver.findElement(By.xpath("//span[text()='"+date+"']")).click();
	}
	
	
	static void selectFutureDate(String d,String m)
	{
		
		Calendar cal=Calendar.getInstance();
		
		int currentmonth=cal.get(Calendar.MONTH)+1; // return the current date in int format
		
		for(int i=currentmonth;i>=1;i++)
		{
			
			driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/a[2]/span")).click();//Next arrow
			
			String mon=driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/span")).getText();
			
			if(mon.equals(m))
			{
				driver.findElement(By.linkText(d)).click();
				break;
			}
		}
	}
	
	
	static void selectPastDate(String d,String m)
	{
		
		Calendar cal=Calendar.getInstance();
		
		int currentmonth=cal.get(Calendar.MONTH)+1; // return the current date in int format
		
		for(int i=currentmonth;i>=1;i--)
		{
			
			driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/a[1]/span")).click();//Prev arrow
			
			String mon=driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/span")).getText();
			
			if(mon.equals(m))
			{
				driver.findElement(By.linkText(d)).click();
				break;
			}
		}
		
	}
	
}






