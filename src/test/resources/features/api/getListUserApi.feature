@api-get-list-user
Feature: Get list user

  @api @get-list-user
  Scenario: Get list user
    Given insert end point to get list users "https://reqres.in/api/users"
    And user insert page "1"
    And insert per page "5"
    Then user received list data user "200" "1" "6"

  @api @get-list-user-negative
  Scenario: Get list user
    Given insert end point to get list users "https://reqres.in/api/users"
    And user insert page "1"
    And insert per page "5"
    Then user received no data user "402"