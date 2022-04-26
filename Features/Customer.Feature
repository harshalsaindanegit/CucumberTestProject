Feature: Customers

Scenario: Add new Customer
		Given User Launch Chrome Browser 
		When User opens URL "https://demo.guru99.com/V1/index.php"
		And User enters Email as "mngr402443" and Password as "evYvAnU"
		And Click on Login
		Then User can view Dashboad
		When User click on new customer menu
		Then User can view Add new customer page
		
Scenario: Search customer
    Given User Launch Chrome Browser 
		When User opens URL "https://demo.guru99.com/V1/index.php"
		And User enters Email as "mngr402443" and Password as "evYvAnU"
		And Click on Login
		And User click on Edit 
		
		
		
		