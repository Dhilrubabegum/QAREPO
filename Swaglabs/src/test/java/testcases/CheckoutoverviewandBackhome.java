package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckoutoverviewandBackhome {
	public WebDriver driver;

	@BeforeMethod

	public void Login() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\dbegum01\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
		driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("checkout")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("first-name")).sendKeys("xyz"); // Tc_SL_044
		driver.findElement(By.id("last-name")).sendKeys("abc");
		driver.findElement(By.id("postal-code")).sendKeys("12345");
		Thread.sleep(2000);
		driver.findElement(By.id("continue")).click();
		Thread.sleep(2000);

	}

	@Test
	public void Tc_SL_054() throws InterruptedException {

		driver.findElement(By.id("cancel")).click();
		WebElement title = driver.findElement(By.xpath("//span[@class='title']"));
		Assert.assertEquals(true, title.isDisplayed());
		System.out.println("Back to Products – Assert passed");

	}

	@Test
	public void Tc_SL_055() throws InterruptedException {
		driver.findElement(By.id("finish")).click();
		Thread.sleep(3000);
		WebElement Logo = driver.findElement(By.xpath("//h2[@class='complete-header']"));
		Assert.assertEquals(true, Logo.isDisplayed());
		System.out.println("Thankyou for Order – Assert passed");

	}

	@Test
	public void Tc_SL_056() throws InterruptedException {
		driver.findElement(By.id("finish")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("back-to-products")).click();
		WebElement title = driver.findElement(By.xpath("//span[@class='title']"));
		Assert.assertEquals(true, title.isDisplayed());
		System.out.println("Back to Products – Assert passed");

	}

	@AfterMethod
	public void quit() {
		driver.quit();
	}

}
