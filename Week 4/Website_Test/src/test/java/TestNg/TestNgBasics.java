package TestNg;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeMethod;

import java.nio.charset.Charset;
import java.util.*;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Priority;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.Test;

import net.bytebuddy.utility.RandomString;

public class TestNgBasics {
	
 WebDriver driver;
	
	@org.testng.annotations.BeforeClass
	public void openWebBrowser() {
		System.out.println("----LOGIN--------SEARCH-BAR------ADD-TO-CART-----");
		 
		//opening the WebBrowser.
		System.setProperty("webdriver.chrome.driver", "E:\\tools\\chromedriver.exe");
		driver = new ChromeDriver();
		  driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		  driver.manage().deleteAllCookies();
		  driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
	}
	
	
	@Test(priority = 1)
	public void loginTest() {
		//SignIn with valid credentials.
		
		driver.findElement(By.id("email")).sendKeys("dhwani29@somaiya.edu");
		driver.findElement(By.id("passwd")).sendKeys("dhwani29");
		driver.findElement(By.id("SubmitLogin")).click();
	}
	
	
	@Test(priority = 2,dependsOnMethods = "loginTest")
	public void searchBarTest() {
		driver.findElement(By.id("search_query_top")).sendKeys("top");
		driver.findElement(By.name("submit_search")).click();
	}
	
	@Test(priority = 3,dependsOnMethods = "searchBarTest")
	public void addToCartTest() {
		driver.findElement(By.linkText("Add to cart")).click();
	}
	
	@Test(priority = 4,dependsOnMethods = "addToCartTest")
	public void signOut() {
		driver.findElement(By.linkText("Sign out")).click();
		driver.get("http://automationpractice.com/index.php");
	}
	
	
	
//	@AfterClass
//	public void closeBrowser() {
//		driver.close();
//	}
	

}
