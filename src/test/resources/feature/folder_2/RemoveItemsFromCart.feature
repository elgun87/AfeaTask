@cart
Feature: Remove Items
  Background:
    Given user open url "https://www.demoblaze.com/index.html"

    Scenario: Remove items from cart
      When user click on log in button
      And user enter username as "brand_new_user_94"
      And user enter password as "user123"
      Then user click on final login button
      And user click on cart button
      Then verify all added phone item price one by one
      Then remove all items
