package testcases;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TimeLogout {
	public WebDriver driver;

	@BeforeMethod
	
	public void Login() {

		System.setProperty("webdriver.chrome.driver","C:\\Users\\dbegum01\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		
	}
	@Test
	public void Tc_SL_057() throws InterruptedException {

	Thread.sleep((long) 600000d, 0);
	driver.findElement(By.id("item_4_img_link")).click();
	WebElement e=driver.findElement(By.xpath("//div[@class='error-message-container error']"));
	String error=e.getText();
	System.out.println(error);
	
	}
	@AfterMethod
	public void quit() {
		driver.quit();
	}
}

