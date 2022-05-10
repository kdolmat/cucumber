Feature: Application Match

  Background:All the steps
    Given I log In
    When I Click on Mortgage Application



   Scenario Outline: test the Application info
   And I want to provide Realtors name, EPP,DPA,DPP. The following should be
      | Realtor| ESTIMATED PURCHASE PRICE | DOWN PAYMENT AMOUNT | DOWN PAYMENT PERCENTAGE |
      | <Realtor> | <ESTIMATED PURCHASE PRICE> | <DOWN PAYMENT AMOUNT> | <DOWN PAYMENT PERCENTAGE> |


    And click "Next" and verify that next page contains "Personal Information"
    And I click yes and fill in personal information and co-browser information
    Then I want to set the name
     |Name|
     Then I click next and make sure Im in expenses page
    When I am click in Rent
    Then I am filling Monthly Rental Payment or First Mortagage
    Then I should see the next page Employment and Income
    When I insert my employer information
    And I add gross monthly income 5000
    Then I can go on the next application page
    Then I should be able to move to the other page
     When I am filling First Name
     Then I am filling Last Name
     And I am filling Email
     Then I am clicking Agree on the eConsent agreement
     And I should be in Summary page
     And I click save


    When I go on applications list page
    Then I click on the first application and verify that the data matches with what I put in

     Examples:
       | Realtor | ESTIMATED PURCHASE PRICE | DOWN PAYMENT AMOUNT | DOWN PAYMENT PERCENTAGE |
       | Bruce Banner | 346900 | 86725 | 25 |
