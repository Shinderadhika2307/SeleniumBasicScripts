package Data_Driven_Framework;


	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.support.ui.Select;

	public class UseXLUtils {

		public static void main(String[] args) throws Exception {
			
			System.setProperty("webdriver.chrome.driver","F:\\\\Selenium Drivers\\\\chromedriver_win32\\\\chromedriver.exe");
			WebDriver driver=new ChromeDriver();
			
			driver.get("https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india-sbi/fixed-deposit-calculator-SBI-BSB001.html");

			driver.manage().window().maximize();
			
			String path="C:\\Users\\admin\\Desktop\\datadrivenexcel\\testdata123.xlsx";
			
			XLUtils.setExcelFile(path, "data");
			
			int rowcount=XLUtils.getRowCount(path, "data");
			
			System.out.println(rowcount);
			for(int i=1;i<=rowcount;i++)
			{
				
				int princ=Integer.parseInt(XLUtils.getCellData(path, "data", i, 0));
				int rateofinterest= Integer.parseInt(XLUtils.getCellData(path,"data",i, 1));
				int per= Integer.parseInt(XLUtils.getCellData(path,"data",i, 2));
				String fre=XLUtils.getCellData(path, "data", i,3);
				double exp_mvalue=Double.parseDouble(XLUtils.getCellData(path,"data",i,4));
				
				driver.findElement(By.id("principal")).sendKeys(String.valueOf(princ));
				driver.findElement(By.id("interest")).sendKeys(String.valueOf(rateofinterest));
				driver.findElement(By.id("tenure")).sendKeys(String.valueOf(per));
				
				Select perioddrp=new Select(driver.findElement(By.id("tenurePeriod")));
				perioddrp.selectByVisibleText("year(s)");
				
				Select frequency=new Select(driver.findElement(By.id("frequency")));
				frequency.selectByVisibleText(fre);
				
				driver.findElement(By.xpath("//*[@id='fdMatVal']/div[2]/a[1]/img")).click();
				
				String act_mvalue=driver.findElement(By.xpath("//*[@id='resp_matval']/strong")).getText();
				
					XLUtils.setCellData(path,"data",i,5,act_mvalue);
					if(exp_mvalue==Double.parseDouble(act_mvalue))
					{
						XLUtils.setCellData(path,"data",i,6,"pass");
						System.out.println("test passed");
					}
					else
					{
						XLUtils.setCellData(path,"data",i,6,"fail");
						System.out.println("test failed");
					}
				
		
				
				driver.findElement(By.xpath("//*[@id='fdMatVal']/div[2]/a[2]/img")).click(); // clear button
				
				Thread.sleep(3000);
			}
			
		}

	}