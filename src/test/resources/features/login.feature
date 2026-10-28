Feature:To validate login functionality

   Background:
    Given user is in orangehrm login screen
    When user navigating to orangehrm url

  @smoke
  Scenario:To validate login flow in orangeHRM application with valid data


    And user enters username as "admin"
    And user enters password as "admin123"
    And user clicks on login CTA
    Then user navigates to homescreen of orangehrm app
    Then user should verify Home text
  @regression
  Scenario:To validate login flow in orangeHRM application with invalid data

    And user enters username as "admin123"
    And user enters password as "admin12345"
    And user clicks on login CTA
    Then user should not  navigate to homescreen of orangehrm app
