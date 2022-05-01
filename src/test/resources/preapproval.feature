Feature: Preapproval

Background: Common steps for all scenarios
 Given I log In
 When I Click on Mortgage Application


Scenario: Verify The page
  Then I should see the "Preapproval Details"

Scenario: Verify The checkboxes
  Then I want to check all boxes No


#Scenario Outline: Fill the info up
#  Then I want to check all boxes Yes
#  Then I want to provide the "<Realtor>" name
#  Then I want to fill the "<ESTIMATED PURCHASE PRICE>","<DOWN PAYMENT AMOUNT>","<DOWN PAYMENT PERCENTAGE>"
#  And The following should be
#    | Realtor| ESTIMATED PURCHASE PRICE | DOWN PAYMENT AMOUNT | DOWN PAYMENT PERCENTAGE |
#    | <Realtor> | <ESTIMATED PURCHASE PRICE> | <DOWN PAYMENT AMOUNT> | <DOWN PAYMENT PERCENTAGE> |
#
#  Examples:
#    | Realtor | ESTIMATED PURCHASE PRICE | DOWN PAYMENT AMOUNT | DOWN PAYMENT PERCENTAGE |
#    | John Doe | 300.000 | 90.000 | 30.00 |
#    | Jane Doe | 100.000 | 10.000 | 10.00 |

  Scenario: Fill the info up
  Then I want to check all boxes Yes
  Then I want to provide the "Realtor" name
  Then I want to fill the "ESTIMATED PURCHASE PRICE","DOWN PAYMENT AMOUNT","DOWN PAYMENT PERCENTAGE"
  And I want to pick "Other type of Down Payment" and verify

  Scenario: Fill everything up and go to the next page
    Then I want to check all boxes Yes
    Then I want to provide the "Realtor" name
    Then I want to fill the "ESTIMATED PURCHASE PRICE","DOWN PAYMENT AMOUNT","DOWN PAYMENT PERCENTAGE"
    And I want to pick "Other type of Down Payment" and verify
    And click "Next" and verify that next page contains "Personal Information"