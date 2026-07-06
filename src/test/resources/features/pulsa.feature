Feature: E-Service (Pulsa)

  Background:
    Given user input phone number "08118205085" on Login screen
    And user input password "Leonardok7" on Login screen
    When user click next button on Login screen
    Then user click Nanti on User Guide
    Given user on the HomePage
    Then  user click e-service menu

  @TC001
  Scenario: Verify user default phone number on pulsa menu
    Given user on the e-service menu
    When user click pulsa menu
    Then user should see phone number

  @TC002
  Scenario: Verify user phone number provider on e-service menu
    Given user on the e-service menu
    When user click pulsa menu
    Then user should see user phone number provider

  @TC003
  Scenario: Verify user should see pulsa product
    Given user on the e-service menu
    When user click pulsa menu
    Then user should discover pulsa product

  @TC004
  Scenario: Verify user ATC pulsa product
    Given user on the e-service menu
    When user click pulsa menu
    And user click pulsa product
    Then user should see ATC button

  @TC005
  Scenario: Verify user cancel ATC pulsa product
    Given user on the e-service menu
    When user click pulsa menu
    And user click pulsa product
    Then user should see ATC button
    When user click pulsa product
    Then user should not see ATC button


