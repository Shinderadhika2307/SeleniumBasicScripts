package Data_Driven_Framework;

import java.io.File;
import java.awt.RenderingHints.Key;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.time.Duration;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SendToExcel {

		public static void main(String[] args) throws Exception {
			System.setProperty("webdriver.chrome.driver", "F:\\Selenium Drivers\\chromedriver_win32\\chromedriver.exe");
			WebDriver driver= new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://www.flipkart.com/");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
		   login(driver);
		
			WebElement searchbox=waitForLoad(driver,"//input[@title='Search for products, brands and more']");
			File exelfile=new File("C:\\Users\\admin\\Desktop\\datadrivenexcel\\Excel_ForDataDriven.xlsx");
		
			FileInputStream file=new FileInputStream(exelfile);//excel path
			Workbook wbook =WorkbookFactory.create(file);
			Sheet sheet=wbook.getSheet("Sheet1");
						
			for(int i=0;i<4;i++)
			{
				//reading value from cell
				String data="";
				try
				{
			data=sheet.getRow(i).getCell(0).getStringCellValue();
				}
				catch(Exception e)
				{
					data=String.valueOf(sheet.getRow(i).getCell(0).getNumericCellValue());
					}
				searchbox.sendKeys(data);
			driver.findElement(By.xpath("//button[@type='submit']")).submit();
			Thread.sleep(5000);
			WebElement price;
			try
			{
				price=driver.findElement(By.xpath("//div[@class='_30jeq3 _1_WHN1']"));
				//price=waitForLoad(driver,"//div[@class='_30jeq3 _1_WHN1']");
			}
			catch(Exception e)
			{////div[@class='_30jeq3']
				price=driver.findElement(By.xpath("//div[@class='_30jeq3']"));
				//price=waitForLoad(driver,"//div[@class='_30jeq3']");
			}
			System.out.println(price.getText());
			//sheet.getRow
			//write in row .
			sheet.getRow(i).createCell(2).setCellValue(price.getText());
			for(int c=0;c<data.length();c++)
			{
				searchbox.sendKeys(Keys.BACK_SPACE);
			}
			}
			file.close();
			FileOutputStream file2=new FileOutputStream(exelfile);
			wbook.write(file2);
	}
		public static WebElement waitForLoad(WebDriver driver, String abc)
		{
			WebElement element = null;
			try {
			System.out.println("In wait method");
			WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
			 element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(abc)));
			}catch (Exception e)
			{e.printStackTrace();}
			return element;
		}
		static void login(WebDriver driver) throws Exception
		{
				
			driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("7020614851");
			driver.findElement(By.xpath("//input[@type='password']")).sendKeys("312687");
			driver.findElement(By.xpath("(//span[text()= 'Login' ])[2]")).submit();
			
			Thread.sleep(4000);
			
		}

}
