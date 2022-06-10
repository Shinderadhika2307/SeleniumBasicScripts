package ListboxDropdown;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ListCatagory_flipkart {
	
	public static void main(String[]args) throws InterruptedException
	{
		int a=10; //for git made changes
		System.setProperty("webdriver.chrome.driver", "F:\\Selenium Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		
		//close login window first
				driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
				Thread.sleep(2000);
			List<WebElement> elements=driver.findElements(By.xpath("//div[@class='_37M3Pb']/div"));
		
			for(WebElement i:elements)
			{
				System.out.println(i.getText());
			}
				
	}

}
