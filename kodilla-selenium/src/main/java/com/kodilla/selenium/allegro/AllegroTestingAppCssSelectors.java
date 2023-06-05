package com.kodilla.selenium.allegro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class AllegroTestingAppCssSelectors {
    public static void main(String[] args) {

        //ALLEGRO
//        System.setProperty("webdriver.chrome.driver", "C:\\Users\\betal\\Desktop\\bootcampKodilla\\selenium-drivers\\" +
//                "Chrome\\chromedriver.exe");
//        WebDriver driver = new ChromeDriver();
//        driver.get("https://allegro.pl/");
//
//        WebElement acceptCookieButton = driver.findElement
//                (By.cssSelector("[data-role=accept-consent]"));
//        WebDriverWait wait = new WebDriverWait(driver, 20);
//        wait.until(ExpectedConditions.visibilityOf(acceptCookieButton));
//        acceptCookieButton.click();
//
//        WebElement searchInput = driver.findElement(By.name("string"));
//        searchInput.sendKeys("Mavic mini");
//
//        WebElement typeCombo = driver.findElement
//                (By.cssSelector("select[aria-label*='Kategoria']"));
//        Select typeSelect = new Select(typeCombo);
//        typeSelect.selectByVisibleText("Elektronika");
//
//        WebElement submitButton = driver.findElement(By.cssSelector("[data-role=search-button]"));
//        submitButton.submit();
//
//        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("section > article")));
//
//        WebElement confirmYouAreNotRobotButton = driver.findElement(By.id("captcha_display_button"));
//        confirmYouAreNotRobotButton.submit();
//
//        List<WebElement> listOfArticles = driver.findElements(By.cssSelector("section > article"));
//        listOfArticles.stream()
//                .forEach(article -> System.out.println(article.getText()));

        //EBAY
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\betal\\Desktop\\bootcampKodilla\\selenium-drivers\\" +
                "Chrome\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.ebay.pl/");

        WebElement searchInput = driver.findElement(By.cssSelector(".ui-autocomplete-input"));
        searchInput.sendKeys("Mavic mini");

        WebElement typeCombo = driver.findElement
                (By.name("_sacat"));
        typeCombo.click();
        Select typeSelect = new Select(typeCombo);
        typeSelect.selectByVisibleText("Fotografia i Kamery");

        WebElement searchButton = driver.findElement(By.cssSelector("[type=submit]"));
        searchButton.submit();
        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement productBoxes = driver.findElement(By.cssSelector("div>ul>li[data-viewport*='{\"trackableId']"));
        wait.until(ExpectedConditions.visibilityOfAllElements(productBoxes));


        List<WebElement> listOfProducts = driver.findElements
                (By.cssSelector("div>ul>li[data-viewport*='{\"trackableId']"));
        listOfProducts.stream()
                .forEach(product -> System.out.println(product.findElement
                        (By.cssSelector("span[role=\"heading\"]")).getText()));
    }
}
