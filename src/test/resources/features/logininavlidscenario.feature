Feature:To validate login functionality with inavlid data
  Background:
    Given user is in orangehrm login screen
    When user navigating to orangehrm url
  @invalidtestdata
  Scenario Outline:To validate login flow in orangeHRM application with invalid data
    Given user is in orangehrm login screen
    When user navigating to orangehrm url
    And user enters username as "<userName>"
    And user enters password as "<password>"
    Then user navigates to homescreen of orangehrm app
  Examples:
    |userName|password|
    |admin123|test12335|
    |test123|biswa12345|
    |biswa12345|test123456|
@datatablemaps
Scenario:To validate login flow in orangeHRM application with invalid data

    And user enters credential
      |userName|password|
       |admin123|test12335|
      |test123|biswa12345|
       |biswa12345|test123456|

    Then user navigates to homescreen of orangehrm app
    
