@smoke
Feature: Frontend tests

  @testOne
  Scenario: Check items materials
    Given User opens login page and page successfully loaded
    And VALID_USER logs in to UI
    When User is on the inventory page and page successfully loaded
    Then User checks on the UI if SAUCE_LABS_BOLT_T_SHIRT contains cotton

  Scenario: Check items prices
    Given User opens login page and page successfully loaded
    And VALID_USER logs in to UI
    When User is on the inventory page and page successfully loaded
    Then User checks on the UI if SAUCE_LABS_BACKPACK price is equal to price-list