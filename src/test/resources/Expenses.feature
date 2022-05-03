Feature: Expenses

 Background:
  Given I log In
  When I Click on Mortgage Application
  Then I want to provide "Realtor" name
  Then I want to fill "ESTIMATED PURCHASE PRICE","DOWN PAYMENT AMOUNT","DOWN PAYMENT PERCENTAGE"
  And I want to pick "Other type of Down Payment" and verify
  And click "Next" and verify that next page contains "Personal Information"
  And I click yes and fill in personal information and co-browser information
  Then I click next and make sure Im in expenses page

  @smoke
 Scenario: Housing Expenses
#  Given I am on the Expenses page
  When I am click in Rent
  Then I am filling Monthly Rental Payment or First Mortagage
  Then I should see the next page Employment and Income