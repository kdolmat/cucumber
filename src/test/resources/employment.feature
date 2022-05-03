Feature: Employment and Income

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


    Scenario: Dashboard

#    Given I am on login page
#    When I press on Mortgage Application
    Then I should see Application Page


 @smoke
    Scenario: Employment information

      When I insert my employer information
      Then I can add Another Employer


      Scenario: Borrower Gross Monthly Employment Income

        When I insert my employer information
        And I add gross monthly income 5000
        Then I can go on the next application page


        Scenario: Borrower Gross Monthly Employment Income with overtime and bonuses

          When  I add gross monthly income 5000
          And add monthly overtime 100 and monthly bonuses 200
          Then Borrower Total Monthly Income increase from 5000 to 5300




