Feature: Login
  as user i want to login Alfagift with phone number and password

  @TC001
  Scenario: Verify user able to login into alfagift with valid phone number & password
    Given user input phone number "0812858882277" on Login screen
    And user input password "TestPassword123" on Login screen
    When user click next button on Login screen
    Then user click Nanti on User Guide


