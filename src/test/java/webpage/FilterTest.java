package webpage;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import resources.Base;

public class FilterTest extends Base{
	@Test
	public void Filtering() throws IOException {
		
		driver = initializeDriver();
		Actions actions = new Actions(driver);
		driver.get("http://automationpractice.com/index.php");
		driver.manage().window().maximize();
		WebElement menu = driver.findElement(By.cssSelector("a[title='Women']"));
		actions.moveToElement(menu);
		driver.findElement(By.cssSelector("a[title='Women']")).click();
		actions.click().build().perform();
		driver.findElement(By.xpath("//input[@id='layered_id_feature_3']")).click();
		
		
		
		
		
	}
	

}
