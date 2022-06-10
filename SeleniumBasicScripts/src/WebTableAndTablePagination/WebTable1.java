package WebTableAndTablePagination;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTable1 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "F:\\Selenium Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///F:/Webtable.html");
		
    int rows=driver.findElements(By.xpath("/html/body/table/tbody/tr")).size();
    System.out.println("no of rows:"+rows);
    int cols= driver.findElements(By.xpath("/html/body/table/tbody/tr[1]/th")).size();
    System.out.println("no of Colus:"+cols);
    System.out.println("name"+" "+"Adress"+" "+"Contact"); 
    System.out.println("========================");
    for(int r=2;r<=rows;r++)
    {
    	for(int c=1;c<=cols;c++)
    	{
    		String data=driver.findElement(By.xpath("/html/body/table/tbody/tr["+r+"]/td["+c+"]")).getText();
            System.out.print(data+" ");
    	}
    	System.out.println();
    }
    
	}

}
