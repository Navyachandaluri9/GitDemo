package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;

public class Base {
	public  WebDriver driver;
	public Properties prop;
	
@BeforeClass	
public WebDriver initializeDriver() throws IOException
{

 prop= new Properties();
FileInputStream fis=new FileInputStream("F:\\Selenium_Workspace_May_2022\\Shopping\\src\\main\\java\\resources\\data.properties");

prop.load(fis);
String browserName=prop.getProperty("browser");
System.out.println(browserName);
String urlName = (prop.getProperty("url"));
System.out.println(urlName);
//driver.get(urlName);

/*
 * String urlName =prop.getProperty("url"); System.out.println(urlName);
 * driver.get(urlName);
 */

if(browserName.equals("chrome"))
{
	 System.setProperty("webdriver.chrome.driver", "C:\\chrome\\chromedriver.exe");
	driver= new ChromeDriver();
		//execute in chrome driver
	
}
else if (browserName.equals("firefox"))
{
	 driver= new FirefoxDriver();
	//firefox code
}
else if (browserName.equals("IE"))
{
//	IE code
}

driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
return driver;


}

}
