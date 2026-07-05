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
    caps.setCapability(MobileCapabilityType.UDID, "emulator-5554");
    caps.setCapability(MobileCapabilityType.APP, "//Users/user/Documents/app/app.apk");
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
//  @Test
//  public void loginWithValidData() {
//    //call driver method to create session (mandatory step to run automation)
//    androidDriverInit();
//    //input username
//    By INPUT_USERNAME = MobileBy.xpath("//android.widget.EditText");
//    By BUTTON_NEXT = MobileBy.xpath("//android.widget.TextView[@text='Masuk/Daftar']/following-sibling::android.widget.Button");
//    driver.findElement(INPUT_USERNAME).sendKeys("0812858882277");
//    driver.findElement(BUTTON_NEXT).click();
//
//  }

// @Test
//    public void verifyAlfamartIcon(){
//        androidDriverInit();
//        WebDriverWait wait = new WebDriverWait(driver, 15);
//        By icon_alfamart = MobileBy.xpath("//android.widget.TextView[@text='Promo']/preceding::android.widget.ImageView");
//        wait.until(ExpectedConditions.visibilityOfElementLocated(icon_alfamart));
//        driver.findElement(icon_alfamart).isDisplayed();
//        Assert.assertTrue("Icon Alfamart is not displayed", driver.findElement(icon_alfamart).isDisplayed());
//        System.out.println("Hidup Jokowi");
// }

@Test
    public void verifyToko(){
        androidDriverInit();
        By icon_toko = MobileBy.xpath("//android.widget.TextView[@text='Toko']/following-sibling::android.widget.Button");
        By LABEL_STORE_SCREEN = MobileBy.id("com.alfamart.alfagift.beta:id/tv_page_title");
        driver.findElement(icon_toko).click();
        String getLabelStore = driver.findElement(LABEL_STORE_SCREEN).getText();
        driver.findElement(LABEL_STORE_SCREEN).click();
        Assertions.assertEquals("Toko Terdekat", getLabelStore, "User is not in STORE SCREEN");
        System.out.println(getLabelStore);
}
}
