package com.android.automation.test.steps;

import com.android.automation.test.base.PageBaseObject;
import io.appium.java_client.MobileBy;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InviteFriendsSteps extends PageBaseObject {

    @When("user click Akun bottom navigation")
    public void userClickAkunBottomNavigation() {
        By CLICK_AKUN_BOTTOM_NAV = MobileBy.id("clickable_account");
        click(CLICK_AKUN_BOTTOM_NAV);
    }

    @And("user see the Ajak Teman Pakai Alfagift menu")
    public void userSeeAjakTemanPakaiAlfagiftMenu()
    {
        String text = "Ajak Teman Pakai Alfagift";
        driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))" + ".scrollIntoView(new UiSelector().text(\"" + text + "\"))"));
    }

    @And("user click the Ajak Teman Pakai Alfagift menu")
    public void userClickTheAjakTemanPakaiAlfagiftMenu()
    {
        driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().className(\"androidx.recyclerview.widget.RecyclerView\")" + ".instance(0).childSelector(new UiSelector().index(" + 4 + "))")).click();
    }

    @Given("user on the Ajak Teman page")
    public void userShouldSeeTheAjakTemanTitle()
    {
        By AJAK_TEMAN_TEXT = MobileBy.id("tvPageTitle");
        Assertions.assertEquals("Ajak Teman", driver.findElement(AJAK_TEMAN_TEXT).getText(), "User is not on Ajak Teman Page!");
    }

    @When("user copy the referral code")
    public void userCopyTheReferralCode()
    {
        By COPY_BUTTON = MobileBy.id("tv_copy_referral_code");
        waitUntilPresent(COPY_BUTTON);
        click(COPY_BUTTON);
    }

    @Then("user should have referral code copied on the clipboard")
    public void userShouldHaveCopied(){
        By REFERRAL_CODE_TEXT = MobileBy.id("tv_referral_code");
        Assertions.assertEquals(driver.findElement(REFERRAL_CODE_TEXT).getText(), driver.getClipboardText(), "Not copied!");
    }

    @When("user click the Ajak Teman Pakai Alfagift button")
    public void userClickTheAjakTemanPakaiAlfagiftButton()
    {
        By GENERATE_CODE_BUTTON = MobileBy.id("btn_generate_code");
        waitUntilPresent(GENERATE_CODE_BUTTON);
        click(GENERATE_CODE_BUTTON);
    }

    @Then("user should see sharing text")
    public void userShouldSeeSharingText()
    {
        By SHARING_TEXT = MobileBy.xpath("//android.widget.TextView[@resource-id=\"android:id/content_preview_text\"]");
        waitUntilPresent(SHARING_TEXT);
    }

    @When("user click the Cara Ajak Teman button")
    public void userClickCaraAjakTeman()
    {
        By CARA_AJAK_TEMAN_BUTTON = MobileBy.xpath("//android.widget.TextView[@text=\"Cara Ajak Teman\"]");
        click(CARA_AJAK_TEMAN_BUTTON);
    }

    @Then("user should see the Cara Ajak Teman bottom sheet")
    public void userShouldSeeTheCaraAjakTemanBottomSheet()
    {
        By CARA_AJAK_TEMAN_TEXT = MobileBy.xpath("//android.widget.TextView[@resource-id=\"com.alfamart.alfagift.beta:id/tv_title\" and @text=\"Cara Ajak Teman\"]");
        Assertions.assertEquals("Cara Ajak Teman", driver.findElement(CARA_AJAK_TEMAN_TEXT).getText(), "Bottom sheet not shown!");
    }

    @When("user click the Teman yang kamu ajak info button")
    public void userClickTheTemanYangKamuAjakInfoButton()
    {
//        By INVITEE_INFO_BUTTON = MobileBy.xpath("//android.widget.ImageView[@resource-id=\"com.alfamart.alfagift.beta:id/iv_info_invitee\"]");
        By INVITEE_INFO_BUTTON = MobileBy.id("iv_info_invitee");
        click(INVITEE_INFO_BUTTON);
    }

    @Then("user should see the Invitee info bottom sheet")
    public void userShouldSeeTheInviteeInfoBottomSheet()
    {
//        By INVITEE_BOTTOM_SHEET_HEADER = MobileBy.xpath("//android.widget.TextView[@resource-id=\"com.alfamart.alfagift.beta:id/tv_title\"]");
//        By INVITEE_BOTTOM_SHEET_DESC = MobileBy.xpath("//android.widget.TextView[@resource-id=\"com.alfamart.alfagift.beta:id/tv_desc\"]");

        By INVITEE_BOTTOM_SHEET_HEADER = MobileBy.id("tv_title");
        By INVITEE_BOTTOM_SHEET_DESC = MobileBy.id("tv_desc");

        String descBottomSheet = "Yang menggunakan kode referral kamu pada saat registrasi akan muncul di sini beserta jenis reward yang berlaku";

        Assertions.assertEquals("Info", driver.findElement(INVITEE_BOTTOM_SHEET_HEADER).getText(), "Bottom sheet not shown!");
        Assertions.assertEquals(descBottomSheet, driver.findElement(INVITEE_BOTTOM_SHEET_DESC).getText(), "Bottom sheet not shown!");
    }

    @When("user click the referral benefit detail button")
    public void userClickTheReferralBenefitDetailButton()
    {
        By REFERRAL_DETAIL_BUTTON = MobileBy.id("btn_see_detail");
        click(REFERRAL_DETAIL_BUTTON);
    }

    @Then("user should see the Syarat dan Ketentuan page")
    public void userShouldSeeTheSyaratDanKetentuanPage()
    {
        By SYARAT_DAN_KETENTUAN_HEADER = MobileBy.id("tv_title");
        Assertions.assertEquals("Syarat Ketentuan", driver.findElement(SYARAT_DAN_KETENTUAN_HEADER).getText(), "Syarat dan ketentuan not opened!");
    }

}
