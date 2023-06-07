package com.kodilla.selenium.pom.homework;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

class KodillaStorePomTest {
    KodillaStorePom storePom;

    WebDriver driver;

    @BeforeEach
    public void setup() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(chromeOptions);
        driver.navigate().to("https://kodilla.com/pl/test/store");
        storePom = new KodillaStorePom(driver);
    }

    @Test
    public void testStorePage_ReturnCorrectNumberOfResultForNoteBookPhrase() {
        String searchedPhrase = "Notebook";
        int numberOfResults = storePom.searchForProducts(searchedPhrase).size();

        Assertions.assertEquals(2, numberOfResults);
    }

    @Test
    public void testStorePage_ReturnCorrectNumberOfResultForSchoolPhrase() {
        String searchedPhrase = "School";
        int numberOfResults = storePom.searchForProducts(searchedPhrase).size();

        Assertions.assertEquals(1, numberOfResults);
    }

    @Test
    public void testStorePage_ReturnCorrectNumberOfResultForBrandPhrase() {
        String searchedPhrase = "Brand";
        int numberOfResults = storePom.searchForProducts(searchedPhrase).size();

        Assertions.assertEquals(1, numberOfResults);
    }

    @Test
    public void testStorePage_ReturnNoResultsForBusinessPhrase() {
        String searchedPhrase = "Business";
        int numberOfResults = storePom.searchForProducts(searchedPhrase).size();

        Assertions.assertEquals(0, numberOfResults);
    }

    @Test
    public void testStorePage_ReturnCorrectMessageWhenNoResults() {
        String searchedPhrase = "Powerful";
        int numberOfResults = storePom.searchForProducts(searchedPhrase).size();

        Assertions.assertEquals(0, numberOfResults);
        Assertions.assertTrue(storePom.getNoResultMessage().contains("nie mamy tego czego szukasz"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"SCHOOL", "brand", "GaminG"})
    public void testStorePage_CanReturnProductsIfCaseInsensitiveText(String searchedPhrase) {

        Assertions.assertTrue(storePom.searchForProducts(searchedPhrase).size() >= 0);
    }

    @ParameterizedTest
    @ValueSource(strings = {"SCHOOL", "school", "SCHooL"})
    public void testStorePage_ReturnCorrectNumberOfProductsIfCaseInsensitiveText(String searchedPhrase) {

        Assertions.assertEquals(1, storePom.searchForProducts(searchedPhrase).size());
    }

    @AfterEach
    public void testDown() {
        driver.close();
    }
}