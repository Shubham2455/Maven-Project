import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class testCases_Amezon {
	WebDriver driver;

	@BeforeSuite
	public void Before_test() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\shubh\\Desktop\\chrome driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	}

	@AfterTest
	public void After_test() {
		driver.close();
	}

	@Test(priority = 1)

	// Visiblity Of LoginBox

	public void test63() {
		WebElement loginBox = driver.findElement(By.xpath(
				"//a[@class='nav-a nav-a-2   nav-progressive-attribute']"));
		loginBox.click();
		WebElement text = driver
				.findElement(By.xpath("//h1[contains(text(),'Sign-In')]"));
		String expString = "Sign-In";
		String actString = text.getText();
		Assert.assertEquals(expString, actString);
	}

}
