package com.project.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/feature",
        glue = "com/project/step_definitions",
        dryRun = false,
        plugin = "html:target/full-report.html"
//        tags = "@smoke and @AddPhoneItems"
)
public class Cukes {
}
