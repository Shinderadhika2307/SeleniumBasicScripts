package Practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class redbus_demo {

	public static void main(String[] args) {
		System.setProperty("webdriver.edge.driver", "F:\\Selenium Drivers\\edgedriver_win64\\msedgedriver.exe");
		WebDriver driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://redbus.com/");
		driver.findElement(By.xpath("//button[text()='Accept All']")).click();
		
		List <WebElement> list=driver.findElements(By.xpath("//div[@class='fr rdc-corner-wrapper']/div"));
		System.out.println(list.size());
		
		for(WebElement i: list)
		{
			System.out.println(i.getText());
		}

	}

}
