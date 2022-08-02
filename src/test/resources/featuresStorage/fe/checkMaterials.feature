@Smoke
Feature: Check items parameters

  Scenario: Check items materials
    Given validUser logs in to UI
    When User is on the inventory page
    Then User checks on the UI if SAUCE_LABS_BOLT_T_SHIRT contains cotton

  Scenario: Check items prices
    Given validUser logs in to UI
    When User is on the inventory page
    Then User checks on the UI if SAUCE_LABS_BACKPACK price is equal to price-list