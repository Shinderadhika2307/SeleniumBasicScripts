//check in 5th column how many time enable occure and how many time desable occure
package WebTableAndTablePagination;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTable2 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "F:\\Selenium Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		
		driver.findElement(By.xpath("//b[text()=\"Admin\"]")).click();
		driver.findElement(By.xpath("//a[text()='User Management']")).click();
		driver.findElement(By.id("menu_admin_viewSystemUsers")).click();
		
	int rows=driver.findElements(By.xpath("/html/body//table/tbody/tr")).size();
	System.out.println(rows);
	int count=0;
	for(int r=1;r<=rows;r++)
	{
	String status=driver.findElement(By.xpath("/html/body//table/tbody/tr["+r+"]/td[5]")).getText();
	if(status.equalsIgnoreCase("Enabled"))
	{
		count++;
	}
	}
	System.out.println("Enable occures "+count+" times");
	System.out.println("Desable occures "+(rows-count)+" times");

	}

}
