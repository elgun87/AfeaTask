package com.project.step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class Cart_Steps extends BaseClass{
    @And("user click on cart button")
    public void userClickOnCartButton() {
        cart.click_on_cart_btn();
    }

    @Then("verify all added phone item price one by one")
    public void verifyAllAddedPhoneItemPriceOneByOne() {
        boolean flag = cart.verify_cart_items_price();
        Assert.assertTrue("Phone items price does not match Cart items price",flag);
    }

    @Then("remove all items")
    public void removeAllItems() {
        int size = cart.remove_items_from_cart();
        Assert.assertEquals("Cart items count is not zero", 0, size);
    }
}
