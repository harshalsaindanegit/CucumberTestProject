Feature: Customers

 Background: 
		Given User Launch Chrome Browser 
		When User opens URL "https://demo.guru99.com/V1/index.php"
		And User enters Email as "mngr402443" and Password as "evYvAnU"
		And Click on Login 

Scenario: Add new Customer		
		Then User can view Dashboad
		When User click on new customer menu
		Then User can view Add new customer page
		And close browser
		
Scenario: Search customer
		And User click on Edit
		Then User can view Edit customer page 
		And close browser
		
		
		