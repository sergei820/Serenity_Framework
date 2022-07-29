Feature: Check items parameters

  Scenario: Check items materials
    Given User logs in to UI
    When User is on the inventory page
    Then User checks on the UI if Sauce Labs Bolt T-Shirt contains cotton

  Scenario: Check items prices
    Given User logs in to UI
    When User is on the inventory page
    Then User checks on the UI if Sauce Labs Backpack price is equal to price-list