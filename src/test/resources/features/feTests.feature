@smoke
Feature: Frontend tests

  @testOne
  Scenario: Check materials
    Given User sets testCaseId 1
    And User opens login page and page successfully loaded
    And VALID_USER logs in to UI
    When User is on the inventory page and page successfully loaded
    Then User checks on the UI if SAUCE_LABS_BOLT_T_SHIRT contains cotton

  @testTwo
  Scenario: Check prices
    Given User sets testCaseId 2
    And User opens login page and page successfully loaded
    And VALID_USER logs in to UI
    When User is on the inventory page and page successfully loaded
    Then User checks on the UI if SAUCE_LABS_BACKPACK price is equal to price-list