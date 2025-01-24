package com.project.step_definitions;

import com.project.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


public class Hookes {
    @Before
    public void setDriver(){
        Driver.getDriver();
    }
    @After()
    public void tearDown(Scenario scenario){
        if(scenario.isFailed()){
            byte [] screenShots = ((TakesScreenshot)Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenShots,"image/png",scenario.getName());
        }
        Driver.closeDriver();
    }

}
