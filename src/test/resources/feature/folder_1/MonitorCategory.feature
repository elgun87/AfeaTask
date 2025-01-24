@smoke
Feature: Monitors Category Items

  Background:
    Given user open url "https://www.demoblaze.com/index.html"
    When user click on log in button
    And user enter username as "brand_new_user_94"
    And user enter password as "user123"
    Then user click on final login button

  Scenario: Verify all items under Monitors category
    When user click on "Monitors"
    Then user can view items under items as shown below:
      | Apple monitor 24 |
      | ASUS Full HD     |

