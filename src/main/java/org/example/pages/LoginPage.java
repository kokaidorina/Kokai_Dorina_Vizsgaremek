package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
    //constructor
    LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    //locators, test datas
    private final By USERNAME_FIELD = By.id("email");
    private final By PASSWORD_FIELD = By.id("password");
    private final By LOGIN_SUBMIT_BUTTON = By.xpath("//div[@class='formGroup']/button[text()='Login']");
    private final By LOGOUT_BUTTON = By.xpath("//a[text()='Logout']");

    @FindBy(id ="email" )
    WebElement userNameInput;

    @FindBy(id = "password")
    WebElement passwordInput;
    @FindBy(xpath = "//div[@class='formGroup']/button[text()='Login']" )
    WebElement submitButton;

    //methods
    public void login(String userName, String password) {
        userNameInput.click();
        userNameInput.sendKeys(userName, Keys.TAB);
        passwordInput.sendKeys(password);
        submitButton.click();
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
