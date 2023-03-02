Feature: This feature is to test login functionality of OrangeHRM page

  @LoginWithValidCredentials
  Scenario: Validate OrangeHRM with valid credentials
    Given user launches OrangeHRM page
    Then validate user is on login page
    When user enters username and password and clicks on login button
    Then user able to see home page of OrangeHRM

  