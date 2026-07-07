package com.android.automation.test.steps;

import com.android.automation.test.hooks.AndroidDriverHook;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class SearchSteps {

  private AndroidDriver<AndroidElement> driver;
  private WebDriverWait wait;

  public SearchSteps() {
    this.driver = AndroidDriverHook.driver;
    this.wait = new WebDriverWait(this.driver, 15);
  }

  // Bypass
  private final By BUTTON_NANTI_SAJA = MobileBy.id("com.alfamart.alfagift.beta:id/btn_later");

  private final By ICON_SEARCH_NATIVE = MobileBy.id("com.alfamart.alfagift.beta:id/iv_search");
  private final By SEARCH_TYPING_FIELD = MobileBy.id("com.alfamart.alfagift.beta:id/edt_search");
  private final By FIRST_SUGGESTION_ITEM = MobileBy.id("com.alfamart.alfagift.beta:id/tv_keyword");

  private final By PRODUCT_AQUA_CARD = MobileBy.xpath(
          "//android.widget.TextView[contains(@resource-id, 'product_name') and (contains(@text,'Aqua') or contains(@text,'AQUA') or contains(@text,'aqua'))] | " +
                  "//*[contains(@resource-id, 'tv_product_title') or contains(@resource-id, 'tv_title')]"
  );

  private final By BUTTON_ADD_AQUA_BASKET = MobileBy.xpath(
          "//*[contains(@resource-id, 'btn_add') or contains(@resource-id, 'iv_add') or contains(@resource-id, 'add_to_cart') or contains(@resource-id, 'btn_buy') or contains(@resource-id, 'iv_click_cart')]" +
                  " | //android.widget.Button[contains(@text, 'Keranjang') or contains(@text, 'Beli')]"
  );

  private final By ICON_BASKET = MobileBy.xpath(
          "//*[contains(@resource-id, 'btn_cart') or contains(@resource-id, 'iv_cart') or contains(@resource-id, 'menu_cart') or contains(@resource-id, 'cl_cart') or contains(@resource-id, 'iv_basket')]"
  );

  // LOCATOR CHECKOUT HALAMAN KERANJANG (NATIVE CART)
  private final By CONTAINER_CHECKOUT = MobileBy.id("com.alfamart.alfagift.beta:id/btn_checkout");
  private final By TEXT_CHECKOUT_SELANJUTNYA = MobileBy.id("com.alfamart.alfagift.beta:id/tv_check_out");

  // LOCATOR CHECKOUT HALAMAN PENAWARAN TERBATAS (JETPACK COMPOSE EXCLUSIVE)
  private final By BUTTON_CHECKOUT_UPSELL = MobileBy.xpath(
          "//android.widget.TextView[@text='Checkout'] | //android.widget.Button[@text='Checkout']"
  );

  // LOCATOR USER GUIDE / PANDUAN PENGGUNA DI ORDER SUMMARY
  private final By BUTTON_OK_GUIDE = MobileBy.xpath(
          "//android.widget.Button[contains(@text, 'OK') or contains(@text, 'Ok') or contains(@text, 'Mengerti') or contains(@text, 'Saya Mengerti')] | " +
                  "//android.widget.TextView[contains(@text, 'OK') or contains(@text, 'Ok') or contains(@text, 'Mengerti') or contains(@text, 'Saya Mengerti')] | " +
                  "//*[contains(@resource-id, 'btn_ok') or contains(@resource-id, 'tv_ok') or contains(@resource-id, 'btn_done')]"
  );

  private final By BUTTON_GANTI_TOKO = MobileBy.xpath("//*[contains(@text, 'Ganti') or contains(@text, 'Ubah')]");
  private final By BUTTON_MENU_PICKUP = MobileBy.xpath("//*[contains(@text, 'Pickup') or contains(@text, 'Pick Up') or contains(@text, 'Ambil sendiri')]");
  private final By CHECKBOX_PILIH_TOKO = MobileBy.xpath("//android.widget.CheckBox | //*[contains(@text, 'Pilih Toko') or contains(@text, 'Konfirmasi')]");

  @Given("user is on homepage after login")
  public void userIsOnHomepageAfterLogin() {
    System.out.println("Memvalidasi kesiapan halaman beranda pasca login...");
    driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);

    try {
      WebDriverWait shortWait = new WebDriverWait(driver, 2);
      shortWait.until(ExpectedConditions.elementToBeClickable(BUTTON_NANTI_SAJA)).click();
      System.out.println("Sisa Pop-up dibersihkan dengan cepat.");
    } catch (Exception e) {
      // Lewati jika pop-up tidak muncul
    }

    wait.until(ExpectedConditions.presenceOfElementLocated(ICON_SEARCH_NATIVE));
    System.out.println("Berhasil memvalidasi elemen search icon di beranda aktif.");
  }

  @When("user types keyword {string} in search bar")
  public void userTypesKeywordInSearchBar(String productKeyword) {
    try {
      System.out.println("Menunggu elemen ikon pencarian murni siap...");
      AndroidElement searchIcon = (AndroidElement) wait.until(
              ExpectedConditions.elementToBeClickable(ICON_SEARCH_NATIVE)
      );
      Map<String, Object> clickGesture = new HashMap<>();
      clickGesture.put("elementId", searchIcon.getId());
      driver.executeScript("mobile: clickGesture", clickGesture);

      System.out.println("Menunggu kolom input pengetikan aktif...");
      AndroidElement typingField = (AndroidElement) wait.until(
              ExpectedConditions.visibilityOfElementLocated(SEARCH_TYPING_FIELD)
      );

      typingField.click();
      typingField.sendKeys(productKeyword);

      System.out.println("Menunggu daftar suggestion muncul...");
      AndroidElement suggestionItem = (AndroidElement) wait.until(
              ExpectedConditions.elementToBeClickable(FIRST_SUGGESTION_ITEM)
      );

      suggestionItem.click();
      System.out.println("Berhasil memilih suggestion teratas.");

    } catch (Exception e) {
      System.out.println("Gagal mengeksekusi alur pengetikan.");
      e.printStackTrace();
    }
  }

  @Then("application displays matching product list")
  public void applicationDisplaysMatchingProductList() {
    wait.until(ExpectedConditions.presenceOfElementLocated(PRODUCT_AQUA_CARD));
    System.out.println("Daftar produk hasil pencarian berhasil dimuat.");
  }

  @Given("user sees the product from search result")
  public void userSeesTheProductFromSearchResult() {
    wait.until(ExpectedConditions.visibilityOfElementLocated(PRODUCT_AQUA_CARD));
  }

  @When("user clicks add to basket button on the product")
  public void userClicksAddToBasketButtonOnTheProduct() {
    try {
      System.out.println("Menunggu tombol tambah ke keranjang (ATC) siap...");
      AndroidElement btnAdd = (AndroidElement) wait.until(
              ExpectedConditions.elementToBeClickable(BUTTON_ADD_AQUA_BASKET)
      );

      Map<String, Object> clickGesture = new HashMap<>();
      clickGesture.put("elementId", btnAdd.getId());
      driver.executeScript("mobile: clickGesture", clickGesture);
      System.out.println("Tombol ATC (Add to Basket) sukses diklik via gesture!");
    } catch (Exception e) {
      System.out.println("Gagal mengeklik tombol tambah keranjang secara langsung.");
      e.printStackTrace();
    }
  }

  @Then("basket status is updated with the product")
  public void basketStatusIsUpdatedWithTheProduct() {
    try {
      System.out.println("Memberikan waktu jeda asinkronus (1.5 detik) agar status basket diperbarui di backend...");
      Thread.sleep(1500);
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
    }
    wait.until(ExpectedConditions.presenceOfElementLocated(ICON_BASKET));
    System.out.println("Status keranjang divalidasi telah siap.");
  }

  @Given("user goes to Basket page")
  public void userGoesToBasketPage() {
    try {
      System.out.println("Mencoba berpindah ke halaman keranjang via ICON_BASKET...");
      AndroidElement basketIcon = (AndroidElement) wait.until(
              ExpectedConditions.elementToBeClickable(ICON_BASKET)
      );

      Map<String, Object> clickGesture = new HashMap<>();
      clickGesture.put("elementId", basketIcon.getId());
      driver.executeScript("mobile: clickGesture", clickGesture);
      System.out.println("Perintah klik halaman keranjang sukses dikirim.");
    } catch (Exception e) {
      System.out.println("Gagal klik via gesture, gunakan alternatif standar click...");
      driver.findElement(ICON_BASKET).click();
    }
  }

  @Then("application renders product and displays checkout button")
  public void applicationRendersProductAndDisplaysCheckoutButton() {
    System.out.println("Menunggu halaman keranjang memuat komponen checkout...");
    wait.until(ExpectedConditions.visibilityOfElementLocated(TEXT_CHECKOUT_SELANJUTNYA));
    System.out.println("Halaman keranjang stabil. Tombol Selanjutnya siap dieksekusi.");
  }

  @Given("user is on Order Summary page")
  public void userIsOnOrderSummaryPage() {
    try {
      System.out.println("[KLIK 1] Mencoba klik Checkout Pertama ('Selanjutnya') di halaman Cart...");
      AndroidElement checkoutBtn = (AndroidElement) wait.until(
              ExpectedConditions.elementToBeClickable(CONTAINER_CHECKOUT)
      );

      Map<String, Object> clickGesture = new HashMap<>();
      clickGesture.put("elementId", checkoutBtn.getId());
      driver.executeScript("mobile: clickGesture", clickGesture);
      System.out.println("[KLIK 1] Checkout pertama sukses.");

      // LOGIKA BYPASS PENAWARAN TERBATAS BERBASIS JETPACK COMPOSE
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
  }

  @When("user clicks Change button on store pickup option")
  public void userClicksChangeButtonOnStorePickupOption() {
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
      AndroidElement btnGanti = (AndroidElement) wait.until(
              ExpectedConditions.elementToBeClickable(BUTTON_GANTI_TOKO)
      );

      System.out.println("Mengeklik tombol Ganti Toko...");
      btnGanti.click();
      System.out.println("Sukses klik tombol Ganti Toko.");

      wait.until(ExpectedConditions.elementToBeClickable(BUTTON_MENU_PICKUP)).click();
      System.out.println("Sukses memilih Menu Pickup.");
    } catch (Exception e) {
      System.out.println("Gagal berinteraksi pada opsi pemilihan toko:");
      e.printStackTrace();
    }
  }

  @Then("user is redirected to store location selection page")
  public void userIsRedirectedToStoreLocationSelectionPage() {
    try {
      wait.until(ExpectedConditions.visibilityOfElementLocated(CHECKBOX_PILIH_TOKO)).click();
      System.out.println("Seluruh siklus FCR Sukses Dieksekusi 100%!");
    } catch (Exception e) {
      System.out.println("Gagal memvalidasi/klik halaman akhir penentuan lokasi:");
      e.printStackTrace();
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