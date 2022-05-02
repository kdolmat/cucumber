Feature: Econsent

  Scenario: PreApproval Inquiry
    Given I am on the eConsent page
    When I am filling First Name
    Then I am filling Last Name
    And I am filling Email
    Then I am clicking Agree with the eConsent agreement
#   Then I push Next
     And I should be in Summary page