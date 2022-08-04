@Smoke
Feature: Frontend tests

  Scenario: Check items materials
    Given VALID_USER logs in to UI
    When User is on the inventory page
    Then User checks on the UI if SAUCE_LABS_BOLT_T_SHIRT contains cotton

  Scenario: Check items prices
    Given VALID_USER logs in to UI
    When User is on the inventory page
    Then User checks on the UI if SAUCE_LABS_BACKPACK price is equal to price-list

  Scenario: Check pages loading
    When User opens login page
    Then Page successfully loaded
    And VALID_USER logs in to UI
    And User opens inventory page
    And Page successfully loaded
    And User opens inventory-item page
    And Page successfully loaded
    And User opens cart page
    And Page successfully loaded