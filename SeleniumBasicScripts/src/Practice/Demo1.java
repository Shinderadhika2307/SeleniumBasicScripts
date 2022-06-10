package Practice;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

public class Demo1 {

	public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty("webdriver.edge.driver", "F:\\Selenium Drivers\\edgedriver_win64\\msedgedriver.exe");
		WebDriver driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://goo.gl/RVdKM9");

		driver.findElement(By.xpath("//*[@id=\"RESULT_TextField-1\"]")).sendKeys("Mitali");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"RESULT_TextField-2\"]")).sendKeys("Shewale");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"RESULT_TextField-3\"]")).sendKeys("8976445685");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"RESULT_TextField-4\"]")).sendKeys("India");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"RESULT_TextField-5\"]")).sendKeys("Mumbai");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"RESULT_TextField-6\"]")).sendKeys("abc23@gmail.com");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"q26\"]/table/tbody/tr[2]/td/label")).click();
		driver.findElement(By.xpath("//*[@id=\"q15\"]/table/tbody/tr[1]/td/label")).click();
		driver.findElement(By.xpath("//*[@id=\"q15\"]/table/tbody/tr[7]/td/label")).click();
		
		WebElement selectTime=driver.findElement(By.xpath("//*[@id=\"RESULT_RadioButton-9\"]"));
		Select time=new Select(selectTime);
		
		int count=time.getOptions().size();
		System.out.println(count);
		List<WebElement> elements=time.getOptions();
		for(WebElement e: elements)
		{
			System.out.println(e.getText());
		}
		
		time.selectByIndex(2);
		System.out.println(time.getFirstSelectedOption().getText());
		
		driver.findElement(By.linkText("Software Testing Tutorials")).click();
		Thread.sleep(3000);
		driver.navigate().back();
		driver.findElement(By.partialLinkText("Software Testing")).click();
		Thread.sleep(3000);
		driver.navigate().back();
		Thread.sleep(2000);
		screenshotMethod(driver);
		driver.findElement(By.xpath("//*[@id=\"FSsubmit\"]")).click();
		driver.quit();
		
	}
	public static void screenshotMethod(WebDriver driver) throws IOException
	{
		SimpleDateFormat s=new SimpleDateFormat("YYYY-MM-dd-hh-mm-ss");
		String newdate=s.format(new Date());
		System.out.println(newdate);
		
		File source=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest=new File("F:\\Selenium Screenshot\\image"+newdate+".png");
		FileHandler.copy(source, dest);
		
		
		
	}

}
