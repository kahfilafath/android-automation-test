package com.android.automation.test;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"com.android.automation.test.steps", "com.android.automation.test.hooks"}, 
        plugin = {
                "pretty",
                "json:build/cucumber.json",
                "html:build/cucumber-html-report.html"
        },
        tags = "@FullCycleRollout"
)
public class CucumberRunner {
}