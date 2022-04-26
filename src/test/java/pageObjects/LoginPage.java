package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org. openqa.selenium.support.CacheLookup;
import org. openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public WebDriver driver;

	public LoginPage(WebDriver rdriver) 
	{

		driver = rdriver;
		PageFactory.initElements(rdriver,this);
	}

	@FindBy(xpath="//*[@name='uid']")
	WebElement txtusername;

	@FindBy(xpath="//*[@name='password']")
	WebElement txtpassword;

	@FindBy(xpath="//*[@name='btnLogin']")
	WebElement btmsubmit;

	@FindBy(xpath="/html/body/div[3]/div/ul/li[10]/a")
    WebElement btnlogout;


	public void setUserName(String uname)
	{
		txtusername.sendKeys(uname);
	}
	public void setPasswprd(String pwd)
	{
		txtpassword.sendKeys(pwd);
	}

	public void clickSubmit()
	{
		btmsubmit.click();
	}

	public void clicklogout()
	{
		btnlogout.click();
	}

	public WebElement home()
	{
	return btnlogout;
	}
}

