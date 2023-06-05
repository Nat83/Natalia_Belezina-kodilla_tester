package com.kodilla.selenium.allegro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AllegroTestingApp {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://allegro.pl/");

        WebElement acceptCookieButton = driver.findElement
                (By.xpath("//button[@data-role=\"accept-consent\"]"));
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(acceptCookieButton));
        acceptCookieButton.click();

        WebElement searchInput = driver.findElement(By.xpath("//*[@placeholder=\"czego szukasz?\"]"));
        searchInput.sendKeys("Mavic mini");

        WebElement typeCombo = driver.findElement
                (By.xpath("//select[contains(@aria-label, \"Kategoria\")]"));
        Select typeSelect = new Select(typeCombo);
        typeSelect.selectByVisibleText("Elektronika");

        WebElement submitButton = driver.findElement(By.xpath("//button[@type=\"submit\"]"));
        submitButton.submit();
    }
}
