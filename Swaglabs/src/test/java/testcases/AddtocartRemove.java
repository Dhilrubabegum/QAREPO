package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddtocartRemove {
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
	public void Tc_SL_032035() throws InterruptedException {

		driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
		Thread.sleep(2000);
		WebElement p = driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
		String s = p.getText();
		System.out.println("Total Product : " + s);

		driver.findElement(By.id("remove-sauce-labs-backpack")).click();
		Thread.sleep(2000);
		WebElement q = driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
		String t = q.getText();
		System.out.println("Total Product : " + t);

	}

	@Test
	public void Tc_SL_033036() throws InterruptedException {

		driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
		driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
		driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();
		driver.findElement(By.id("add-to-cart-sauce-labs-fleece-jacket")).click();
		driver.findElement(By.id("add-to-cart-sauce-labs-onesie")).click();
		driver.findElement(By.id("add-to-cart-test.allthethings()-t-shirt-(red)")).click();
		Thread.sleep(3000);
		WebElement p = driver.findElement(By.xpath("//span[@class='shopping_cart_badge']"));
		String s = p.getText();
		System.out.println("Total Product : " + s);
		driver.findElement(By.id("remove-sauce-labs-backpack")).click();
		driver.findElement(By.id("remove-sauce-labs-bike-light")).click();
		driver.findElement(By.id("remove-sauce-labs-bolt-t-shirt")).click();
		driver.findElement(By.id("remove-sauce-labs-fleece-jacket")).click();
		driver.findElement(By.id("remove-sauce-labs-onesie")).click();
		driver.findElement(By.id("remove-test.allthethings()-t-shirt-(red)")).click();
		WebElement q = driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
		String t = q.getText();
		System.out.println("Total Product : " + t);

	}

	@Test
	public void Tc_SL_034037() throws InterruptedException {
		driver.findElement(By.id("item_4_img_link")).click();
		driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
		Thread.sleep(3000);
		WebElement p = driver.findElement(By.xpath("//span[@class='shopping_cart_badge']"));
		String s = p.getText();
		System.out.println("Total Product : " + s);
		driver.findElement(By.id("remove-sauce-labs-backpack")).click();
		Thread.sleep(2000);
		WebElement q = driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
		String t = q.getText();
		System.out.println("Total Product : " + t);
	}

	@Test
	public void Tc_SL_038039040() throws InterruptedException {
		driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
		driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
		Thread.sleep(2000);
		WebElement q = driver.findElement(By.xpath("//div[@class='cart_quantity']"));
		String t = q.getText();
		System.out.println("Total Product : " + t);
		Thread.sleep(2000);
		driver.findElement(By.id("remove-sauce-labs-backpack")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("continue-shopping")).click();
		Thread.sleep(2000);
		WebElement product = driver.findElement(By.xpath("//img[@class='inventory_item_img']"));
		Assert.assertEquals(true, product.isDisplayed());
		System.out.print("Back to the products");
	
	}
	@Test
	public void Tc_SL_041() throws InterruptedException {
		driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
		driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
		Thread.sleep(2000);
		WebElement Q=driver.findElement(By.xpath("//div[@class='cart_quantity']"));
		Q.click();
		Q.clear();
	}

	@AfterMethod
	public void quit() {
		driver.quit();
	}
}
