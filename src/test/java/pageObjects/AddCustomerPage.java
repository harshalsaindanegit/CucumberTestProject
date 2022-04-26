package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {

	public WebDriver ldriver;

	public AddCustomerPage(WebDriver rdriver)		
	{	
		ldriver=rdriver;

		PageFactory.initElements(ldriver,this);		
	}
	By lnkCustomers_menu=By.xpath("//a[text()='New Customer']/@href");
	By linkcustomer=By.linkText("New Customer");
	

	//Action Methods
	public String getPageTitle()
	{
		return ldriver.getTitle();
	}
	
	public void clickOnCustomersMenu() {

		ldriver.findElement(linkcustomer).click();

	}
	

}

