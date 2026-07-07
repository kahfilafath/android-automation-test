package com.android.automation.test.steps;

import com.android.automation.test.hooks.AndroidDriverHook;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginSteps {

    private AndroidDriver<AndroidElement> driver;
    private WebDriverWait wait;
    private Actions actions;

    public LoginSteps() {
        this.driver = AndroidDriverHook.driver;
        this.wait = new WebDriverWait(this.driver, 25);
        this.actions = new Actions(this.driver);
    }

    private final By FIELD_INPUT_PHONE_SECURE = MobileBy.xpath(
            "//android.widget.EditText[./android.widget.TextView[contains(@text, 'Handphone')]] | " +
                    "//*[contains(@text, 'Handphone') or contains(@text, 'Member')]/parent::android.widget.EditText"
    );

    private final By BUTTON_NANTI_NATIVE = MobileBy.id("com.alfamart.alfagift.beta:id/btn_later");

    private final By FIELD_INPUT_PASSWORD_SECURE = MobileBy.xpath(
            "//android.widget.EditText | //*[contains(@text, 'Sandi') or contains(@text, 'Password')]/parent::android.widget.EditText"
    );

    // FIX UTAMA
    private final By TEXT_MASUK_ELEMENT = MobileBy.xpath(
            "(//android.widget.TextView[@text='Masuk/Daftar' or @text='Masuk' or @text='Lanjut' or contains(@text, 'Masuk')])[last()]"
    );

    private final By HOMEPAGE_MARKER = MobileBy.id("com.alfamart.alfagift.beta:id/clickable_search");

    @Given("user opens Alfagift Beta application")
    public void userOpensAlfagiftBetaApplication() {
        System.out.println("Memulai inisialisasi pengujian FCR Login.");
    }

    @When("user inputs phone number {string}")
    public void userInputsPhoneNumber(String phone) {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(FIELD_INPUT_PHONE_SECURE));
            AndroidElement phoneField = (AndroidElement) driver.findElement(FIELD_INPUT_PHONE_SECURE);

            phoneField.click();
            Thread.sleep(1000);

            phoneField.clear();
            Thread.sleep(500);

            phoneField.sendKeys(phone);
            System.out.println("Nomor HP tersuntik ke dalam field.");
            Thread.sleep(1000);

            try {
                driver.hideKeyboard();
                System.out.println("Soft-keyboard ditutup.");
            } catch (Exception e) {
                phoneField.sendKeys("\n");
            }
            Thread.sleep(1500);

            wait.until(ExpectedConditions.presenceOfElementLocated(TEXT_MASUK_ELEMENT));
            WebElement masukTextBtn = driver.findElement(TEXT_MASUK_ELEMENT);

            actions.moveToElement(masukTextBtn).click().perform();
            System.out.println("W3C Actions berhasil mengeklik Tombol Tahap 1.");

            Thread.sleep(5000);

        } catch (Exception e) {
            System.out.println("Gagal mengeklik tombol Masuk tahap 1.");
            e.printStackTrace();
        }
    }

    @When("user inputs valid password {string}")
    public void userInputsValidPassword(String password) {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(FIELD_INPUT_PASSWORD_SECURE));
            AndroidElement passwordField = (AndroidElement) driver.findElement(FIELD_INPUT_PASSWORD_SECURE);

            passwordField.click();
            Thread.sleep(1000);
            passwordField.clear();
            Thread.sleep(500);

            passwordField.sendKeys(password);
            System.out.println("Password tersuntik ke dalam field.");
            Thread.sleep(1000);

            try {
                driver.hideKeyboard();
                System.out.println("Soft-keyboard ditutup di halaman password.");
            } catch (Exception e) {
                passwordField.sendKeys("\n");
            }
            Thread.sleep(2000);

            wait.until(ExpectedConditions.presenceOfElementLocated(TEXT_MASUK_ELEMENT));
            WebElement masukTextBtnFinal = driver.findElement(TEXT_MASUK_ELEMENT);

            actions.moveToElement(masukTextBtnFinal).click().perform();
            System.out.println("W3C Actions berhasil mengeklik Tombol Login Final.");

            Thread.sleep(7000);

        } catch (Exception e) {
            System.out.println("Gagal mengeklik tombol login tahap akhir.");
            e.printStackTrace();
        }
    }

    @Then("user should be successfully redirected to homepage")
    public void userShouldBeSuccessfullyRedirectedToHomepage() {
        System.out.println("Mendeteksi transisi menuju beranda...");

        try {
            WebDriverWait shortWait = new WebDriverWait(driver, 5);
            shortWait.until(ExpectedConditions.presenceOfElementLocated(BUTTON_NANTI_NATIVE));
            driver.findElement(BUTTON_NANTI_NATIVE).click();
            System.out.println("Bypass Berhasil di LoginSteps: Tombol 'Nanti' diklik.");
            Thread.sleep(3000);
        } catch (Exception e) {
            System.out.println("Info: Bottom sheet tidak mengadang atau sudah hilang.");
        }

        System.out.println("Menunggu komponen utama beranda termuat sempurna...");
        wait.until(ExpectedConditions.presenceOfElementLocated(HOMEPAGE_MARKER));
        System.out.println("Sukses Besar! Beranda terdeteksi dan siap digunakan.");
    }
}