package StepDefinitions;

import java.awt.AWTException;
import java.awt.Robot;import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.AddCustomerPage;
//import io.cucumber.java.en.*;
import pageObjects.LoginPage;
import pageObjects.SearchCustomerPage;
import utilities.LibraryUtils;


public class Steps extends BaseClass{

	@Before
	public void sertup() throws IOException
	{
		configprop=new Properties();
		FileInputStream configPropfile=new FileInputStream("config.properties");
		configprop.load(configPropfile);
		
		logger= Logger.getLogger("BDD Cucumber Test Project");
	    PropertyConfigurator.configure("Log4j.properties");
	    
	    String br=configprop.getProperty("browser");
	    
	    if(br.equals("chrome")) 
	    {	    
		System.setProperty("webdriver.chrome.driver",configprop.getProperty("chromepath"));
		driver=new ChromeDriver();
	    }
	    if(br.equals("msedge")) 
	    {
	    	System.setProperty("webdriver.edge.driver", configprop.getProperty("msedgepath"));
		    driver=new EdgeDriver();
	    } 	
		logger.info("*********Launching Browser********");
	}

	@Given("User Launch Chrome Browser")
	public void user_Launch_Chrome_Browser() {
		
		lp=new LoginPage(driver);
	}	
	@When("User opens URL {string}")
	public void user_opens_URL(String url) {
		logger.info("*********Openning URL********");
		driver.get(url);
	}
	@When("User enters Email as {string} and Password as {string}")
	public void user_enters_Email_as_and_Password_as(String email, String password) {
		logger.info("*********Providing Login Details********");
		lp.setUserName(email);
		lp.setPasswprd(password);
	}
	@When("Click on Login")
	public void click_on_Login() throws InterruptedException {
		lp.clickSubmit();
		Thread.sleep(6000);
	}
	@Then("Page title should be {string}")
	public void page_title_should_be(String title) throws InterruptedException {

		if (driver.getPageSource().contains("Login was unsuccessful."))
		{
			logger.info("*********Login Fail********");
			driver.close();
			Assert.assertTrue(false);
		}else
			logger.info("*********Login Pass********");
			Assert.assertEquals(title, driver.getTitle());
		Thread.sleep(2000);
		driver.manage().window().maximize();		
	}	
	@Then("close browser")
	public void close_browser() {
		logger.info("*********Closing Browser********");
		driver.quit();
	}

	// Customers Feature step Definition

	@Then("User can view Dashboad")
	public void user_can_view_Dashboad() {	
		addcust = new AddCustomerPage(driver);
		Assert.assertEquals(addcust.getPageTitle(),"GTPL Bank Manager HomePage");  
		System.out.println("This is page title of Dashboard"+ addcust.getPageTitle());
	}

	@When("User click on new customer menu")
	public void user_click_on_customers_Menu() throws Exception   {
		Thread.sleep(3000);
		addcust.clickOnCustomersMenu();
	}

	@Then("User can view Add new customer page")
	public void user_can_view_Add_new_customer_page() throws Exception {
		Thread.sleep(4000);
		Assert.assertEquals(addcust.getPageTitle(),"Gtpl Bank New Customer Entry Page");
		System.out.println("This is page title of New Customer" + addcust.getPageTitle());		
	}
	
	// Steps for search customer feature
	
	@When("User click on Edit")
	public void user_click_edit() throws Exception
	{
		SearchCustomerPage searchcust=new SearchCustomerPage(driver);
		searchcust.clickEdit();
		Thread.sleep(3000);
	}
	@Then("User can view Edit customer page")
	public void user_can_view_Edit_customer_page() throws Exception
	{
		Assert.assertEquals(driver.getTitle(),"Gtpl Bank Edit Customer Page");		
	}
}

