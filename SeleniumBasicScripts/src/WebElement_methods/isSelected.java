package WebElement_methods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
public class isSelected {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.edge.driver", "F:\\Selenium Drivers\\edgedriver_win64\\msedgedriver.exe");
		WebDriver driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://courses.letskodeit.com/practice");
		Thread.sleep(2000);
		//for radiobutton
		//isSelected() for bmw
		WebElement radiobtn1=driver.findElement(By.xpath("//input[@id='bmwradio']"));
		System.out.println(radiobtn1.isSelected()); // false
		Thread.sleep(2000);
		radiobtn1.click();
		System.out.println(radiobtn1.isSelected());
		Thread.sleep(2000);
		//isSelected() for benz
		WebElement radiobtn2=driver.findElement(By.xpath("//input[@id='benzradio']"));
		System.out.println(radiobtn2.isSelected());
		Thread.sleep(2000);
		radiobtn2.click();
		System.out.println(radiobtn2.isSelected());
		Thread.sleep(2000);
		//isSelected() for Honda
		WebElement radiobtn3=driver.findElement(By.xpath("//input[@id='hondaradio']"));
		System.out.println(radiobtn3.isSelected());
		Thread.sleep(2000);
		radiobtn3.click();
		System.out.println(radiobtn3.isSelected());
		Thread.sleep(2000);
        //for checkbox
		WebElement chk1=driver.findElement(By.xpath("//input[@id='bmwcheck']"));
		System.out.println(chk1.isSelected());//false
		chk1.click();
		System.out.println(chk1.isSelected());//true
		Thread.sleep(2000);
		
		WebElement chk2=driver.findElement(By.xpath("//input[@id='benzcheck']"));
		System.out.println(chk2.isSelected());
		chk2.click();
		System.out.println(chk2.isSelected());
		Thread.sleep(2000);
		
		WebElement chk3=driver.findElement(By.xpath("//input[@id='hondacheck']"));
		System.out.println(chk3.isSelected());
		chk3.click();
		System.out.println(chk3.isSelected());
		Thread.sleep(2000);
		
		//for radiobutton we need to check, we can select only one radiobutton or not
		//for checkbox we need to check we can select multiple checkbox or not
		

	}

}
