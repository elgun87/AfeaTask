@AddPhoneItems
Feature: add each items to cart under Phone category and remove them after adding
  and at the same time we will verify each product’s displayed price is same with cart price.

  Background:
    Given user open url "https://www.demoblaze.com/index.html"
    When user click on log in button
    And user enter username as "brand_new_user_94"
    And user enter password as "user123"
    Then user click on final login button

  Scenario: Add all items under Phone category to the cart
    When user click on "Phones"
    And user captures all items and add all items to the cart


  Scenario: Add all items under Laptops category to the cart
    When user click on "Laptops"
    And user captures all items and add all items to the cart



  Scenario: Add all items under Monitors category to the cart
    When user click on "Monitors"
    And user captures all items and add all items to the cart


