package StepDefinitions;

import java.awt.AWTException;
import java.awt.Robot;import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
//import io.cucumber.java.en.*;
import pageObjects.LoginPage;
import utilities.LibraryUtils;


public class Steps {

	public WebDriver driver;
	public LoginPage lp;
	@Given("User Launch Chrome Browser")
	public void user_Launch_Chrome_Browser() {
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//Drivers/chromedriver.exe");
		driver=new ChromeDriver();
		lp=new LoginPage(driver);
	}	
	@When("User opens URL {string}")
	public void user_opens_URL(String url) {
		driver.get(url);

	}
	@When("User enters Email as {string} and Password as {string}")
	public void user_enters_Email_as_and_Password_as(String email, String password) {

		lp.setUserName(email);
		lp.setPassword(password);

	}
	@When("Click on Login")
	public void click_on_Login() throws InterruptedException {
		lp.clickLogin();
		Thread.sleep(3000);
			}
	@Then("Page title should be {string}")
	public void page_title_should_be(String title) throws InterruptedException {

		if (driver.getPageSource().contains("Login was unsuccessful."))
		{
			driver.close();
			Assert.assertTrue(false);
		}else
			Assert.assertEquals(title, driver.getTitle());
		driver.manage().window().maximize();
		Thread.sleep(5000);
	}	

	@Then("close browser")
	public void close_browser() {
		driver.quit();
	}

}
