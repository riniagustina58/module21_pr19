@login
Feature: Login

  @valid-login
  Scenario: Login with valid username and password
    Given user is on login page
    When  user input email text box with "standard_user"
    And user input password pada text box with "secret_sauce"
    And user click login button
    Then user is on homepage

  @invalid-login
  Scenario: Login with invalid username and password
    Given user is on login page
    When  user input email text box with "standard_user1"
    And user input password pada text box with "secret_sauce1"
    And user click login button
    And user see error message error "Epic sadface: Username and password do not match any user in this service"

  @lockout-user
  Scenario: Login with locked user
    Given user is on login page
    When  user input email text box with "locked_out_user"
    And user input password pada text box with "secret_sauce"
    And user click login button
    And user see error message error "Epic sadface: Sorry, this user has been locked out."

  @login-edge-case
  Scenario: Login with invalid username and password
    Given user is on login page
    When  user input email text box with "standard_user12345678922222965aaaaaaaaaaaaaaaaaaaaaaaaaaaabbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb"
    And user input password pada text box with "secret_sauce1bbbbbbbbbbbbbbbbbbbbbbbqwervvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv"
    And user click login button
    And user see error message error "Epic sadface: Username and password do not match any user in this service"



