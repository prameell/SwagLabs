Feature: YourCart Feature

  Background:
    When user enters valid credentials
    And products page should be displayed
    And user add the product
    And product should be added and cart page is displayed

  @TCA @yourCart @regression
  Scenario: Validate user is able to view the product
    Then user should see the added product

  @TCB @yourCart @regression
  Scenario: Validate user is able to continuing the shopping
    When user click the continue shopping button
    Then products page should be displayed

  @TCC @yourCart @regression
  Scenario: Validate user is able to checkout the product
    When user click the checkout button
    Then checkoutPage should be displayed

  @TCD @yourCart@regressions
  Scenario:Validate user is able to click the remove button
    Then user click the remove button and cart page should be empty




