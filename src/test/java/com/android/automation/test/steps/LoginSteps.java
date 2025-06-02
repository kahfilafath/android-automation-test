package com.android.automation.test.steps;


import com.android.automation.test.base.PageBaseObject;
import io.appium.java_client.MobileBy;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

public class LoginSteps extends PageBaseObject{
    @Given("user open the Alfagift App")
    public void userOpenTheAlfagiftApp(){
    initialize();
    }

    @And("user click next button on Login screen")
    public void userClickNextButtonOnLoginScreen() {
        By BUTTON_CONTINUE = MobileBy.id("btnNext");
        click(BUTTON_CONTINUE);


    }
    @When("user input phone number {string} on Login screen")
    public void userInputPhoneNumberOnLoginScreen(String phoneNumber) {
        By INPUT_USERNAME = MobileBy.id("etPhonePontaNumber");
        input(INPUT_USERNAME, "0812858882277");
    }

    @And("user input password {string} on Login screen")
    public void userInputPasswordOnLoginScreen(String password) {
        By INPUT_PASSWORD = MobileBy.id("etPassword");
        input(INPUT_PASSWORD, password);
    }
    @And("user click Enter on Welcome screen")
    public void userClickEnterOnWelcomeScreen() {
        By BUTTON_ENTER = MobileBy.id("btn_login");
        click(BUTTON_ENTER);

    }

    @Then("user click Nanti on User Guide")
    public void userClickNantiOnUserGuide() {
        By BUTTON_LATER = MobileBy.id("btn_later");
        click(BUTTON_LATER);
    }



}



