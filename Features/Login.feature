Feature: Login

Scenario: Successful Login with valid credentials
	Given user Launch Chrome Browser 
	When User opens URL "https://admin-demo.nopcommerce.com/login"
	And User enters Email as "admin@yourstore.com" and Password as "admin"
	And Click on Login
	Then Page title should be "Dashboard / nopCommerce administration"
	When User click on Log out link 
	Then Page TItle should be "Your store. Login"
	And close browser