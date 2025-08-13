@web
Feature: Login functionality in SauceDemo

  Scenario: Login with valid credentials
    Given I open Saucedemo login page
    When I login with username "standard_user" and password "secret_sauce"
    Then I should see the products page

  Scenario: Login with invalid username
    Given I open Saucedemo login page
    When I login with username "wrong_user" and password "secret_sauce"
    Then I should see an error message

  Scenario: Login with invalid password
    Given I open Saucedemo login page
    When I login with username "standard_user" and password "wrong_pass"
    Then I should see an error message

  Scenario: Login with empty username and password
    Given I open Saucedemo login page
    When I login with username "" and password ""
    Then I should see an error message

  Scenario: End-to-end: Add product to cart and checkout
    Given I login with valid credentials for E2E
    When I add first product to cart
    And I proceed to checkout
    Then I should see order confirmation page
