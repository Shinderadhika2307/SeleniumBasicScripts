package ListboxDropdown;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
public class Listbox_demo {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.edge.driver", "F:\\Selenium Drivers\\edgedriver_win64\\msedgedriver.exe");
		WebDriver driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://courses.letskodeit.com/practice");
		
      WebElement listbox=driver.findElement(By.xpath("//select[@id='carselect']"));
      //create object of Select class and pass webelement object reffernce
      Select s=new Select(listbox);
      //how many option present in listbox
      System.out.println(s.getOptions().size()); //3
      //Different method to select options
      s.selectByIndex(1);
      Thread.sleep(2000);
      
      s.selectByValue("honda");
      Thread.sleep(2000);
      
      s.selectByVisibleText("BMW");
      Thread.sleep(2000);
      
      //to get selected option
      System.out.println(s.getFirstSelectedOption().getText());//BMW
      
      s.selectByValue("honda");
      Thread.sleep(2000);
      System.out.println(s.getFirstSelectedOption().getText());//Honda
      //to get all options first convert into list
     
      List <WebElement> options=s.getOptions();
    //  for(int i=0;i<options.size();i++)
    //  {
    	  //System.out.println(options.get(i).getText());//BMW, Benz Honda //i.getText();
    	  
    //  }
      for(WebElement i: options)
      {
    	  System.out.println(i.getText());
      }
	}

}
