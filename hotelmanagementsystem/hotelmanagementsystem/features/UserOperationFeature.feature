@tagRegister 
Feature: Testing User Portal 

#@tag1 
#Scenario: Register User 
#	Given Open the chrome and launch the application 
#	When Click on Register Link 
#	When Enter the valid data 
#	And Click on Register button 
#	
#@tag2 
#Scenario: Login User 
#	Given Open the chrome and launch the application 
#	When Click on Login Link 
#	When Enter the valid Login Data 
#	And Click on Login button 
	
	
@tag2 
Scenario: User Book Room 
	Given Open the chrome and launch the application 
	When Click on Login Link 
	When Enter the valid Login Data 
	And Click on Login button for Book Room
	When Click on View Room Button 
	When Click on Book Room Button 
	When Enter CheckIn and CheckOut Date 
	Then Click On Submit 
	When Enter Payment Valid Data 
	Then Click on Pay Button 
	Then Click on Booking Report Link
	Then Click on Profile  Link
	Then Click on logout Link
	
		