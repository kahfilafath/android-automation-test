package com.android.automation.test.steps;

import com.android.automation.test.base.PageBaseObject;
import io.appium.java_client.MobileBy;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.mockito.ArgumentMatchers.matches;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebElement;

public class SearchSteps extends PageBaseObject {

  public ArrayList<String> collect;

  @Given("user on the HomePage")
  public void userOnTheHomePage() {
    By HOMESCREEN = MobileBy.id("edt_search");
    Assertions.assertEquals("Mau belanja apa?", getText(HOMESCREEN), "Failed load Homepage");
  }

  @When("user click field search")
  public void userClickFieldSearch() {
    By CLICK_SEARCH = MobileBy.id("edt_search");
    click(CLICK_SEARCH);
  }

  @And("user click the product suggestion below the search bar")
  public void userClickTheProductSuggestionBelowTheSearchBar() {
    By CLICK_SUGGESTION = MobileBy.id("tv_keyword");
    click(CLICK_SUGGESTION);
  }

  @And("user search the product {string} on the search bar")
  public void userSearchTheProductOnTheSearchBar(String input_search) {
    By INPUT_KEYWORD = MobileBy.id("edt_search");
    input(INPUT_KEYWORD, input_search);
  }

  @And("user see the product suggestion {string} below the search bar")
  public void userSeeTheProductSuggestionBelowTheSearchBar(String see_product) {
    By SUGGESTION = MobileBy.id("tv_keyword");
    Assertions.assertEquals(see_product, getText(SUGGESTION), "Failed load suggestion");
  }

  @Then("user should discover the product {string} on the search result page")
  public void userShouldDiscoverTheProductOnTheSearchResultPage(String title_product) {

    By RESULT = MobileBy.id("txt_product_name");
    List<String> disProduct = findAll(RESULT).stream().map(RemoteWebElement::getText)
        .collect(Collectors.toList());
    for (String string : disProduct) {
      MatcherAssert.assertThat("Produk tidak ditemukan", string.toLowerCase(),
          Matchers.containsString(title_product));
    }
  }
}

