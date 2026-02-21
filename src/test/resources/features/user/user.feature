Feature: User API Testing

  Scenario: Get existing user
    When I call GET user API with id 2
    Then Response status should be 200

  Scenario: Get non-existing user
    When I call GET user API with id 23
    Then Response status should be 404

  Scenario: Get list users
    When I call GET all users API
    Then Response status should be 200