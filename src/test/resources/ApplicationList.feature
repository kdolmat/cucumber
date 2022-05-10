
Feature: test preapproval details

  Scenario: Mortgage Application
    Given I want to fill in all Mortage Application
    Then click Application list

  @list
  Scenario: Mortgage Application
    Given I want to login and click to Application list
    Then I can find in search button Borrower name