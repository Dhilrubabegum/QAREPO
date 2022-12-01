package testcases;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Socialconnect {
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
	public void Tc_SL_024() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"page_wrapper\"]/footer/ul/li[1]/a")).click();
		String url = driver.getCurrentUrl();
		Set<String> window1 = driver.getWindowHandles();
		List<String> l = new ArrayList<String>(window1);
		driver.switchTo().window(l.get(1));
		Thread.sleep(4000);
		WebElement TwitterLogo = driver.findElement(By.xpath(
				"//div[@class='css-901oao r-1awozwy r-1cvl2hr r-6koalj r-18u37iz r-16y2uox r-37j5jr r-a023e6 r-b88u0q r-1777fci r-rjixqe r-bcqeeo r-q4m81j r-qvutc0']"));
		Assert.assertEquals(true, TwitterLogo.isDisplayed());
		System.out.print("Twitterlogo displayed – Assert passed");
	}

	@Test
	public void Tc_SL_025() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"page_wrapper\"]/footer/ul/li[2]/a")).click();
		String url = driver.getCurrentUrl();
		Set<String> window1 = driver.getWindowHandles();
		List<String> l = new ArrayList<String>(window1);
		driver.switchTo().window(l.get(1));
		Thread.sleep(4000);
		WebElement facebookLogo = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div[2]/div[2]/div[1]"));
		Assert.assertEquals(true, facebookLogo.isDisplayed());
		System.out.print("facebook logo is displayed – Assert passed");

	}

	@Test
	public void Tc_SL_026() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"page_wrapper\"]/footer/ul/li[3]/a")).click();
		String url = driver.getCurrentUrl();
		Set<String> window1 = driver.getWindowHandles();
		List<String> l = new ArrayList<String>(window1);
		driver.switchTo().window(l.get(1));
		Thread.sleep(4000);
		Thread.sleep(4000);
		WebElement LinkedInLogo = driver.findElement(By.xpath("/html/body/div/header/nav/a/icon"));
		Assert.assertEquals(true, LinkedInLogo.isDisplayed());
		System.out.print("LinkedIn logo is displayed – Assert passed");
	}

	@AfterMethod
	public void quit() {
		driver.quit();
	}
}
