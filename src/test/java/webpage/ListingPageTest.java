package webpage;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import resources.Base;

public class ListingPageTest extends Base {
	
	@Test
	public void Dresses() throws IOException {
		
		driver = initializeDriver();
		Actions actions = new Actions(driver);
		driver.get("http://automationpractice.com/index.php");
		driver.manage().window().maximize();
		// Locating the menu
		WebElement menu = driver.findElement(By.cssSelector("a[title='Women']"));
		actions.moveToElement(menu);
		driver.findElement(By.cssSelector("a[title='Women']")).click();
		actions.click().build().perform();
	}

}
