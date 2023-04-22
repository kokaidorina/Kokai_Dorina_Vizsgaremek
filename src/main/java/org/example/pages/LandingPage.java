package org.example.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage extends BasePage {
    //constructor
    LandingPage(WebDriver driver) {
        super(driver);
    }

    //locators, test datas
    static String LANDING_PAGE = "https://lennertamas.github.io/portio/";
    private final By TERMS_AND_CONDITIONS_BUTTON = By.id("terms-and-conditions-button");
    private final By CLOSE_ICON = By.className("CloseIcon");

    //methods
    @Step("Navigate to landing page.")
    public void navigateToLandingPage() {
        driver.navigate().to(LANDING_PAGE);
    }

    @Step("Accepting terms and conditions by clicking on 'Accept' button.")
    public void acceptTermsAndConditions() {
        driver.findElement(TERMS_AND_CONDITIONS_BUTTON).click();
    }

    @Step("Declining terms and conditions by clicking on 'x' button on the pop-up window.")
    public void notAcceptTermsAndConditions() {
        driver.findElement(CLOSE_ICON).click();
    }

    @Step("Verifying if accepting terms and conditions is successful.")
    public boolean isAcceptSuccessful() {
        if (driver.findElement(TERMS_AND_CONDITIONS_BUTTON).isDisplayed()) {
            return false;
        } else return true;
    }
}
