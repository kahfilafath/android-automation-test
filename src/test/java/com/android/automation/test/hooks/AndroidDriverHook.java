package com.android.automation.test.hooks;

import com.android.automation.test.AppiumTest;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class AndroidDriverHook {

  public static AndroidDriver<AndroidElement> driver;

  @Before
  public void startSession() {
    AppiumTest appiumTest = new AppiumTest();
    driver = appiumTest.androidDriverInit();
  }

  @After
  public void stopSession() {
    if (driver != null) {
      driver.quit();
    }
  }
}