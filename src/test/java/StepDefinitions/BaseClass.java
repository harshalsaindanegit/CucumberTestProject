package StepDefinitions;

import org.openqa.selenium.WebDriver;
import org.apache.log4j.Logger;

import pageObjects.AddCustomerPage;
import pageObjects.LoginPage;


public class BaseClass{
	
	public WebDriver driver;
	public LoginPage lp;
	public AddCustomerPage addcust;
	//public SearchCustomerPage searchcustomer;
	public static Logger logger;

}
