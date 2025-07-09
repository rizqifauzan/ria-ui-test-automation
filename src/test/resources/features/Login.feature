Feature: Login Functionality

  Scenario: Successful login with valid credentials
    Given User opens the login page
    When User inputs valid username and password
    And User clicks the login button
    Then User should be redirected to the dashboard

  Scenario: Login with invalid credentials
    Given User opens the login page
    When User inputs invalid username and password
    And User clicks the login button
    Then User should see an error message


