package com.project.pages;

import com.project.utilities.BrowserSleep;
import com.project.utilities.Driver;
import com.project.utilities.DriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cart {
    public Cart() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//a[contains(text(),'Cart')]")
    private WebElement cart_btn;

    @FindBy(css = "tbody#tbodyid tr")
    private List<WebElement> cart_items;

    @FindBy(css = "tbody#tbodyid tr")
    private List<WebElement> cart_items_remove;

    public void click_on_cart_btn() {
        int attempts = 0; // Counter to track the number of attempts
        while (attempts < 3) { // Retry mechanism: allows up to 3 attempts
            try {

                // Wait for the element to be visible and clickable, then perform the action
                DriverWait.elementToBeVisibleAndClickcable(cart_btn);
                BrowserSleep.wait(2);
                return; // Exit the method once the operation is successful
            } catch (StaleElementReferenceException e) {
                // Increment the attempt counter when a StaleElementReferenceException is caught
                attempts++;

                // If all 3 attempts fail, throw a RuntimeException with details
                if (attempts == 3) {
                    throw new RuntimeException("Failed to click on the category menu due to stale element exception: " + cart_btn, e);
                }
            }
        }
    }

    public boolean verify_cart_items_price(){
        /**todo explanation of this method
        todo In the first loop I store cart items inside "cart_items_name_prices" data structure.
         */
        Map<String,String> cart_items_name_prices = new HashMap<>();
        DashBoardPage.dashboar_items = new HashMap<>();
        for(int i = 0;i < cart_items.size();i++){
            String name = cart_items.get(i).findElement(By.cssSelector("td:nth-child(2)")).getText();
            String price = cart_items.get(i).findElement(By.cssSelector("td:nth-child(3)")).getText();
            cart_items_name_prices.put(name,price);
        }
        /*
        todo In second loop I am verifying phone items price with cart items price to see if they are matching.
        todo if it is not matching then this method will return false
         */
        for(int i = 0; i < DashBoardPage.dashboar_items.size(); i++){
            if(!DashBoardPage.dashboar_items.get(i).equals(cart_items_name_prices.get(i))){
                System.out.println(DashBoardPage.dashboar_items.get(i));
                System.out.println(cart_items_name_prices.get(i));
                return false;
            }
        }
        return true;
    }
    public int remove_items_from_cart(){
       /*
       todo this method is removing items from the cart
        */
        System.out.println(cart_items.size());
        for(int i = 0;i < cart_items.size();i++){
            cart_items.get(i).findElement(By.cssSelector("tbody#tbodyid tr td:nth-child(4) a")).click();
            BrowserSleep.wait(5);
            i--;
        }
        return cart_items.size();
    }


}
