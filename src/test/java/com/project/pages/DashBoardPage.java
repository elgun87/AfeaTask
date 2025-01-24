package com.project.pages;

import com.project.utilities.BrowserSleep;
import com.project.utilities.Driver;
import com.project.utilities.DriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DashBoardPage {
    public static Map<String,String> dashboar_items = new HashMap<>();

    public DashBoardPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    /**
     * Clicks on a category menu item by its link text.
     *
     * @param category The link text of the category to click on.
     * @TODO Improve handling of retries with a configurable retry limit or external logging.
     */
    public void click_on_category_menu(String category) {
        int attempts = 0; // Counter to track the number of attempts
        while (attempts < 3) { // Retry mechanism: allows up to 3 attempts
            try {
                // Locate the category menu element using the provided link text
                WebElement element = Driver.getDriver().findElement(By.linkText(category));

                // Wait for the element to be visible and clickable, then perform the action
                DriverWait.elementToBeVisibleAndClickcable(element);

                return; // Exit the method once the operation is successful
            } catch (StaleElementReferenceException e) {
                // Increment the attempt counter when a StaleElementReferenceException is caught
                attempts++;

                // If all 3 attempts fail, throw a RuntimeException with details
                if (attempts == 3) {
                    throw new RuntimeException("Failed to click on the category menu due to stale element exception: " + category, e);
                }
            }
        }
    }

    public boolean get_items_under_phone_category(List<String> items) {
        List<WebElement> allItems = Driver.getDriver().findElements(By.cssSelector("div#tbodyid a.hrefch"));
        for (int i = 0; i < allItems.size(); i++) {
            System.out.println(allItems.get(i).getText());
            if (!allItems.get(i).getText().equals(items.get(i))) {
                return false;
            }
        }
        return true;
    }

    //todo Add Item Steps
    @FindBy(css = "div#tbodyid h5")
    private List<WebElement> item_prices;

    @FindBy(css = "div#tbodyid h4")
    private List<WebElement> item_names;



    public Map<String, String> get_items_names_and_prices() {
        BrowserSleep.wait(2);
        for (int i = 0; i < item_names.size(); i++) {
            dashboar_items.put(item_names.get(i).getText(), item_prices.get(i).getText().replace("$",""));
        }
        for (Map.Entry each : dashboar_items.entrySet()) {
            System.out.println(each);
        }
        return dashboar_items;
    }

//    public void get_items_names_and_prices() {
//        // Wait for the elements to be visible (replace with your WebDriver wait logic)
//        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.visibilityOfAllElements(item_names));
//        wait.until(ExpectedConditions.visibilityOfAllElements(item_prices));
//
//        // Map to store item names and prices
//        Map<String, String> dashboardItems = new HashMap<>();
//
//        // Using streams for clean iteration
//        for (int i = 0; i < item_names.size(); i++) {
//            dashboar_items.put(
//                    item_names.get(i).getText(),
//                    item_prices.get(i).getText().replace("$", "")
//            );
//        }
//
//        // Log dashboard items
//        dashboar_items.forEach((name, price) ->
//                System.out.printf("Item: %s, Price: %s%n", name, price)
//        );
//
//    }

    public void add_all_items_to_cart() {
        // Open each item in a new tab
        for (WebElement element : item_names) {
            String controlKey = Keys.chord(Keys.CONTROL, Keys.ENTER);
            element.findElement(By.tagName("a")).sendKeys(controlKey);
        }

        String parentWindow = Driver.getDriver().getWindowHandle(); // Get the parent window handle

        for (String windowHandle : Driver.getDriver().getWindowHandles()) {
            if (!windowHandle.equals(parentWindow)) {
                Driver.getDriver().switchTo().window(windowHandle); // Switch to the new tab

                try {
                    DriverWait.pageToBeLoaded(); // Ensure the page is fully loaded

                    // Locate and click the "Add to cart" button
                    WebElement add_to_cart = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10))
                            .until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Add to cart')]")));
                    add_to_cart.click();

                    // Handle alert if present
                    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));
                    wait.until(ExpectedConditions.alertIsPresent()).accept();

                    Driver.getDriver().close(); // Close the child tab
                } catch (Exception e) {
                    System.err.println("Error while adding item to cart: " + e.getMessage());
                } finally {
                    Driver.getDriver().switchTo().window(parentWindow); // Switch back to the parent tab
                    DriverWait.pageToBeLoaded(); // Ensure the parent window is ready before the next iteration
                }
            }
        }
    }

    @FindBy(id = "cartur")
    private WebElement cart;

    public void clickCartButton(){
        BrowserSleep.wait(1);
        DriverWait.elementToBeVisible(cart);
        cart.click();
    }

}
