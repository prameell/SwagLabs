Feature: CheckOutOverview Feature

  Background:
    When user enters valid credentials
    And products page should be displayed
    And user add the product
    And product should be added and cart page is displayed
    And user should see the added product
    And user click the checkout button
    And checkoutPage should be displayed

  @testcase1  @checkOutOverview @regression
  Scenario Outline: validate the order completion
    When user enters valid details "<Test Case ID>"
    And user click the continue button
    And checkout overview page should be displayed
    And user should see the order
    And user click the finish button
    Then complete page should be displayed
    Examples:
      | Test Case ID |
      | TC001        |
      | TC002        |
      | TC003        |
      | TC004        |
      | TC005        |
      | TC006        |


  @testcase2  @checkOutOverview @regression
  Scenario Outline: validate user able to back to checkout details page
    When user enters valid details "<Test Case ID>"
    And user click the continue button
    And checkout overview page should be displayed
    And user click the cancel button in the page
    Then products page should be displayed
    Examples:
      | Test Case ID |
      | TC001        |
      | TC002        |
      | TC003        |
      | TC004        |
      | TC005        |
      | TC006        |
