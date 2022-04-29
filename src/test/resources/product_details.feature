@temp

Background: Common steps for all scenarios
Given I am on the homepage


Scenario: Verify product title 3 using parametrization
When I click on a product "Blouse"
And I land on a product details page with title containing "Blouse"
Then The title of the product should be "Blouse"
Then The price of the product should be 27.00


Scenario: Verify product title 3 using parametrization
When I click on a product "Faded Short Sleeve T-shirts"
And I land on a product details page with title containing "Faded Short Sleeve T-shirts"
Then The title of the product should be "Faded Short Sleeve T-shirts"
Then The price of the product should be 16.51


Scenario: Verify product title 3 using parametrization
When I click on a product "Printed Summer Dress"
And I land on a product details page with title containing "Printed Summer Dress"
Then The title of the product should be "Printed Summer Dress"
Then The price of the product should be 28.98



Scenario: Verify product default quantity
When I click on a product "Printed Chiffon Dress"
Then The default quantity should be 1


Scenario: Verify quantity increase with plus button
When I click on a product "Printed Chiffon Dress"
And I click on a plus button 20 times
Then The quantity should be correct