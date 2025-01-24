@smoke
Feature: Phone Category Items
  Background:
    Given user open url "https://www.demoblaze.com/index.html"
    When user click on log in button
    And user enter username as "brand_new_user_94"
    And user enter password as "user123"
    Then user click on final login button

  Scenario: Verify all items under Phone category
    When user click on "Phones"
    Then user can view items under items as shown below:
      | Samsung galaxy s6 |
      | Nokia lumia 1520  |
      | Nexus 6           |
      | Samsung galaxy s7 |
      | Iphone 6 32gb     |
      | Sony xperia z5    |
      | HTC One M9        |
