package com.project.step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Login_Steps extends BaseClass{

    @When("user click on log in button")
    public void user_click_on_log_in_button() {
        loginPage.click_on_login();
    }

    @When("user enter username as {string}")
    public void user_enter_username_as(String username) {
        loginPage.enter_username(username);
    }

    @When("user enter password as {string}")
    public void user_enter_password_as(String password) {
        loginPage.enter_password(password);
    }

    @And("user click on final login button")
    public void userEnterFinalLoginButton() {
        loginPage.click_on_final_login_btn();
    }

    @Then("user can see user name {string} on dashboard")
    public void userCanSeeUserNameOnDashboard(String actual) {
        String expected = loginPage.verify_user_access();
        Assert.assertTrue("Expected result does not match actual result", expected.contains(actual));
    }

}
