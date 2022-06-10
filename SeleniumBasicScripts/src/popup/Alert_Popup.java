package popup;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;



public class Alert_Popup {

			public static void main(String[] args) throws InterruptedException {
			System.setProperty("webdriver.chrome.driver", "F:\\Selenium Drivers\\chromedriver_win32\\chromedriver.exe");
			WebDriver driver=new ChromeDriver(); //upcasting
		
			driver.manage().window().maximize();
			driver.get("https://demoqa.com/alerts");
			
			driver.findElement(By.id("alertButton")).click();
			Alert alt=driver.switchTo().alert();
			Thread.sleep(3000);
			alt.accept(); //Click on Ok buton
			Thread.sleep(3000);	
			
  			driver.findElement(By.id("confirmButton")).click();
			Thread.sleep(3000);
			Alert alt2=driver.switchTo().alert();
			Thread.sleep(3000);
			alt.dismiss();
			
			driver.findElement(By.id("promtButton")).click();
			Thread.sleep(3000);
			Alert alt1=driver.switchTo().alert();
			Thread.sleep(3000);
			System.out.println(alt1.getText());
			Thread.sleep(000);
			alt.sendKeys("Why this alert");
			Thread.sleep(3000);
			alt.accept();
			Thread.sleep(3000);
			
	}

}
