@Checkout
Feature: Checkout

  @ui @Checkout-all-item
  Scenario: Checkout all item
    Given user is on homepage "standard_user" "secret_sauce"
    And user select all item
    And click chart
    And user at checkout page
    And click checkout button
    And user at input checkout information
    Then input checkout information "Rini" "Agustina" "40552"
    And click continue button
    And user is on checkout overview
    And click finish button
    Then checkout completed "Thank you for your order!"

  @ui @Checkout-all-item-negative
  Scenario: Checkout all item
    Given user is on homepage "standard_user" "secret_sauce"
    And user select all item
    And click chart
    And user at checkout page
    And click checkout button
    And user at input checkout information
    Then input checkout information "Rini" "Agustina" "40552"
    And click continue button
    And user is on checkout overview
    And click finish button
    Then checkout not completed "Order Failed!"