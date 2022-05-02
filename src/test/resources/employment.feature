Feature: Employment and Income
  @dashboard
    Scenario: Dashboard

    Given I am on login page
    When I press on Mortgage Application
    Then I should see Application Page


  @dashboard
    Scenario: Employment information

      When I insert my employer information
      Then I can add Another Employer

  @dashboard
      Scenario: Borrower Gross Monthly Employment Income

        When I insert my employer information
        And I add gross monthly income
        Then I can go on the next application page

  @dashboard
        Scenario: Borrower Gross Monthly Employment Income with overtime and bonuses

          When  I add gross monthly income
          And add monthly overtime 100 and monthly bonuses 200
          Then Borrower Total Monthly Income increase

        | GROSS MONTHLY INCOME* | MONTHLY OVERTIME | MONTHLY BONUSES |
        |  5000                 | 100              | 200             |


