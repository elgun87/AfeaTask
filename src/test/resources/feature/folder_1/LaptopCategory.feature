@smoke
Feature: Laptops Category Items

  Background:
    Given user open url "https://www.demoblaze.com/index.html"
    When user click on log in button
    And user enter username as "brand_new_user_94"
    And user enter password as "user123"
    Then user click on final login button

  Scenario: Verify all items under Laptops category
    When user click on "Laptops"
    Then user can view items under items as shown below:
      | Sony vaio i5        |
      | Sony vaio i7        |
      | MacBook air         |
      | Dell i7 8gb         |
      | 2017 Dell 15.6 Inch |
      | MacBook Pro         |
