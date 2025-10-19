@api-create-user
Feature: API create user

  @api @create-user
  Scenario: API create user
    Given insert end point to create user "https://reqres.in/api/users"
    And insert name "Rini Agustina"
    And insert job "QA Engineer"
    Then user already created "201" "Rini Agustina" "QA Engineer"

  @api @create-user-negative
  Scenario: API create user negative
    Given insert end point to create user "https://reqres.in/api/users"
    And insert name "Rini Agustina"
    And insert job "QA Engineer"
    Then user not created "402"


