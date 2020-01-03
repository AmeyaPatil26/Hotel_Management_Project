Feature: Testing the Employee Booking Feature

Scenario: Employee login
	Given Open the chrome and launch the application by employee
	When employee Click on Login Link 
	When employee Enter the valid Login Data 
	And employee Click on Login button 
	And employee click on HotelInfo
	And employee click on Room List
	And employee click on User Booking
	And employee enter User Booking Valid data
	And employee click on Book User
	And employeee click on logout
