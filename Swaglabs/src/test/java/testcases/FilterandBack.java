package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FilterandBack {
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
	public void Tc_SL_028() throws InterruptedException {

		driver.findElement(By.xpath("//select[@class='product_sort_container']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//option[@value='az']")).click();

		String Before=driver.findElement(By.xpath("(//div[@class='inventory_item_name'])[1]")).getText();
		driver.findElement(By.xpath("(//div[@class='inventory_item_name'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("back-to-products")).click();
		Thread.sleep(2000);
		String After=driver.findElement(By.xpath("(//div[@class='inventory_item_name'])[1]")).getText();
		Assert.assertEquals(After, Before);
		
	

	}

	@Test
	public void Tc_SL_029() throws InterruptedException {

		driver.findElement(By.xpath("//select[@class='product_sort_container']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//option[@value='za']")).click();
		Thread.sleep(2000);
		String Before=driver.findElement(By.xpath("(//div[@class='inventory_item_name'])[1]")).getText();
		driver.findElement(By.xpath("(//div[@class='inventory_item_name'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("back-to-products")).click();
		Thread.sleep(2000);
		String After=driver.findElement(By.xpath("(//div[@class='inventory_item_name'])[1]")).getText();
		Assert.assertEquals(After, Before);
		
	
	}
	@Test
	public void Tc_SL_030() throws InterruptedException {

		driver.findElement(By.xpath("//select[@class='product_sort_container']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//option[@value='lohi']")).click();
		Thread.sleep(2000);
		String Before=driver.findElement(By.xpath("(//div[@class='inventory_item_name'])[1]")).getText();
		driver.findElement(By.xpath("(//div[@class='inventory_item_name'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("back-to-products")).click();
		Thread.sleep(2000);
		String After=driver.findElement(By.xpath("(//div[@class='inventory_item_name'])[1]")).getText();
		Assert.assertEquals(After, Before);
		
	}
	@Test
	public void Tc_SL_031() throws InterruptedException {

		driver.findElement(By.xpath("//select[@class='product_sort_container']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//option[@value='hilo']")).click();
		Thread.sleep(2000);
		String Before=driver.findElement(By.xpath("(//div[@class='inventory_item_name'])[1]")).getText();
		driver.findElement(By.xpath("(//div[@class='inventory_item_name'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("back-to-products")).click();
		Thread.sleep(2000);
		String After=driver.findElement(By.xpath("(//div[@class='inventory_item_name'])[1]")).getText();
		Assert.assertEquals(After, Before);
		
	}

@AfterMethod
public void quit() {
	driver.quit();
	
}

}
