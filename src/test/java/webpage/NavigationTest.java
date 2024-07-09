package webpage;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import resources.Base;

public class NavigationTest extends Base {

	@Test
	public void multiplePages() throws IOException {

		driver = initializeDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.get("http://automationpractice.com/index.php");
		driver.manage().window().maximize();
		// Navigate to multiple pages of the website
		// driver.findElement(By.linkText("Contact us")).click();
		driver.findElement(By.linkText("Sign in")).click();
		driver.navigate().back();
		// automate verification of header and footer

		// Automate Newsletter subscription scenarios
		js.executeScript("window.scrollBy(0,2500)");
		WebElement email = driver.findElement(By.cssSelector("button[name='submitNewsletter']"));
		email.click();
		email.sendKeys("navyachandaluri9@gmail.com");
		driver.findElement(By.name("//button[@name='submitNewsletter']")).click();

	}

}
