package com.project.step_definitions;

import io.cucumber.java.en.When;

public class AddItem_Steps extends BaseClass{


    @When("user captures all items and add all items to the cart")
    public void user_captures_all_items_and_add_all_items_to_the_cart() {
        dashBoardPage.get_items_names_and_prices();
        dashBoardPage.add_all_items_to_cart();


    }

}
