Feature: Customers

Scenario: Add new Customer
		Given User Launch Chrome Browser 
		When User opens URL "http://admin-demo.nopcommerce.com/login"
		And User enters Email as "admin@yourstore.com" and Password as "admin"
		And Click on Login
		Then User can view Dashboad
		When User click on new customer menu
		Then User can view Add new customer page
		