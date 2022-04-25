Feature: Login

Scenario: Successful Login with valid credentials
	Given User Launch Chrome Browser 
	When User opens URL "https://admin-demo.nopcommerce.com/login"
	And User enters Email as "admin@yourstore.com" and Password as "admin"
	And Click on Login
	Then Page title should be "Dashboard / nopCommerce administration"
	And close browser
	
	
	Scenario Outline: Login Data Driven
	Given User Launch Chrome Browser 
	When User opens URL "https://admin-demo.nopcommerce.com/login"
	And User enters Email as "<Email>" and Password as "<Password>"
	And Click on Login
	Then Page title should be "Dashboard / nopCommerce administration"
	And close browser
	
	
	Examples:
		 	| Email | Password |
		 	| admin@yourstore.com | admin |
		 	| admin1@yourstore.com | admin123 |

		 	 
		 	 
	