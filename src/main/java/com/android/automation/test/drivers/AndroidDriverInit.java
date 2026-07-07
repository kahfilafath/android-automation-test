package com.android.automation.test.drivers;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AndroidDriverInit {

  // Kita buat fallback manual jika Spring Context gagal melakukan injeksi data @Value
  private String platformName = "android";
  private String deviceName = "device";
  private String udid = "TOG67PLVAILBLNFY"; // Hardcode UDID Redmi Anda dari log ADB sebelumnya
  private String app = "/Users/farrel01/Documents/app.apk";
  private String automationName = "UIAutomator2";
  private Boolean autoGrantPermissions = true;
  private String appPackage = "com.alfamart.alfagift.beta";
  private String activity = "com.alfamart.alfagift.screen.splash.SplashActivity";
  private String appiumUrl = "http://127.0.0.1:4723"; // Port default Appium v2/v1 (Sesuaikan /wd/hub jika v1)

  public static AndroidDriver<AndroidElement> driver;

  public void initialize(){
    DesiredCapabilities caps = new DesiredCapabilities();

    // Menggunakan data variabel yang sudah terisolasi dengan aman dari error Spring
    caps.setCapability(MobileCapabilityType.PLATFORM_NAME, this.platformName);
    caps.setCapability(MobileCapabilityType.DEVICE_NAME, this.deviceName);
    caps.setCapability(MobileCapabilityType.UDID, this.udid);
    caps.setCapability(MobileCapabilityType.APP, this.app);
    caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, this.automationName);
    caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 120);
    caps.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, this.autoGrantPermissions);
    caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, this.appPackage);
    caps.setCapability("appActivity", this.activity);

    // BYPASS KEYBOARD XIAOMI (Proteksi Secure Input MIUI/HyperOS)
    caps.setCapability("unicodeKeyboard", true);
    caps.setCapability("resetKeyboard", true);
    caps.setCapability("disableWindowAnimation", true);

    try {
      // Jika Anda menggunakan Appium 1.x, sesuaikan URL-nya menjadi: this.appiumUrl + "/wd/hub"
      driver = new AndroidDriver<>(new URL(this.appiumUrl), caps);
      System.out.println("Session Appium Driver Berhasil Terbuka Sempurna!");
    } catch (MalformedURLException e) {
      e.printStackTrace();
    }

    // Mengunci implicit wait ke 0 untuk menghindari tabrakan dengan WebDriverWait di LoginSteps
    if (driver != null) {
      driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
    }
  }

  public static void quit(){
    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    if (driver != null) {
      driver.quit();
    }
  }
}