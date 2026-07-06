package com.android.automation.test.steps;


import com.android.automation.test.base.PageBaseObject;
import io.appium.java_client.MobileBy;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebElement;

import java.util.List;
import java.util.stream.Collectors;

public class EserviceSteps extends PageBaseObject{

    @Given("user on the HomePage")
    public void userOnTheHomePage() {
        By HOMESCREEN = MobileBy.id("edt_search");
        Assertions.assertTrue(isDisplayed(HOMESCREEN));
    }

    @And("user click e-service menu")
    public void userClickEserviceMenu() {
        By BUTTON_ESERVICE = MobileBy.xpath("(//android.widget.ImageView[@resource-id=\"com.alfamart.alfagift.beta:id/iv_mini_banner\"])[4]");
        waitUntilPresent(BUTTON_ESERVICE);
        click(BUTTON_ESERVICE);
    }

    @And("user click pulsa menu")
    public void userClickPulsaMenu() {
        By BUTTON_PULSA = MobileBy.xpath("//android.widget.TextView[@resource-id=\"com.alfamart.alfagift.beta:id/tv_mini_name\" and @text=\"Pulsa\"]");
        waitUntilPresent(BUTTON_PULSA);
        click(BUTTON_PULSA);
    }

    @Given("user on the e-service menu")
    public void userOnTheEserviceMenu() {
        By ESERVICEMENU = MobileBy.xpath("//android.widget.EditText[@resource-id=\"com.alfamart.alfagift.beta:id/edt_search\"]");
        Assertions.assertTrue(isDisplayed(ESERVICEMENU));
    }

    @When("user should see phone number")
    public void validateInputPhoneNumberOnEservice() {
        By OUTPUT_PHONENUMBER = MobileBy.id("com.alfamart.alfagift.beta:id/et_search");
        waitUntilPresent(OUTPUT_PHONENUMBER);
        Assertions.assertTrue(isDisplayed(OUTPUT_PHONENUMBER));
    }

//    @Then("user click Oke on User Guide")
//    public void userClickOkeOnUserGuide() {
//        By BUTTON_OKE = MobileBy.xpath("//android.widget.TextView[@resource-id=\"com.alfamart.alfagift.beta:id/buttonNext\"]");
//        click(BUTTON_OKE);
//    }

    @When("user should see user phone number provider")
    public void validatePhoneNumberProviderOnEservice() {
        By LABEL_PROVIDER = MobileBy.id("com.alfamart.alfagift.beta:id/txt_name_provider");
//        waitUntilPresent(OUTPUT_PHONENUMBER);
        Assertions.assertTrue(isDisplayed(LABEL_PROVIDER));
    }

    @Then("user should discover pulsa product")
    public void userShouldDiscoverPulsaProduct() {
        By LABEL_PRODUCT_PULSA = MobileBy.xpath("//android.widget.TextView[@resource-id=\"com.alfamart.alfagift.beta:id/txt_name\" and @text=\"Telkomsel Pulsa 10.000\"]");
        Assertions.assertTrue(isDisplayed(LABEL_PRODUCT_PULSA));
    }

    @And("user click pulsa product")
    public void userClickPulsaProduct() {
        By LABEL_PRODUCT_PULSA = MobileBy.xpath("//android.widget.TextView[@resource-id=\"com.alfamart.alfagift.beta:id/txt_name\" and @text=\"Telkomsel Pulsa 10.000\"]");
        waitUntilPresent(LABEL_PRODUCT_PULSA);
        click(LABEL_PRODUCT_PULSA);
    }

    @Then("user should see ATC button")
    public void userATCPulsaProduct() {
        By LABEL_ATC_PULSA = MobileBy.xpath("//android.widget.TextView[@resource-id=\"com.alfamart.alfagift.beta:id/tv_title\"]");
        Assertions.assertTrue(isDisplayed(LABEL_ATC_PULSA));
    }

    @Then("user should not see ATC button")
    public void userCancelATCPulsaProduct() {
        By LABEL_ATC_PULSA = MobileBy.xpath("//android.widget.TextView[@resource-id=\"com.alfamart.alfagift.beta:id/tv_title\"]");
        Assertions.assertFalse(isDisplayed(LABEL_ATC_PULSA));
    }
}



