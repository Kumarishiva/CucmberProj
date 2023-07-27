Feature: Applicaton Login

  Scenario: Login with valid credentials
    Given open any Browser
    And Navigate to Login page
    When User enters username as "iam@gmail.com" and password as "iamsony" into the fields
    And User clicks on Login button
    Then Verify user is able to successfully login
