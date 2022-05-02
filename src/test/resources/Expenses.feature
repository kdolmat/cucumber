Feature: Expenses

 Scenario: Housing Expenses
  Given I am on the Expenses page
  When I am click in Rent
  Then I am filling Monthly Rental Payment or First Mortagage
#  And I am clicking Next
  Then I should see the next page Employment and Income