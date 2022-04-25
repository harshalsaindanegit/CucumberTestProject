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
	By lnkCustomers_menu=By.xpath("//al@href='#'1//span[contains(text(),'Customers')]");
	By lnkCustomers_menuitem=By.xpath("//span[@class='menu-item-title'][contains(text(),'Customer')]");		
	By btnAddnew=By.xpath("//a(@class='btn bg-blue']"); //Add new
	
//Action Methods
	public void clickOnCustomersMenu() {
	
		ldriver.findElement(lnkCustomers_menu).click();
	
	    }
		public void clickonCustomersMenuItem(){
	
		ldriver.findElement(lnkCustomers_menuitem).click();
		}
		
		public void clickOnAddnew() {
	
		ldriver.findElement(btnAddnew).click();
		}

}

