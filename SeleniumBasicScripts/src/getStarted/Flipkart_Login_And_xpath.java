/*Test Case
open browser
open website
enter username
enter password
click on signin
capture title of home page
verify title with expected title
close browser
*/
package getStarted;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Flipkart_Login_And_xpath {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "F:\\\\Selenium Drivers\\\\chromedriver_win32\\\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/?ef_id=db1922f8b9e31ec944c6409044598dea:G:s&s_kwcid=AL!739!10!75797718224771!75797848465866&semcmpid=sem_F1167BY7_Brand_adcenter");
	Thread.sleep(3000);
		WebElement EmailOrPhone=driver.findElement(By.xpath("(//input[@type='text'])[2]"));  //by attribute and by index
	 EmailOrPhone.sendKeys("7020614851");
	 Thread.sleep(3000);
	 
	 
	 WebElement ActualPass=driver.findElement(By.xpath("//input[@type='password']"));//xpath by attribute
	 ActualPass.sendKeys("312687");
	 Thread.sleep(3000);
	 
	//  EmailOrPhone.clear(); clear input field clear()
	 
	 WebElement LoginButton=driver.findElement(By.xpath("(//button[@type='submit'])[2]")); //by attribute and by index
	 System.out.println(LoginButton.getText());  //getText()
	 WebElement checkGetText=driver.findElement(By.xpath("//div[@class='_36HLxm col col-3-5']"));
	 System.out.println(checkGetText.getText());
	 
	 LoginButton.click();
	 Thread.sleep(3000);	
	 try
	 {
		WebElement logincheck=driver.findElement(By.xpath("//a[text()='New to Flipkart? Create an account')]"));
	 }
	 
	 catch(NoSuchElementException e)
	 {
		 System.out.println("You are logged in successfully");
	 } 
	 WebElement RequestOTP=driver.findElement(By.xpath("//button[text()='Request OTP']")); //by text
	WebElement CreateAcc=driver.findElement(By.xpath("//a[contains(text(),'Create an account')]"));//By contains by text
	 WebElement LoginButton1=driver.findElement(By.xpath("(//button[contains(@type,'submit')])[2]"));//by contains by attribute
	 WebElement LoginInfo=driver.findElement((By.xpath("html/body/div[2]/div/div/div/div/div[1]/span/span"))); //Absolute xpath leangthy but faster
	 
	}

}
