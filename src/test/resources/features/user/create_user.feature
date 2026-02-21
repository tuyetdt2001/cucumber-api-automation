Feature: Create User

  Scenario: Create user successfully
    Given a valid user information
    When user sends create user request
    Then response status should be 201