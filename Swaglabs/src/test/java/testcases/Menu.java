package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Menu {
	public WebDriver driver;

	@BeforeMethod
	public void Login() {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\dbegum01\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
		driver.findElement(By.id("user-name")).sendKeys("standard_user");		// Tc_SL_003
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();

	}

	@Test
	public void Tc_SL_010() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.id("react-burger-menu-btn")).click();

	}

	@Test
	public void Tc_SL_011() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.id("react-burger-menu-btn")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("react-burger-cross-btn")).click();
		Thread.sleep(2000);
	}

	@Test
	public void Tc_SL_012() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.id("react-burger-menu-btn")).click();
		Thread.sleep(1000);
		Actions act = new Actions(driver);
		WebElement menu = driver.findElement(By.id("about_sidebar_link"));
		act.moveToElement(menu).build().perform();
		Thread.sleep(3000);
	}

	@Test
	public void Tc_SL_013() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.id("react-burger-menu-btn")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("inventory_sidebar_link")).click();
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
	}

	@Test
	public void Tc_SL_014() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.id("react-burger-menu-btn")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("about_sidebar_link")).click();
		Assert.assertEquals(driver.getCurrentUrl(), "https://saucelabs.com/");
	}

	@Test
	public void Tc_SL_015() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.id("react-burger-menu-btn")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("logout_sidebar_link")).click();
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/");
	}

	@Test
	public void Tc_SL_017() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.id("react-burger-menu-btn")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("reset_sidebar_link")).click();
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
	}

	@AfterMethod
	public void quit() {
		driver.quit();
	}

}
