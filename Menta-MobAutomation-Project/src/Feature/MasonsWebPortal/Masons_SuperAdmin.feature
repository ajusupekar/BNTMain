Feature: Super-Admin Login Screen.

  Background: 
  	Given User should be able to launch the chrome browser and navigates to masons super admin portal
  	Then User land on masons super admin portal login screen
  	
  @MasonsPortalLogin
  Scenario Outline: To verify that when user performs login with valid credential then user navigates to Super User dashboard screen.
    When User provides masons super admin Username "<SAEmail>" and Password "<SAPass>"
    And User click on the masons super admin portal LOGIN button
    Then User land on masons super admin dashboard screen
    When User click on the masons super admin portal Logout button
    Then User land on masons super admin portal login screen
    Then User quit the browser 
    
    Examples: 
      | SAEmail 	  								| SAPass      |
      | sadmin@masonsfinancials.com | Password@12 |