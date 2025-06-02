package com.android.automation.test;

import com.android.automation.test.base.PageBaseObject;

public class AppiumTest extends PageBaseObject {
/*
  public AndroidDriver<AndroidElement> androidDriverInit() {
    DesiredCapabilities caps = new DesiredCapabilities();
    caps.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
    caps.setCapability(MobileCapabilityType.DEVICE_NAME, "device");
    caps.setCapability(MobileCapabilityType.UDID, "emulator-5554");
    caps.setCapability(MobileCapabilityType.APP, "D://app/app.apk");
    caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UIAutomator2");
    caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 120);
    caps.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true);
    caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.alfamart.alfagift.debug");

    //url appium
    String url = "http://127.0.0.1:4723";
    //initialize appium
    AndroidDriver<AndroidElement> driver = null;
    try {
      driver = new AndroidDriver<>(new URL(url), caps);

    } catch (MalformedURLException e) {
      e.printStackTrace();
    }
    //implicitly wait
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    return driver;
  }

  @Test
  public void verifyWelcomeScreenIsWellDisplayedAfterLaunchedApp() {
    //call driver method to create session (mandatory step to run automation)
    //AndroidDriver<AndroidElement> driver = androidDriverInit();
    initialize();
    //Initialize locators & find the element on the welcome screen
    By IMG_ALFAMART = MobileBy.id("iv_logo");
    //AndroidElement findAlfaImage = driver.findElement(IMG_ALFAMART);
    By BUTTON_PROMO = MobileBy.id("btn_promo");
    //AndroidElement findButtonPromo = driver.findElement(BUTTON_PROMO);
    By BUTTON_STORE = MobileBy.id("btn_store");
    //AndroidElement findStoreBtn = driver.findElement(BUTTON_STORE);
    By LABEL_WELCOME_SCREEN = MobileBy.id("txt_title");
    //AndroidElement findWelcomeScreen = driver.findElement(LABEL_WELCOME_SCREEN);

    //call the methods to perform action & verify the acceptance criteria on the welcome screen
    //boolean imgAlfaDisplayed = findAlfaImage.isDisplayed();
    Assertions.assertTrue(isDisplayed(IMG_ALFAMART), "Alfamart icon is not exist!");

    //boolean btnPromoDisplayed = findButtonPromo.isDisplayed();
    Assertions.assertTrue(isDisplayed(BUTTON_PROMO), "Button Promo is not exist!");

    Assertions.assertTrue(isDisplayed(BUTTON_STORE), "Button Store is not exist!");
    Assertions.assertEquals("Selamat Datang di Alfagift!", getText(LABEL_WELCOME_SCREEN),
        "Format Greeting Salah!");

  }

  //Sample test using Page Object Model (design pattern that create object repository to store all elements)
  @Test
  public void loginWithValidData() {
    //call driver method to create session (mandatory step to run automation)
    initialize();
    //click enter to go to login screen
    By BUTTON_ENTER = MobileBy.id("btn_login");
    click(BUTTON_ENTER);

    //input username
    By INPUT_USERNAME = MobileBy.id("etPhonePontaNumber");
    input(INPUT_USERNAME, "0812858882277");

    //input password
    By INPUT_PASSWORD = MobileBy.id("etPassword");
    input(INPUT_PASSWORD, "12345678");

    //click continue
    By BUTTON_CONTINUE = MobileBy.id("btnNext");
    click(BUTTON_CONTINUE);

    //verify user successfully enter to home page
    By LABEL_WELCOME_SCREEN = MobileBy.id("tv_title");
    Assertions.assertEquals("Selamat Datang di Alfagift",getText(LABEL_WELCOME_SCREEN),"Failed to go to Home Page!");

  }

 */


}
