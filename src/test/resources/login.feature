Feature: Login

  Background:
    Given The base URI is set to "http://qa-duobank.us-east-2.elasticbeanstalk.com/api"

@api
  Scenario: API to UI login flow

   # When I am on login page
    And I insert valid email and password
    Then I should be able to login to Mortgage Application



