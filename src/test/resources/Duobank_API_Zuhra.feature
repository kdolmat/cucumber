Feature: Verify API of Duobank application
  @api
   Scenario: Check API of Duobank application

     Given I am on the homepage to login to the request
     And The valid body is added to the request
     When I send a POST request to endpoint "/register.php"
     Then The status code should be 200 and response payload should contain a message "You have successfully registered."
     When I enter the same credentials sent by API request
     Then I should be able to login

