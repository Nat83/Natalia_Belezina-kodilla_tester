package com.kodilla.selenium.pom.homework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class KodillaStorePom extends AbstractPom {
    @FindBy(css = "input[name=\"search\"]")
    WebElement searchField;

    @FindBy(css = "div .element")
    List<WebElement> productBoxes;
    @FindBy(css = "div > h3[class*=\"missing\"]")
    WebElement noResultMessage;

    public KodillaStorePom(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public List<WebElement> searchForProducts(String phrase) {
        searchField.sendKeys(phrase);
        return productBoxes;
    }

    public String getNoResultMessage() {
        String message = noResultMessage.getText();
        return message;
    }

    public void close() {
        driver.close();
    }
}
