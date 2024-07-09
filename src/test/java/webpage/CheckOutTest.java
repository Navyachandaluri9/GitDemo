package webpage;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import resources.Base;

public class CheckOutTest extends Base {

	@BeforeTest
	public void addToCart() throws IOException {

		driver = initializeDriver();
		driver.get("http://automationpractice.com/index.php");
		driver.manage().window().maximize();
		driver.findElement(By.linkText("Sign in")).click();

		// create Account
		WebElement create = driver.findElement(By.id("email_create"));
		create.sendKeys("veny09@gmail.com");
		create.click();
		driver.findElement(By.id("SubmitCreate")).click();

		// personal information filling
		driver.findElement(By.xpath("//input[@id=\"id_gender2\"]")).click();
		driver.findElement(By.id("customer_firstname")).sendKeys("Test User");
		driver.findElement(By.name("customer_lastname")).sendKeys("Tested");
		driver.findElement(By.id("passwd")).sendKeys("qwerty");

		// Date of birth dropdown testing
		WebElement dobn = driver.findElement(By.id("days"));
		dobn.click();
		Select number = new Select(dobn);
		number.selectByValue("4");
		WebElement dobm = driver.findElement(By.id("months"));
		dobm.click();
		Select month = new Select(dobm);
		month.selectByValue("6");
		WebElement doby = driver.findElement(By.id("years"));
		doby.click();
		Select year = new Select(doby);
		year.selectByValue("1993");

		// Enter your address
		driver.findElement(By.id("company")).sendKeys("qwerty");
		driver.findElement(By.id("address1")).sendKeys("qwerty,14/A,Road 6");
		driver.findElement(By.id("address2")).sendKeys("Haze");
		driver.findElement(By.id("city")).sendKeys("DEF");

		// Select state dropdown
		WebElement statedropdown = driver.findElement(By.id("id_state"));
		Select state = new Select(statedropdown);
		state.selectByValue("5");
		driver.findElement(By.name("postcode")).sendKeys("51840");

		// Select Country driver.findElement(By.id("uniform-id_country")).click();
		WebElement countrydropdown = driver.findElement(By.id("id_country"));
		Select country = new Select(countrydropdown);
		country.selectByValue("21");
		countrydropdown.click(); // Enter Mobile Number
		driver.findElement(By.id("other")).sendKeys("qwertyuiopasdfghj");
		driver.findElement(By.id("phone")).sendKeys("123456789");
		driver.findElement(By.id("phone_mobile")).sendKeys("234523456");
		driver.findElement(By.xpath("//input[@name=\"alias\"]")).clear();
		driver.findElement(By.xpath("//input[@name=\"alias\"]")).sendKeys("Office");
		driver.findElement(By.name("submitAccount")).click();
		String userText = driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")).getText();

		// Validate that user has created
		if (userText.contains("qwerty")) {
			System.out.println("Test case Passed");
		} else {
			System.out.println("Test case Failed");
		}
	}

	@Test
	public void EcomExpert() throws IOException {

		driver = initializeDriver();
		prop.getProperty("url");
		// Click on Sign in
		driver.findElement(By.linkText("Sign in")).click();
		// Login
		driver.findElement(By.id("email")).sendKeys("veny09@gmail.com");
		driver.findElement(By.id("passwd")).sendKeys("qwerty");
		driver.findElement(By.id("SubmitLogin")).click();
		// Click on Women
		driver.findElement(By.linkText("WOMEN")).click();

		WebElement SecondImg = driver
				.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[3]/div[2]/ul/li[2]/div/div[1]/div/a[1]/img"));
		WebElement MoreBtn = driver.findElement(
				By.xpath("/html/body[1]/div[1]/div[2]/div[1]/div[3]/div[2]/ul/li[2]/div[1]/div[2]/div[2]/a[2]"));
		Actions actions = new Actions(driver);
		actions.moveToElement(SecondImg).moveToElement(MoreBtn).click().perform();

		// Change quantity by 2
		driver.findElement(By.id("quantity_wanted")).clear();
		driver.findElement(By.id("quantity_wanted")).sendKeys("2");

		// Select size as L
		WebElement Sizedrpdwn = driver.findElement(By.xpath("//*[@id='group_1']"));
		Select oSelect = new Select(Sizedrpdwn);
		oSelect.selectByVisibleText("M");

		// Select Color
		driver.findElement(By.id("color_11")).click();

		// Click on add to cart
		driver.findElement(By.xpath("//p[@id='add_to_cart']//span[.='Add to cart']")).click();

		// Click on proceed
		driver.findElement(By.xpath("/html//div[@id='layer_cart']//a[@title='Proceed to checkout']/span")).click();
		// Checkout page Proceed
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[3]/div/p[2]/a[1]/span")).click();
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[3]/div/form/p/button/span")).click();
		// Agree terms&Conditions
		driver.findElement(By.xpath("//*[@id=\"cgv\"]")).click();
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[3]/div/div/form/p/button/span")).click();

		// Click on Payby Check
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[3]/div/div/div[3]/div[2]/div/p/a")).click();
		// Confirm the order
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[3]/div/form/p/button/span")).click();

		// Get Text
		String ConfirmationText = driver
				.findElement(By.xpath("//div[@id='center_column']/p[@class='alert alert-success']")).getText();

		// Verify that Product is ordered
		if (ConfirmationText.contains("complete")) {
			System.out.println("Order Completed: Test Case Passed");
		} else {
			System.out.println("Order Not Successfull: Test Case Failed");
		}

	}
}
