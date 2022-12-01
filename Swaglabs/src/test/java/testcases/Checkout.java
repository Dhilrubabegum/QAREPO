package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Checkout {
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

}
	@Test
	public void Tc_SL_042043() throws InterruptedException {
		driver.findElement(By.id("checkout")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("cancel")).click();
		
	}
	@DataProvider(name = "checkout")
	public String[][]getdata() {
		String[][]data=new String[4][3];
	
		data[0][0]="";			//Tc_SL_046
		data[0][1]="";
		data[0][2]="";
		
		data[1][0]="xyz";		//Tc_SL_047
		data[1][1]="";
		data[1][2]="12345";
		
		data[2][0]="xyz";		//Tc_SL_048
		data[2][1]="abc";
		data[2][2]="";
		
		data[3][0]="";			//Tc_SL_049
		data[3][1]="abc";
		data[3][2]="12345";
		

		
	
		return data;
	}
	@Test(dataProvider = "checkout")
	public  void Tc_SL_046t0049(String firstname, String lastname, String postalcode) throws InterruptedException{
		driver.findElement(By.id("checkout")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("first-name")).sendKeys(firstname);
		driver.findElement(By.id("last-name")).sendKeys(lastname);
		driver.findElement(By.id("postal-code")).sendKeys(postalcode);
		Thread.sleep(2000);
		driver.findElement(By.id("continue")).click();

		System.out.println(driver.findElement(By.xpath("//h3[@data-test='error']")).getText());
	}
	
	@AfterMethod
	public void quit() {
		driver.quit();
	}
		
}
