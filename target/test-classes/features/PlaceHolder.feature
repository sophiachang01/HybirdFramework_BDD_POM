Feature: Testing 

#multiple line and uncomment - ctrl +/

#Scenario Outline: Automating Ecommerce Website 
#	Given The guest user Launches the application URL "<URL>" 
#	When The user goes on Registration page, enter registration details as "<RegistrationDetails>" on "<Market>" 
#	Then The user verify has registered with application 
#	Examples: 
#		|URL|RegistrationDetails|Market|
#		|http://automationpractice.com/index.php|mr,Tom,Alter,admin@1234,4,June,1990,amazon,2345 Crystal Drive,Arlington,Virginia,22202,United States,888-280-4331|global|
		
Scenario Outline: Place the Order as Guest User 
	Given The guest user Launches the application URL "<URL>" 
	When The user searches for the product "<ProductName>" 
	Then The Product page for product "<ProductName>" is displayed 
	When The user choose the product size as "<Product Size>" and quantity as "<Product Quantity>" and Color as "<Product Color>" 
	And User selects Add to bag
	When User selects View bag
	Then The Cart page is displayed
	And Product "<ProductName>" is displayed in cartPage
	When The user clicks on the Checkout Button
	When The user goes on Registration page, enter registration details as "<RegistrationDetails>" on "<Market>" 
	When The user clicks on the Checkout Button
	Then The delivery page is displayed to the user
	When The user enters the delivery details "<Delivery Data>"
    Then The Address page is displayed
    When The user choose the delivery address as "<Delivery Address>"
    When The user clicks on the Checkout Button
	Then The Shipping page is displayed
	When The user clicks on the Checkout Button
	Then The Payment page is displayed
	When The user choose the payment method as "<Payment Method>"
	
	Examples: 
		|URL|ProductName|Product Size|Product Quantity|Product Color|RegistrationDetails|Delivery Data|Delivery Address|Payment Method|
		|http://automationpractice.com/index.php|Printed Chiffon Dress|L|2|Green|mr,Tom,Alter,admin@1234,4,June,1990,amazon,2345 Crystal Drive,Arlington,Virginia,22202,United States,888-280-4331|Tom,Alter,amazon,2345 Crystal Drive,Arlington,Virginia,22202,United States,888-280-4331,Shipping Address|Shipping Address|Pay by check|
		
#Scenario Outline: Browser dresses as Guest User
#Given The guest user Launches the application URL "<URL>" 
#When The guest user hovers above the link "<Link>"
#Then The user clicks the sublinks and the Names of the categories are displayed
#Examples: 
#|URL|Link|
#|http://automationpractice.com/index.php|woman|
#|http://automationpractice.com/index.php|dresses|

#Scenario Outline: Automating Ecommerce Website 
#	Given The guest user Launches the application URL "<URL>" 
#	When The user goes on Registration page, enter registration details as "<RegistrationDetails>" on "<Market>" 
#	Then The user verify has registered with application 
#	When The user searches for the product "<ProductName>" 
#    Then The Product page for product "<ProductName>" is displayed 
#	Examples: 
#		|URL|RegistrationDetails|Market|ProductName|
#		|http://automationpractice.com/index.php|mr,Tom,Alter,admin@1234,4,June,1990,amazon,2345 Crystal Drive,Arlington,Virginia,22202,United States,888-280-4331|global|Printed Chiffon Dress|