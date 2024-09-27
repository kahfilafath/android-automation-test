package com.android.automation.training;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;

  @RunWith(Cucumber.class)
  @CucumberOptions(
      glue = {"com/android/automation/training"},
      plugin = {"json:build/cucumber.json","json:target/cucumber.json", "pretty", "html:build/result.html"},
      features = "src/test/resources/features",
      stepNotifications = true,
      tags = "@TC001",
      publish = true
  )
  public class CucumberRunner extends AbstractTestNGCucumberTests {

  }


