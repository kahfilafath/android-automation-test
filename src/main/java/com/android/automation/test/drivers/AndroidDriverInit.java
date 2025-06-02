package com.android.automation.test.drivers;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AndroidDriverInit {

  @Value("${driver.mobile.android.capabilities.platformName}")
  private String platformName;
  @Value("${driver.mobile.android.capabilities.deviceName}")
  private String deviceName;
  @Value("${driver.mobile.android.capabilities.udid}")
  private String udid;
  @Value("${driver.mobile.android.capabilities.app}")
  private String app;
  @Value("${driver.mobile.android.capabilities.automationName}")
  private String automationName;
  @Value("${driver.mobile.android.capabilities.newCommandTimeout}")
  private Integer newCommandTimeout;
  @Value("${driver.mobile.android.capabilities.autoGrantPermissions}")
  private Boolean autoGrantPermissions;
  @Value("${driver.mobile.android.capabilities.noReset}")
  private Boolean noReset;
  @Value("${driver.mobile.android.appiumUrl}")
  private String appiumUrl;
  @Value("${driver.mobile.android.capabilities.chromeDriverExecutable1}")
  private String chromeDriverExecutable1;

  @Value("${driver.mobile.android.capabilities.chromeDriverExecutable2}")
  private String chromeDriverExecutable2;

  @Value("${driver.mobile.android.capabilities.appPackage}")
  private String appPackage;
  @Value("${driver.mobile.android.capabilities.appActivity}")
  private String activity;

  public static AndroidDriver<AndroidElement> driver;
  public void initialize(){
    //desired capabilities
    DesiredCapabilities caps = new DesiredCapabilities();
    caps.setCapability(MobileCapabilityType.PLATFORM_NAME, this.platformName);
    caps.setCapability(MobileCapabilityType.DEVICE_NAME, this.deviceName);
    caps.setCapability(MobileCapabilityType.UDID, this.udid);
    caps.setCapability(MobileCapabilityType.APP, this.app);
    caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, this.automationName);
    //additional
    caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 120);
    caps.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, this.autoGrantPermissions);
    caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,this.appPackage);
    caps.setCapability("appActivity", this.activity);

    //inisialisasi appium
    //AndroidDriver<AndroidElement> driver = null;
    try {
      driver = new AndroidDriver<>(new URL(this.appiumUrl), caps);
    } catch (MalformedURLException e) {
      e.printStackTrace();
    }

    //implict wait
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
  }

  public static void quit(){
    //delay
    try {
      Thread.sleep(5000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    //quit
    driver.quit();
  }

}
