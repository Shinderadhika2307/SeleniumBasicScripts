package WebElement_methods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class getAttribute_demo {

	public static void main(String[] args) {
		System.setProperty("webdriver.edge.driver", "F:\\Selenium Drivers\\edgedriver_win64\\msedgedriver.exe");
		WebDriver driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://courses.letskodeit.com/practice");
		
		WebElement textbox=driver.findElement(By.xpath("(//input[@id='name'])[1]"));
		System.out.println(textbox.getAttribute("name"));
		
		
		WebElement gettxt=driver.findElement((By.xpath("//h1[@data-uniqid='1621702280245']")));
		System.out.println(gettxt.getText());

	}

}
