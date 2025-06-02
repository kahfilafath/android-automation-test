package com.android.automation.test.pages;

import com.android.automation.test.base.PageBaseObject;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

public class Training extends PageBaseObject {


  public void loginWithValidData(){
    //call welcome screen
    //verifyWelcomeScreenIsWellDisplayedAfterLaunchedApp();

    //click enter to go to login screen
    By BUTTON_ENTER = MobileBy.id("com.alfamart.alfagift.debug:id/btn_login");
    //driver.findElement(BUTTON_ENTER).click();
    click(BUTTON_ENTER);

    //input username
    By INPUT_USERNAME = MobileBy.id("com.alfamart.alfagift.debug:id/etPhonePontaNumber");
    /*AndroidElement findUsername = driver.findElement(INPUT_USERNAME);
    findUsername.clear();
    findUsername.sendKeys("0812858882277");
     */
    input(INPUT_USERNAME,"0812858882277");

    //input password
    By INPUT_PASSWORD = MobileBy.id("com.alfamart.alfagift.debug:id/etPassword");
    input(INPUT_PASSWORD,"12345678");
    /*AndroidElement findPassword = driver.findElement(INPUT_PASSWORD);
    findPassword.clear();
    findPassword.sendKeys("12345678");

     */

    //click continue
    By BUTTON_CONTINUE = MobileBy.id("com.alfamart.alfagift.debug:id/btnNext");
    click(BUTTON_CONTINUE);
    //driver.findElement(BUTTON_CONTINUE).click();

  }


}
