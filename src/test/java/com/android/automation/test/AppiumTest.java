package com.android.automation.test;

import com.android.automation.test.base.PageBaseObject;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AppiumTest extends PageBaseObject {

    public static AndroidDriver<AndroidElement> driver;

    public void androidDriverInit() {
    DesiredCapabilities caps = new DesiredCapabilities();
    caps.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
    caps.setCapability(MobileCapabilityType.DEVICE_NAME, "device");
    caps.setCapability(MobileCapabilityType.UDID, "RR8N105E8XJ");
    caps.setCapability(MobileCapabilityType.APP, "D://app/app-training.apk");
    caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UIAutomator2");
    caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 120);
    caps.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true);
    caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.alfamart.alfagift.beta");
    caps.setCapability("appActivity", "com.alfamart.alfagift.screen.splash.SplashActivity");
    caps.setCapability("appium:enforceXPath1",true);

    //url appium
    String url = "http://127.0.0.1:4723";
    //initialize appium
    try {
        driver = new AndroidDriver<>(new URL(url), caps);

    } catch (MalformedURLException e) {
      e.printStackTrace();
    }
    //implicitly wait
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }


  //Sample test
  @Test
  public void loginWithValidData() {
    //call driver method to create session (mandatory step to run automation)
    androidDriverInit();
    //input username
    By INPUT_USERNAME = MobileBy.xpath("//android.widget.EditText");
    By BUTTON_NEXT = MobileBy.xpath("//android.widget.TextView[@text='Masuk/Daftar']/following-sibling::android.widget.Button");
    driver.findElement(INPUT_USERNAME).sendKeys("0812858882277");
    driver.findElement(BUTTON_NEXT).click();
  }

//  @Test
//    public void verifyIconAlfamartOnSignInScreen()
//  {
//      androidDriverInit();
//
//      WebDriverWait wait = new WebDriverWait(driver, 15);
//      By ICON_ALFAMART = MobileBy.xpath("//android.widget.TextView[@text='Promo']/preceding::android.widget.ImageView");
//      wait.until(ExpectedConditions.visibilityOfElementLocated(ICON_ALFAMART));
//      Assertions.assertTrue(driver.findElement(ICON_ALFAMART).isDisplayed(), "Alfamart Icon is not displayed!");
//
//  }

  @Test
    public void verifyUserShouldBeLandedIntoStoreScreen()
  {
      androidDriverInit();
      System.out.print(driver.getClipboardText());
      By ICON_TOKO = MobileBy.xpath("//android.widget.TextView[@text='Toko']/following-sibling::android.widget.Button");
      driver.findElement(ICON_TOKO).click();

      By LABEL_TOKO_TERDEKAT = MobileBy.id("com.alfamart.alfagift.beta:id/tv_page_title");
      String getLabelStore = driver.findElement(LABEL_TOKO_TERDEKAT).getText();

      System.out.println(getLabelStore);
      Assertions.assertEquals("Toko Terdekat", getLabelStore, "User is not on Toko Tedekat");
  }
}


