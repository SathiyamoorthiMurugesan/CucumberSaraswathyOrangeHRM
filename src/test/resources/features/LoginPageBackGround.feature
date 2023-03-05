Feature: This feature is to test login functionality of OrangeHRM page

  Background: 
    Given user launches OrangeHRM page
    Then validate user is on login page

  @LoginWithValidCredentials10
  Scenario: Validate OrangeHRM with valid credentials
    #    Given user launches OrangeHRM page
    #   Then validate user is on login page
    When user enters username and password and clicks on login button
    Then user able to see home page of OrangeHRM

  @LoginWithParameter11
  Scenario: Validate OrangeHRM with valid credentials with parameters in feature line
    #Given user launches OrangeHRM page
    #Then validate user is on login page
    When user enters username as "Admin" and password"admin123" and clicks on login button
    #When user enters "Admin" and "admin123" and clicks on login button
    Then user able to see home page of OrangeHRM

  @LoginWithParameter22
  Scenario Outline: Validate OrangeHRM with valid credentials with parameters in feature line
    #Given user launches OrangeHRM page
    #Then validate user is on login page
    When user enters username as <userName> and password<Password> and clicks on login button
    Then user able to see home page of OrangeHRM
    #Then user validates Option<OptionName> shows as <optionAmount>
    #Then user validates Option<OptionName1> shows as <optionAmount1>

    Examples: 
      | userName | Password   | OptionName | optionAmount | OptionName1 | optionAmount1 |
      #| "Admin"  | "admin123" |    "No Cov"        |       "0.00"       |    "Opt1"         |    "10.50"           |
      #| "Admin1" | "admin123" |            |              |             |               |
      #| "Admin2" | "admin123" |            |              |             |               |
      
      @LoginWithParameter111
  Scenario: Validate OrangeHRM with valid credentials with parameters in feature line
    #Given user launches OrangeHRM page
    When user enters username as "Admin" and password"admin123" and clicks on login button
    #When user enters "Admin" and "admin123" and clicks on login button
    Then user able to see home page of OrangeHRM
