@api
Feature: API Testing for DummyAPI User

  Scenario: Get user by valid ID
    Given I send a request to get user by id "60d0fe4f5311236168a109d4"
    Then the response status code should be 200

  Scenario: Get user by non-existent ID
    Given I send a request to get user by id "60d0fe4f5311236168a10999"
    Then the response status code should be 404

  Scenario: Get user by invalid ID format
    Given I send a request to get user by id "invalid123"
    Then the response status code should be 400

  Scenario: Create a new user with valid data
    Given I create a new user with firstName "John", lastName "Doe", and email "unique"
    Then the response status code should be 200

  Scenario: Update the created user
    Given I create a new user with firstName "Alex", lastName "Brown", and email "unique"
    When I update the created user firstName to "UpdatedAlex"
    Then the response status code should be 200
