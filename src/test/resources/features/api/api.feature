@api
Feature: API Testing for DummyAPI User

  # 1. Positive - Get user by valid ID
  Scenario: Get user by valid ID
    Given I send a request to get user by id "60d0fe4f5311236168a109d4"
    Then the response status code should be 200

  # 2. Negative - Get user with ID format valid but not found
  Scenario: Get user by non-existent ID
    Given I send a request to get user by id "60d0fe4f5311236168a10999"
    Then the response status code should be 404

  # 3. Negative - Get user with invalid ID format
  Scenario: Get user by invalid ID format
    Given I send a request to get user by id "invalid123"
    Then the response status code should be 400

  # 4. Positive - Create a new user with valid data
  Scenario: Create a new user with valid data
    Given I create a new user with firstName "John", lastName "Doe", and email "unique"
    Then the response status code should be 200

  # 5. Positive - Update the created user
  Scenario: Update the created user
    Given I create a new user with firstName "Alex", lastName "Brown", and email "unique"
    When I update the created user firstName to "UpdatedAlex"
    Then the response status code should be 200
