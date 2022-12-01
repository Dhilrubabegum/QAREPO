package testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Filter {
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
	public void Tc_SL_018() throws InterruptedException {
		driver.findElement(By.xpath("//select[@class='product_sort_container']")).click();
		Thread.sleep(2000);
		String Before=driver.findElement(By.xpath("(//div[@class='inventory_item_name'])[1]")).getText();
		driver.findElement(By.xpath("//option[@value='az']")).click();
		String After=driver.findElement(By.xpath("(//div[@class='inventory_item_name'])[1]")).getText();
		Assert.assertEquals(After, Before);
		
	}

	@Test
	public void Tc_SL_019() throws InterruptedException {
		driver.findElement(By.xpath("//select[@class='product_sort_container']")).click();
		Thread.sleep(2000);
		String Before=driver.findElement(By.xpath("(//div[@class='inventory_item_name'])[1]")).getText();
		driver.findElement(By.xpath("//option[@value='za']")).click();
		String After=driver.findElement(By.xpath("(//div[@class='inventory_item_name'])[1]")).getText();
		Assert.assertNotEquals(After, Before);
		
	}

	@Test
	public void Tc_SL_020() throws InterruptedException {
		driver.findElement(By.xpath("//select[@class='product_sort_container']")).click();
		Thread.sleep(2000);
		String Before=driver.findElement(By.xpath("(//div[@class='inventory_item_name'])[1]")).getText();
		driver.findElement(By.xpath("//option[@value='lohi']")).click();
		String After=driver.findElement(By.xpath("(//div[@class='inventory_item_name'])[1]")).getText();
		Assert.assertNotEquals(After, Before);
	}

	@Test
	public void Tc_SL_021() throws InterruptedException {
		driver.findElement(By.xpath("//select[@class='product_sort_container']")).click();
		Thread.sleep(2000);
		String Before=driver.findElement(By.xpath("(//div[@class='inventory_item_name'])[1]")).getText();
		driver.findElement(By.xpath("//option[@value='hilo']")).click();
		String After=driver.findElement(By.xpath("(//div[@class='inventory_item_name'])[1]")).getText();
		Assert.assertNotEquals(After, Before);
	}

	@AfterMethod
	public void quit() {
		driver.quit();
	}

}
