package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage {
    //constructor
    LoginPage(WebDriver driver) {
        super(driver);
    }

    //locators, test datas
    private final By USERNAME_FIELD = By.id("email");
    private final By PASSWORD_FIELD = By.id("password");
    private final By LOGIN_SUBMIT_BUTTON = By.xpath("//div[@class='formGroup']/button[text()='Login']");
    private final By LOGOUT_BUTTON = By.xpath("//a[text()='Logout']");

    //methods
    public void login(String userName, String password) {
        driver.findElement(USERNAME_FIELD).click();
        driver.findElement(USERNAME_FIELD).sendKeys(userName, Keys.TAB);
        driver.findElement(PASSWORD_FIELD).sendKeys(password);
        driver.findElement(LOGIN_SUBMIT_BUTTON).click();

    }

    public boolean isLoginSuccessful() {
        try {
            if (driver.findElement(LOGOUT_BUTTON).isDisplayed()) {
                return true;
            }
        } catch (Exception e) {
        }
        return false;
    }
}
