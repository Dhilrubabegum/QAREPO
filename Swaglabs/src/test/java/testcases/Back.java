package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Back {
	public WebDriver driver;

	@BeforeMethod

	public void Login() {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\dbegum01\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();

	}

	@Test

	public void Tc_SL_027() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.id("item_4_img_link")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("back-to-products")).click();
		Thread.sleep(2000);
	}

	@AfterMethod
	public void quit() {
		driver.quit();
	}
}
