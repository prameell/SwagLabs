Feature: Product Feature

  Background:
    When user enters valid credentials
    Then products page should be displayed

     ### without TestData ###
  @TC11 @product @regression
  Scenario Outline: validate user is able to see the products
    Then user should see the products displayed using below data "<Product Name>"
    Examples:
      | Product Name                      |
      | Sauce Labs Backpack               |
      | Sauce Labs Bike Light             |
      | Sauce Labs Bolt T-Shirt           |
      | Sauce Labs Fleece Jacket          |
      | Sauce Labs Onesie                 |
      | Test.allTheThings() T-Shirt (Red) |

  @TC22 @product @regression
  Scenario: Validate user is able to select the filter price low to high from dropdown
    When user apply the filter by price low to high from dropdown
    Then price low to high should be selected and sorted

  @TC33 @product @regression
  Scenario: Validate user is able to select the filter price high to low from dropdown
    When user apply the filter by price high to low from dropdown
    Then price high to low should be selected and sorted

  @TC44 @product @regression
  Scenario: Validate user is able to select the filter name Z to A from dropdown
    And user apply the filter by Name Z to A from dropdown
    Then Name Z to A should be selected and sorted

  @TC55 @product @regression
  Scenario: Validate user is able to add the product
    And user add the product
    And product should be added and cart page is displayed

  @way2TC11 @product @regression
  Scenario Outline: validate user is able to see the products
    Then user should see the products displayed "<Test Case ID>"
    Examples:
      | Test Case ID |
      | TC001        |
      | TC002        |
      | TC003        |
      | TC004        |
      | TC005        |
      | TC006        |
