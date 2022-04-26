Feature: Login

@sanity
Scenario: Successful Login with valid credentials
	Given User Launch Chrome Browser 
	When User opens URL "https://demo.guru99.com/V1/index.php"
	And User enters Email as "mngr402443" and Password as "evYvAnU"
	And Click on Login
	Then Page title should be "GTPL Bank Manager HomePage"
	And close browser
	
	@regression
	Scenario Outline: Login Data Driven
	Given User Launch Chrome Browser 
	When User opens URL "https://demo.guru99.com/V1/index.php"
	And User enters Email as "<Email>" and Password as "<Password>"
	And Click on Login
	Then Page title should be "GTPL Bank Manager HomePage"
	And close browser
	
	
	Examples:
		 	| Email | Password |
		 	| mngr402443 | evYvAnU |


		 	 
		 	 
	