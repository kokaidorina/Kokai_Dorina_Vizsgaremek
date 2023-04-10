package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogoutPage extends BasePage {
    //constructor
    LogoutPage(WebDriver driver) {
        super(driver);
    }

    //locators, test datas
    private final By LOGOUT_BUTTON = By.xpath("//a[text()='Logout']");
    private final By LOGIN_SUBMIT_BUTTON = By.xpath("//div[@class='formGroup']/button[text()='Login']");

    //methods
    public void logout() {
        driver.findElement(LOGOUT_BUTTON).click();
    }

    public boolean isLogoutSuccessful() {
        if (driver.findElement(LOGIN_SUBMIT_BUTTON).isDisplayed()) {
            return true;
        } else return false;
    }
}
