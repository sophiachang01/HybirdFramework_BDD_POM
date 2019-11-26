Feature: Testing 

#multiple line and uncomment - ctrl + /

#Scenario Outline: Automating Ecommerce Website 
#	Given The guest user Launches the application URL "<URL>" 
#	When The user goes on Registration page, enter registration details as "<RegistrationDetails>" on "<Market>" 
#	Then The user verify has registered with application 
#	Examples: 
#		|URL|RegistrationDetails|Market|
#		|http://automationpractice.com/index.php|mr,Tom,Alter,admin@1234,4,June,1990,amazon,2345 Crystal Drive,Arlington,Virginia,22202,United States,888-280-4331|global|
		
#Scenario Outline: Place the Order as Guest User 
#Given The guest user Launches the application URL "<URL>" 
#When The user searches for the product "<ProductName>" 
#Then The Product page for product "<ProductName>" is displayed
#Examples: 
#|URL|ProductName|
#|http://automationpractice.com/index.php|Printed Chiffon Dress|
				
Scenario Outline: Browser dresses as Guest User
Given The guest user Launches the application URL "<URL>" 
#When The guest user hovers above the link "<Link>" and clicks the sublinks
Examples: 
|URL|Link|
|http://automationpractice.com/index.php|dresses|