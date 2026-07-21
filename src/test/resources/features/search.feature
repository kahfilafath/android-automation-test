Feature: Search Product

  As customer, I want to be able search the product on the home page, so I could discover the product that I’d like to buy

  Background:
    Given user input phone number "" on Login screen
    And user input password "" on Login screen
    When user click next button on Login screen
    Then user click Nanti on User Guide

  @TC002
  Scenario: Verify user should discover the product after searching it with the correct keyword on the search bar
    Given user on the HomePage
    When user click field search
    And user search the product "ultra milk susu uht coklat" on the search bar
    And user see the product suggestion "ultra milk susu uht coklat" below the search bar
    And user click the product suggestion below the search bar
    Then user should discover the product "ultra milk susu uht coklat kotak 200 ml" on the search result page

