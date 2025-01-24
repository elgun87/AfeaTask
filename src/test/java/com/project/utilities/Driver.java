package com.project.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class Driver {
    private static WebDriver driver;
    public static WebDriver getDriver() {
        try {
            if (driver == null) {
                String driverType = ConfigurationReader.getProperty("driver").toLowerCase();

                switch (driverType) {
                    case "chrome":
                        driver = new ChromeDriver();
                        break;

                    case "firefox":
                        driver = new FirefoxDriver();
                        break;

                    case "headless-chrome":
                        ChromeOptions chromeOptions = new ChromeOptions();
                        chromeOptions.addArguments("--headless", "--disable-gpu", "--window-size=1920,1080");
                        driver = new ChromeDriver(chromeOptions);
                        break;

                    case "headless-firefox":
                        FirefoxOptions firefoxOptions = new FirefoxOptions();
                        firefoxOptions.addArguments("--headless", "--disable-gpu", "--window-size=1920,1080");
                        driver = new FirefoxDriver(firefoxOptions);
                        break;

                    default:
                        throw new IllegalArgumentException("Unsupported browser type: " + driverType);
                }

                // Additional driver configurations
                driver.manage().window().maximize();
            }
        } catch (Exception e) {
            System.err.println("Failed to initialize WebDriver: " + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException("WebDriver initialization failed.", e);
        }
        return driver;
    }

    public static void closeDriver(){
        if(driver != null){
           driver.close();
           driver = null;
        }
    }
}
