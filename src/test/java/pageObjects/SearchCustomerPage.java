package pageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitHelper;

public class SearchCustomerPage {
	public WebDriver ldriver;
	WaitHelper waithelper;
	
	public SearchCustomerPage(WebDriver rdriver)		
	{	
		ldriver=rdriver;

		PageFactory.initElements(ldriver,this);		
		WaitHelper waithelper;
	}
		
	@FindBy(linkText = "Edit Customer")
	@CacheLookup
	WebElement btnedit; 
	
	public void clickEdit()
	{
		btnedit.click();
	}

}
