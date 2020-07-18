package TestNg;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import net.bytebuddy.utility.RandomString;

public class RegisterUser {
WebDriver driver;
Map<String, String> hm = new Hashtable<String, String>(); 
	
	@org.testng.annotations.BeforeClass
	public void openWebBrowser() {
		System.out.println("-------Handles REGISTRATION FORM and LOGIN ERRORS-------");
		 
		System.setProperty("webdriver.chrome.driver", "E:\\tools\\chromedriver.exe");
		driver = new ChromeDriver();
		  driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		  driver.manage().deleteAllCookies();
		  driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		  
	}
	
	
	@Test(priority = 1)
	public void registerUser() {
		//Generating random emailId for every new user.
		
		int length = 10;
	    boolean useLetters = true;
	    boolean useNumbers = false;
	    
	    RandomString r;
	    String email = RandomString.make(7);
	  email = email.concat("@gmail.com");
	  String password = "abc123";
	 
	  hm.put(email, password);
		driver.findElement(By.id("email_create")).sendKeys(email);
		driver.findElement(By.id("SubmitCreate")).click();
	}
	
	@Test(priority = 2, dependsOnMethods = "registerUser")
	public void signupUser() {
		
		//Filling up all the mandatory fields.
		driver.findElement(By.id("uniform-id_gender1")).click();
		driver.findElement(By.id("customer_firstname")).sendKeys("Blue");
		driver.findElement(By.id("customer_lastname")).sendKeys("JOnes");
		driver.findElement(By.id("passwd")).sendKeys("abc123");

		
		driver.findElement(By.id("firstname")).sendKeys("Blue");
		driver.findElement(By.id("lastname")).sendKeys("JOnes");
		driver.findElement(By.id("address1")).sendKeys("96 West Buckingham Ave. Savage, MN 55378");
		driver.findElement(By.id("city")).sendKeys("Minnesota");
		driver.findElement(By.id("id_state")).sendKeys("Texas");
		driver.findElement(By.id("postcode")).sendKeys("10005");
		driver.findElement(By.id("phone_mobile")).sendKeys("9876543210");
		
		driver.findElement(By.id("submitAccount")).click();
		
	}
	
	
	@Test(priority = 3,dependsOnMethods = "signupUser")
	public void signOut() {
		//Signing out after the successful creation of the user.
		driver.findElement(By.linkText("Sign out")).click();
		
	}
	
	@Test(priority = 4,dependsOnMethods = "signOut")
	public void loginTest() {
		
		//Verifies and stores every new emailId created
		for (Map.Entry<String, String> e : hm.entrySet()) 
		{
		driver.findElement(By.id("email")).sendKeys(e.getKey());
		driver.findElement(By.id("passwd")).sendKeys(e.getValue());
		driver.findElement(By.id("SubmitLogin")).click();
		driver.findElement(By.linkText("Sign out")).click();
		//driver.get("http://automationpractice.com/index.php");
		}
		
	}
	
	//--------Error Handling--
	
	@Test(priority = 5, dependsOnMethods = "signOut")
	public void emptyUserTest() {
		//empty click & handling email id
		driver.findElement(By.xpath("//*[@id=\"SubmitLogin\"]")).click();
		String actual_error = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div[1]/ol/li")).getText();
		String expected_error = "An email address required.";
		AssertJUnit.assertEquals(actual_error, expected_error);
		
		//empty click
		//handling only empty password.
		driver.findElement(By.id("email")).sendKeys("dhwani29@somaiya.edu");
		driver.findElement(By.id("SubmitLogin")).click();
		
		String a1 = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div[1]/ol/li")).getText();
		String e1 = "Password is required.";
		AssertJUnit.assertEquals(a1, e1);
	}
	
	
	@Test(priority = 6, dependsOnMethods = "signOut")
	public void validUserTest() {
		//invalid user check
		//works only when both fields are filled.
		
		driver.findElement(By.id("passwd")).sendKeys("dhni29");
		driver.findElement(By.id("SubmitLogin")).click();
		
		String actual_error = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div[1]/ol/li")).getText();
		String expected_error = "Authentication failed.";
		AssertJUnit.assertEquals(actual_error, expected_error);
	}
	

//	@AfterClass
//	public void closeBrowser() {
//		driver.close();
//	}
	
}
