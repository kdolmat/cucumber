Feature: Sign up features



  @db
  Scenario:verify new loan application in database
    Given I want to login
    When I fill in loan application
    Then I should be to on Application list
    And I should to be able to verify the loan amount details in the datable


  Scenario: delete loan application in database
    Given I want to login
    Then I should be to on Application list
    And I can delete loan amount