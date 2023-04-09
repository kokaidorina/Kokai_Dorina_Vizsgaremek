package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage extends BasePage {
    //constructor
    LandingPage(WebDriver driver) {
        super(driver);
    }

    //locators, test datas
    String LANDING_PAGE = "https://lennertamas.github.io/portio/";
    private final By TERMS_AND_CONDITIONS_BUTTON = By.id("terms-and-conditions-button");

    //methods
    public void navigateToLandingPage() {
        driver.navigate().to(LANDING_PAGE);
    }

    public void acceptTermsAndConditions() {
        driver.findElement(TERMS_AND_CONDITIONS_BUTTON).click();
    }

    public boolean isAcceptSuccessful() {
        if (driver.findElement(TERMS_AND_CONDITIONS_BUTTON).isDisplayed()) {
            return false;
        } else return true;
    }
}
