Feature: This feature is to test login functionality of OrangeHRM page

  @LoginWithValidCredentials
  Scenario: Validate OrangeHRM with valid credentials
    Given user launches OrangeHRM page
    Then validate user is on login page
    When user enters username and password and clicks on login button
    Then user able to see home page of OrangeHRM

  @LoginWithParameter1
  Scenario: Validate OrangeHRM with valid credentials with parameters in feature line
    Given user launches OrangeHRM page
    Then validate user is on login page
    When user enters username as "Admin" and password"admin123" and clicks on login button
    #When user enters "Admin" and "admin123" and clicks on login button
    Then user able to see home page of OrangeHRM
    
  @LoginWithParameter2
  Scenario Outline: Validate OrangeHRM with valid credentials with parameters in feature line
    Given user launches OrangeHRM page
    Then validate user is on login page
    When user enters username as <userName> and password<Password> and clicks on login button
    Then user able to see home page of OrangeHRM

    Examples:
    |userName|Password|
    |"Admin"|"admin123"|
    |"Admin1"|"admin123"|
    |"Admin2"|"admin123"|