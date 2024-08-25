Feature: CheckOutDetails Feature

  Background:
    When user enters valid credentials
    And products page should be displayed
    And user add the product
    And product should be added and cart page is displayed
    And user should see the added product
    And user click the checkout button
    And checkoutPage should be displayed

  @TCa @checkOutDetails @regression
  Scenario Outline: validate user is able to enter details for complete the purchase
    When user enters valid details "<Test Case ID>"
    And user click the continue button
    Then checkout overview page should be displayed
    Examples:
      | Test Case ID |
      | TC001        |
      | TC002        |
      | TC003        |
      | TC004        |
      | TC005        |
      | TC006        |

  @TCb @checkOutDetails @regression
  Scenario: validate user is able to back to your cart page
    When user click the cancel button
    Then your cart page should be displayed
