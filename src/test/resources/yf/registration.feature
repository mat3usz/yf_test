Feature: Yahoo Finance
  Stock prices are displayed

  Scenario: Highest closing price for F5 company
    Given user is on F5 page
    Then highest closing price since 5 days is printed
