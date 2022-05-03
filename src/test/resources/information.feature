Feature: test preapproval details

  Background:
    Given I log In
    When I Click on Mortgage Application
    Then I want to provide "Realtor" name
    Then I want to fill "ESTIMATED PURCHASE PRICE","DOWN PAYMENT AMOUNT","DOWN PAYMENT PERCENTAGE"
    And I want to pick "Other type of Down Payment" and verify
    And click "Next" and verify that next page contains "Personal Information"

  @temp
  Scenario: Verify PreApproval Details works
#    Given I login duobank using email and password
#    When I Click on Mortgage Application and fill in preapproval details
    Then I verify with title I'm in Personal Information page

  @temp
  Scenario: Verify PreApproval Details works
#    Given I login duobank using email and password
#    When I Click on Mortgage Application and fill in preapproval details
    Then I click no and fill in firs name,middle name,last name and select suffix
  @temp
  Scenario: Verify PreApproval Details works
#    Given I login duobank using email and password
#    When I Click on Mortgage Application and fill in preapproval details
    And I click no and fill in firs name,middle name,last name and select suffix
    Then I fill in all browser information

  @temp
  Scenario: Verify PreApproval Details works
#    Given I login duobank using email and password
#    When I Click on Mortgage Application and fill in preapproval details
    Then I click yes and fill in personal information and co-browser information

  @temp
  Scenario: Verify PreApproval Details works
#    Given I login duobank using email and password
#    When I Click on Mortgage Application and fill in preapproval details
    And I click yes and fill in personal information and co-browser information
    Then I click next and make sure Im in expenses page



