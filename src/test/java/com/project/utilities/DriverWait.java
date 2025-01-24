package com.project.utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Objects;

public class DriverWait {
    private static WebDriverWait wait;
    public static void elementToBeVisible(WebElement element){
        wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void pageToBeLoaded() {
        wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(driver -> Objects.equals((String) ((JavascriptExecutor) driver)
                .executeScript("return document.readyState"), "complete"));
    }

    public static void elementToBeVisibleAndClickcable(WebElement element){
        wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element)).click();
    }
}
