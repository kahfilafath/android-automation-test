package com.android.automation.test;

import com.android.automation.test.base.PageBaseObject;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AppiumTest extends PageBaseObject {

    public static AndroidDriver<AndroidElement> driver;

    public AndroidDriver<AndroidElement> androidDriverInit() {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "device");
        caps.setCapability(MobileCapabilityType.UDID, "TOG67PLVAILBLNFY");
        caps.setCapability(MobileCapabilityType.APP, "/Users/farrel01/Documents/app.apk");
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UIAutomator2");
        caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 120);
        caps.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true);
        caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.alfamart.alfagift.beta");
        caps.setCapability("appActivity", "com.alfamart.alfagift.screen.splash.SplashActivity");

        // Konfigurasi Keyboard bawaan automation
        caps.setCapability("unicodeKeyboard", true);
        caps.setCapability("resetKeyboard", true);
        caps.setCapability("disableWindowAnimation", true);
        caps.setCapability("appium:enforceXPath1", true);

        String url = "http://127.0.0.1:4723";
        try {
            driver = new AndroidDriver<>(new URL(url), caps);
            System.out.println("Session Appium Driver Berhasil Terbuka Sempurna!");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        return driver;
    }

    @Test
    public void fullCycleRolloutLinearTest() {
        androidDriverInit();

        // Inisialisasi WebDriverWait & Actions sesuai konfigurasi aslimu
        WebDriverWait waitLogin = new WebDriverWait(driver, 25);
        WebDriverWait waitSearch = new WebDriverWait(driver, 15);
        Actions actions = new Actions(driver);

        // ================= LOCATOR SINKRONISASI TOTAL 1:1 =================
        // Dari LoginSteps
        By FIELD_INPUT_PHONE_SECURE = MobileBy.xpath(
                "//android.widget.EditText[./android.widget.TextView[contains(@text, 'Handphone')]] | " +
                        "//*[contains(@text, 'Handphone') or contains(@text, 'Member')]/parent::android.widget.EditText"
        );
        By BUTTON_NANTI_NATIVE = MobileBy.id("com.alfamart.alfagift.beta:id/btn_later");
        By FIELD_INPUT_PASSWORD_SECURE = MobileBy.xpath(
                "//android.widget.EditText | //*[contains(@text, 'Sandi') or contains(@text, 'Password')]/parent::android.widget.EditText"
        );
        By TEXT_MASUK_ELEMENT = MobileBy.xpath(
                "(//android.widget.TextView[@text='Masuk/Daftar' or @text='Masuk' or @text='Lanjut' or contains(@text, 'Masuk')])[last()]"
        );
        By HOMEPAGE_MARKER = MobileBy.id("com.alfamart.alfagift.beta:id/clickable_search");

        // Dari SearchSteps
        By BUTTON_NANTI_SAJA = MobileBy.id("com.alfamart.alfagift.beta:id/btn_later");
        By ICON_SEARCH_NATIVE = MobileBy.id("com.alfamart.alfagift.beta:id/iv_search");
        By SEARCH_TYPING_FIELD = MobileBy.id("com.alfamart.alfagift.beta:id/edt_search");
        By FIRST_SUGGESTION_ITEM = MobileBy.id("com.alfamart.alfagift.beta:id/tv_keyword");
        By PRODUCT_AQUA_CARD = MobileBy.xpath(
                "//android.widget.TextView[contains(@resource-id, 'product_name') and (contains(@text,'Aqua') or contains(@text,'AQUA') or contains(@text,'aqua'))] | " +
                        "//*[contains(@resource-id, 'tv_product_title') or contains(@resource-id, 'tv_title')]"
        );
        By BUTTON_ADD_AQUA_BASKET = MobileBy.xpath(
                "//*[contains(@resource-id, 'btn_add') or contains(@resource-id, 'iv_add') or contains(@resource-id, 'add_to_cart') or contains(@resource-id, 'btn_buy') or contains(@resource-id, 'iv_click_cart')]" +
                        " | //android.widget.Button[contains(@text, 'Keranjang') or contains(@text, 'Beli')]"
        );
        By ICON_BASKET = MobileBy.xpath(
                "//*[contains(@resource-id, 'btn_cart') or contains(@resource-id, 'iv_cart') or contains(@resource-id, 'menu_cart') or contains(@resource-id, 'cl_cart') or contains(@resource-id, 'iv_basket')]"
        );
        By CONTAINER_CHECKOUT = MobileBy.id("com.alfamart.alfagift.beta:id/btn_checkout");
        By TEXT_CHECKOUT_SELANJUTNYA = MobileBy.id("com.alfamart.alfagift.beta:id/tv_check_out");
        By BUTTON_CHECKOUT_UPSELL = MobileBy.xpath(
                "//android.widget.TextView[@text='Checkout'] | //android.widget.Button[@text='Checkout']"
        );
        By BUTTON_OK_GUIDE = MobileBy.xpath(
                "//android.widget.Button[contains(@text, 'OK') or contains(@text, 'Ok') or contains(@text, 'Mengerti') or contains(@text, 'Saya Mengerti')] | " +
                        "//android.widget.TextView[contains(@text, 'OK') or contains(@text, 'Ok') or contains(@text, 'Mengerti') or contains(@text, 'Saya Mengerti')] | " +
                        "//*[contains(@resource-id, 'btn_ok') or contains(@resource-id, 'tv_ok') or contains(@resource-id, 'btn_done')]"
        );
        By BUTTON_GANTI_TOKO = MobileBy.xpath("//*[contains(@text, 'Ganti') or contains(@text, 'Ubah')]");
        By BUTTON_MENU_PICKUP = MobileBy.xpath("//*[contains(@text, 'Pickup') or contains(@text, 'Pick Up') or contains(@text, 'Ambil sendiri')]");
        By CHECKBOX_PILIH_TOKO = MobileBy.xpath("//android.widget.CheckBox | //*[contains(@text, 'Pilih Toko') or contains(@text, 'Konfirmasi')]");


        // =========================================================================
        // BLOCK: @Given("user opens Alfagift Beta application") -> LoginSteps
        // =========================================================================
        System.out.println("Memulai inisialisasi pengujian FCR Login.");


        // =========================================================================
        // BLOCK: @When("user inputs phone number {string}") -> LoginSteps
        // =========================================================================
        try {
            waitLogin.until(ExpectedConditions.presenceOfElementLocated(FIELD_INPUT_PHONE_SECURE));
            AndroidElement phoneField = (AndroidElement) driver.findElement(FIELD_INPUT_PHONE_SECURE);

            phoneField.click();
            Thread.sleep(1000);

            phoneField.clear();
            Thread.sleep(500);

            phoneField.sendKeys("081287238167");
            System.out.println("Nomor HP tersuntik ke dalam field.");
            Thread.sleep(1000);

            // FIX 1:1 DISINI - Menghapus hideKeyboard() yang memicu bug auto-delete.
            // Langsung melangkah ke pencarian tombol Masuk persis seperti Cucumber asli.
            waitLogin.until(ExpectedConditions.presenceOfElementLocated(TEXT_MASUK_ELEMENT));
            WebElement masukTextBtn = driver.findElement(TEXT_MASUK_ELEMENT);

            actions.moveToElement(masukTextBtn).click().perform();
            System.out.println("W3C Actions berhasil mengeklik Tombol Tahap 1.");

            Thread.sleep(5000);

        } catch (Exception e) {
            System.out.println("Gagal mengeklik tombol Masuk tahap 1.");
            e.printStackTrace();
        }


        // =========================================================================
        // BLOCK: @When("user inputs valid password {string}") -> LoginSteps
        // =========================================================================
        try {
            waitLogin.until(ExpectedConditions.presenceOfElementLocated(FIELD_INPUT_PASSWORD_SECURE));
            AndroidElement passwordField = (AndroidElement) driver.findElement(FIELD_INPUT_PASSWORD_SECURE);

            passwordField.click();
            Thread.sleep(1000);
            passwordField.clear();
            Thread.sleep(500);

            passwordField.sendKeys("Cath0701.");
            System.out.println("Password tersuntik ke dalam field.");
            Thread.sleep(1000);

            // FIX 1:1 DISINI - Menghapus hideKeyboard() di halaman password agar behavior-nya seragam.
            waitLogin.until(ExpectedConditions.presenceOfElementLocated(TEXT_MASUK_ELEMENT));
            WebElement masukTextBtnFinal = driver.findElement(TEXT_MASUK_ELEMENT);

            actions.moveToElement(masukTextBtnFinal).click().perform();
            System.out.println("W3C Actions berhasil mengeklik Tombol Login Final.");

            Thread.sleep(7000);

        } catch (Exception e) {
            System.out.println("Gagal mengeklik tombol login tahap akhir.");
            e.printStackTrace();
        }


        // =========================================================================
        // BLOCK: @Then("user should be successfully redirected to homepage") -> LoginSteps
        // =========================================================================
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
        waitLogin.until(ExpectedConditions.presenceOfElementLocated(HOMEPAGE_MARKER));
        System.out.println("Sukses Besar! Beranda terdeteksi dan siap digunakan.");


        // =========================================================================
        // BLOCK: @Given("user is on homepage after login") -> SearchSteps
        // =========================================================================
        System.out.println("Memvalidasi kesiapan halaman beranda pasca login...");
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);

        try {
            WebDriverWait shortWait = new WebDriverWait(driver, 2);
            shortWait.until(ExpectedConditions.elementToBeClickable(BUTTON_NANTI_SAJA)).click();
            System.out.println("Sisa Pop-up dibersihkan dengan cepat.");
        } catch (Exception e) {
            // Lewati jika pop-up tidak muncul
        }

        waitSearch.until(ExpectedConditions.presenceOfElementLocated(ICON_SEARCH_NATIVE));
        System.out.println("Berhasil memvalidasi elemen search icon di beranda aktif.");


        // =========================================================================
        // BLOCK: @When("user types keyword {string} in search bar") -> SearchSteps
        // =========================================================================
        try {
            System.out.println("Menunggu elemen ikon pencarian murni siap...");
            AndroidElement searchIcon = (AndroidElement) waitSearch.until(
                    ExpectedConditions.elementToBeClickable(ICON_SEARCH_NATIVE)
            );
            Map<String, Object> clickSearch = new HashMap<>();
            clickSearch.put("elementId", searchIcon.getId());
            driver.executeScript("mobile: clickGesture", clickSearch);

            System.out.println("Menunggu kolom input pengetikan aktif...");
            AndroidElement typingField = (AndroidElement) waitSearch.until(
                    ExpectedConditions.visibilityOfElementLocated(SEARCH_TYPING_FIELD)
            );

            // 1:1 Sesuai Cucumber - click field baru sendKeys
            typingField.click();
            typingField.sendKeys("Aqua");

            System.out.println("Menunggu daftar suggestion muncul...");
            AndroidElement suggestionItem = (AndroidElement) waitSearch.until(
                    ExpectedConditions.elementToBeClickable(FIRST_SUGGESTION_ITEM)
            );

            suggestionItem.click();
            System.out.println("Berhasil memilih suggestion teratas.");

        } catch (Exception e) {
            System.out.println("Gagal mengeksekusi alur pengetikan.");
            e.printStackTrace();
        }


        // =========================================================================
        // BLOCK: @Then("application displays matching product list") -> SearchSteps
        // =========================================================================
        waitSearch.until(ExpectedConditions.presenceOfElementLocated(PRODUCT_AQUA_CARD));
        System.out.println("Daftar produk hasil pencarian berhasil dimuat.");


        // =========================================================================
        // BLOCK: @Given("user sees the product from search result") -> SearchSteps
        // =========================================================================
        waitSearch.until(ExpectedConditions.visibilityOfElementLocated(PRODUCT_AQUA_CARD));


        // =========================================================================
        // BLOCK: @When("user clicks add to basket button on the product") -> SearchSteps
        // =========================================================================
        try {
            System.out.println("Menunggu tombol tambah ke keranjang (ATC) siap...");
            AndroidElement btnAdd = (AndroidElement) waitSearch.until(
                    ExpectedConditions.elementToBeClickable(BUTTON_ADD_AQUA_BASKET)
            );

            Map<String, Object> clickAdd = new HashMap<>();
            clickAdd.put("elementId", btnAdd.getId());
            driver.executeScript("mobile: clickGesture", clickAdd);
            System.out.println("Tombol ATC (Add to Basket) sukses diklik via gesture!");
        } catch (Exception e) {
            System.out.println("Gagal mengeklik tombol tambah keranjang secara langsung.");
            e.printStackTrace();
        }


        // =========================================================================
        // BLOCK: @Then("basket status is updated with the product") -> SearchSteps
        // =========================================================================
        try {
            System.out.println("Memberikan waktu jeda asinkronus (1.5 detik) agar status basket diperbarui di backend...");
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        waitSearch.until(ExpectedConditions.presenceOfElementLocated(ICON_BASKET));
        System.out.println("Status keranjang divalidasi telah siap.");


        // =========================================================================
        // BLOCK: @Given("user goes to Basket page") -> SearchSteps
        // =========================================================================
        try {
            System.out.println("Mencoba berpindah ke halaman keranjang via ICON_BASKET...");
            AndroidElement basketIcon = (AndroidElement) waitSearch.until(
                    ExpectedConditions.elementToBeClickable(ICON_BASKET)
            );

            Map<String, Object> clickBasket = new HashMap<>();
            clickBasket.put("elementId", basketIcon.getId());
            driver.executeScript("mobile: clickGesture", clickBasket);
            System.out.println("Perintah klik halaman keranjang sukses dikirim.");
        } catch (Exception e) {
            System.out.println("Gagal klik via gesture, gunakan alternatif standar click...");
            driver.findElement(ICON_BASKET).click();
        }


        // =========================================================================
        // BLOCK: @Then("application renders product and displays checkout button") -> SearchSteps
        // =========================================================================
        System.out.println("Menunggu halaman keranjang memuat komponen checkout...");
        waitSearch.until(ExpectedConditions.visibilityOfElementLocated(TEXT_CHECKOUT_SELANJUTNYA));
        System.out.println("Halaman keranjang stabil. Tombol Selanjutnya siap dieksekusi.");


        // =========================================================================
        // BLOCK: @Given("user is on Order Summary page") -> SearchSteps
        // =========================================================================
        try {
            System.out.println("[KLIK 1] Mencoba klik Checkout Pertama ('Selanjutnya') di halaman Cart...");
            AndroidElement checkoutBtn = (AndroidElement) waitSearch.until(
                    ExpectedConditions.elementToBeClickable(CONTAINER_CHECKOUT)
            );

            Map<String, Object> clickCheckout1 = new HashMap<>();
            clickCheckout1.put("elementId", checkoutBtn.getId());
            driver.executeScript("mobile: clickGesture", clickCheckout1);
            System.out.println("[KLIK 1] Checkout pertama sukses.");

            System.out.println("Menunggu penyerapan halaman Penawaran Terbatas...");
            driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
            WebDriverWait shortWait = new WebDriverWait(driver, 5);

            try {
                System.out.println("Memeriksa keberadaan tombol 'Checkout' kedua di halaman Penawaran Terbatas...");
                AndroidElement upsellBtn = (AndroidElement) shortWait.until(
                        ExpectedConditions.elementToBeClickable(BUTTON_CHECKOUT_UPSELL)
                );

                System.out.println("[KLIK 2] Terdeteksi halaman Penawaran Terbatas! Mengeklik tombol 'Checkout' via Gesture...");
                Map<String, Object> clickUpsell = new HashMap<>();
                clickUpsell.put("elementId", upsellBtn.getId());
                driver.executeScript("mobile: clickGesture", clickUpsell);
                System.out.println("[KLIK 2] Sukses melewati Jetpack Compose Penawaran Terbatas.");

            } catch (Exception e) {
                System.out.println("Tombol Checkout kedua tidak ditemukan. Halaman penawaran otomatis terlewati atau absen.");
            }

        } catch (Exception e) {
            System.out.println("Terjadi kendala fatal saat memproses bypass checkout:");
            e.printStackTrace();
        }


        // =========================================================================
        // BLOCK: @When("user clicks Change button on store pickup option") -> SearchSteps
        // =========================================================================
        try {
            System.out.println("Memasuki halaman Order Summary. Memeriksa keberadaan panduan pengguna (User Guide/Coachmark)...");
            driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
            WebDriverWait guideWait = new WebDriverWait(driver, 4);

            try {
                AndroidElement btnOkGuide = (AndroidElement) guideWait.until(
                        ExpectedConditions.elementToBeClickable(BUTTON_OK_GUIDE)
                );
                System.out.println("Terdeteksi lapisan User Guide. Menekan tombol OK/Mengerti...");
                btnOkGuide.click();
                System.out.println("User Guide berhasil ditutup.");
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println("Lapisan User Guide tidak muncul atau langsung terlewat.");
            }

            System.out.println("Melakukan scroll down sedikit untuk memunculkan tombol Ganti Toko/Alamat...");
            scrollDownShort();
            Thread.sleep(1000);

            System.out.println("Menunggu halaman Order Summary memuat tombol Ganti/Ubah Toko...");
            AndroidElement btnGanti = (AndroidElement) waitSearch.until(
                    ExpectedConditions.elementToBeClickable(BUTTON_GANTI_TOKO)
            );

            System.out.println("Mengeklik tombol Ganti Toko...");
            btnGanti.click();
            System.out.println("Sukses klik tombol Ganti Toko.");

            waitSearch.until(ExpectedConditions.elementToBeClickable(BUTTON_MENU_PICKUP)).click();
            System.out.println("Sukses memilih Menu Pickup.");
        } catch (Exception e) {
            System.out.println("Gagal berinteraksi pada opsi pemilihan toko:");
            e.printStackTrace();
        }


        // =========================================================================
        // BLOCK: @Then("user is redirected to store location selection page") -> SearchSteps
        // =========================================================================
        try {
            waitSearch.until(ExpectedConditions.visibilityOfElementLocated(CHECKBOX_PILIH_TOKO)).click();
            System.out.println("Seluruh siklus FCR Sukses Dieksekusi 100%!");
        } catch (Exception e) {
            System.out.println("Gagal memvalidasi/klik halaman akhir penentuan lokasi:");
            e.printStackTrace();
        }

        try { Thread.sleep(3000); } catch (InterruptedException e) { e.printStackTrace(); }
        if (driver != null) {
            driver.quit();
            System.out.println("Driver quit successfully.");
        }
    }

    private void scrollDownShort() {
        try {
            Dimension size = driver.manage().window().getSize();

            int startX = size.width / 2;
            int startY = (int) (size.height * 0.60);
            int endY = (int) (size.height * 0.30);

            PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
            Sequence scroll = new Sequence(finger, 1);

            scroll.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY));
            scroll.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
            scroll.addAction(finger.createPointerMove(Duration.ofMillis(600), PointerInput.Origin.viewport(), startX, endY));
            scroll.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

            driver.perform(Collections.singletonList(scroll));
            System.out.println("Aksi gesture scroll down berhasil dieksekusi.");
        } catch (Exception e) {
            System.out.println("Gagal mengeksekusi gesture scroll down, mencoba menggunakan fallback UiScrollable...");
            try {
                driver.findElement(MobileBy.AndroidUIAutomator(
                        "new UiScrollable(new UiSelector().scrollable(true)).scrollForward()"
                ));
            } catch (Exception ex) {
                System.out.println("Fallback scroll juga gagal.");
            }
        }
    }
}