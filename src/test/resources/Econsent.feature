Feature: Econsent

  Background:
    Given I log In
    When I Click on Mortgage Application
    Then I want to provide "Realtor" name
    Then I want to fill "ESTIMATED PURCHASE PRICE","DOWN PAYMENT AMOUNT","DOWN PAYMENT PERCENTAGE"
    And I want to pick "Other type of Down Payment" and verify
    And click "Next" and verify that next page contains "Personal Information"
    And I click yes and fill in personal information and co-browser information
    Then I click next and make sure Im in expenses page
    When I am click in Rent
    Then I am filling Monthly Rental Payment or First Mortagage
    Then I should see the next page Employment and Income
    When I insert my employer information
    And I add gross monthly income 5000
    Then I can go on the next application page
    Then I should be able to move to the other page



  Scenario: PreApproval Inquiry

    When I am filling First Name
    Then I am filling Last Name
    And I am filling Email
    Then I am clicking Agree on the eConsent agreement
    And I should be in Summary page
    And I click save