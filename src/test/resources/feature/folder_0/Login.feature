Feature: Log in
  Background: Log in to "https://www.demoblaze.com/prod.html?idp_=1"
    Given user open url "https://www.demoblaze.com/index.html"
  @login
  Scenario: Log in as user
    When user click on log in button
    And user enter username as "brand_new_user_94"
    And user enter password as "user123"
    And user click on final login button
    Then user can see user name "brand_new_user_94" on dashboard
