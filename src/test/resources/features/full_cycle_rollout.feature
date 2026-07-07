@FullCycleRollout
Feature: Full Cycle Rollout E-Commerce Platform Beta

  @FCR-FullCycle
  Scenario: Success Execute Full Cycle Rollout E2E Flow
    Given user opens Alfagift Beta application
    When user inputs phone number "081287238167"
    And user inputs valid password "Cath0701."
    Then user should be successfully redirected to homepage
    When user types keyword "aqua" in search bar
    Then application displays matching product list
    Given user sees the product from search result
    When user clicks add to basket button on the product
    Then basket status is updated with the product
    Given user goes to Basket page
    Then application renders product and displays checkout button
    Given user is on Order Summary page
    When user clicks Change button on store pickup option
    Then user is redirected to store location selection page