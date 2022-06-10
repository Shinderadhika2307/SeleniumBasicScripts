package popup;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class ChildWindowHandlePractice {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","F:\\Selenium Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://demo.automationtesting.in/Windows.html");
		
		String address=driver.getWindowHandle();
		System.out.println(address);
		driver.switchTo().window(address);
		System.out.println(driver.getTitle());
		
		driver.findElement(By.xpath("//button[text()='    click   ']")).click();
		Set<String> adresses=driver.getWindowHandles();
		for(String s:adresses)
		{
			String title=driver.switchTo().window(s).getTitle();
//			if(title.equals("Frames & windows"))
//			{
//				driver.close();
//			}
			
			//or
			if(title.equals("Selenium") )
			{
				driver.findElement(By.xpath("//span[text()='Projects']")).click();
			}
			
		
		}	

	}

}
