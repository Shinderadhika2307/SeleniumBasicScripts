package WebTableAndTablePagination;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TablePagination {
public static void main(String[] args)
{
	System.setProperty("webdriver.chrome.driver", "F:\\Selenium Drivers\\chromedriver_win32\\chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("https://demo.seleniumeasy.com/table-pagination-demo.html");
	
	WebElement element=driver.findElement(By.id("myPager"));
	List<WebElement> sub_links=element.findElements(By.tagName("a"));
    int totalLinks=sub_links.size();
    System.out.println("total no of links are:"+totalLinks);
   // System.out.println("Col1"+" "+"Col2"+" "+"Col3"+" "+"Col4"+" "+"Col5"+" "+"Col6"+" "+"Col7");
    if(totalLinks>0)
    {
    	System.out.println("Links are present");
    
    	for(int i=1;i<totalLinks-1;i++)//switching to page links
    {
    		driver.findElement(By.xpath("//a[contains(text(),'"+i+"')]")).click();
    		
    		int rows=driver.findElements(By.xpath("/html/body//table/tbody/tr")).size();
    	int cols=driver.findElements(By.xpath("/html/body//table/thead/tr/th")).size();
    		for(int r=1;r<=rows;r++)
    		{
    			for(int c=1;c<=cols;c++)
    			{
    				String data=driver.findElement(By.xpath("/html/body//table/tbody/tr["+r+"]/td["+c+"]")).getText();
    				System.out.print(data);
    				
    			}
    			System.out.println();
    		}
    	
    }
    }
    else
    {
    	System.out.println("Link Not Present");
    }

}
}