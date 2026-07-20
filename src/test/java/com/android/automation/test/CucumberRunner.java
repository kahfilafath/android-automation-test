package com.android.automation.test;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;

  @RunWith(Cucumber.class)
  @CucumberOptions(
      glue = {"com/android/automation/test"},
      plugin = {"json:build/cucumber.json", "pretty", "html:build/result.html"},
      features = "src/test/resources/features",
      stepNotifications = true,
      tags = "",
      publish = true
  )
  public class CucumberRunner extends AbstractTestNGCucumberTests {

  }


