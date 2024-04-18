Feature: Test Backgroud Feature

Background: User is logged in
	Given user navigate to the PRISM login page
	Then enter the username and password
	Then validate user is on home page

@ManageServiceRequest
Scenario: Manage Service Request page Test
	Given user click on main Warranty module
	Then user click on Manage Service Request module
	Then validate user is on manage service request page
	Then user close the browser

@BPRACalculation	
Scenario: BPRA Calculation page test
	Given user click on main Accounting module
	Then user click on BPRA Calculation module
	Then validate user is on BPRA Calculation page
	Then user close the browser