@AddToChart
Feature: AddToChart

  @add-to-chart-positive
  Scenario: add item into chart
    Given user is already on homepage "standard_user" "secret_sauce"
    And user click add to chart button
    Then item added to chart "Remove"

  @add-to-chart-negative
  Scenario: add item into chart
    Given user is already on homepage "standard_user" "secret_sauce"
    And user click add to chart button
    Then item not Added to chart "Add to chart"
