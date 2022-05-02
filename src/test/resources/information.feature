Feature: test preapproval details

  @temp
  Scenario: Verify PreApproval Details works
    Given I login duobank using email and password
    When I Click on Mortgage Application and fill in preapproval details
    Then I verify with title I'm in Personal Information page

  @temp
  Scenario: Verify PreApproval Details works
    Given I login duobank using email and password
    When I Click on Mortgage Application and fill in preapproval details
    Then I click no and fill in firs name,middle name,last name and select suffix
  @temp
  Scenario: Verify PreApproval Details works
    Given I login duobank using email and password
    When I Click on Mortgage Application and fill in preapproval details
    And I click no and fill in firs name,middle name,last name and select suffix
    Then I fill in all browser information

  @temp
  Scenario: Verify PreApproval Details works
    Given I login duobank using email and password
    When I Click on Mortgage Application and fill in preapproval details
    Then I click yes and fill in personal information and co-browser information

  @temp
  Scenario: Verify PreApproval Details works
    Given I login duobank using email and password
    When I Click on Mortgage Application and fill in preapproval details
    And I click yes and fill in personal information and co-browser information
    Then I click next and make sure Im in expenses page



