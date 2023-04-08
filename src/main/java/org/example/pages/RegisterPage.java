package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class RegisterPage extends BasePage {
    //constructor
    protected RegisterPage(WebDriver driver) {
        super(driver);
    }
    //locators, test datas
    private final By REGISTER_FORM_BUTTON=By.xpath("//div[@id='login']/button[@id='register-form-button']");
    private final By USERNAME_INPUT=By.id("register-username");
    private final By PASSWORD_INPUT=By.id("register-password");
    private final By EMAIL_INPUT=By.id("register-email");
    private final By DESCRIPTION_INPUT=By.id("register-description");
    private final By REGISTER_SUBMIT_BUTTON=By.xpath("//div[@class='formGroup']/button[text()='Register']");


    //methods

    public void registerNewUser(String userName, String password, String email, String description){
        driver.findElement(REGISTER_FORM_BUTTON).click();
        driver.findElement(USERNAME_INPUT).click();
        driver.findElement(USERNAME_INPUT).sendKeys(userName, Keys.TAB);
        driver.findElement(PASSWORD_INPUT).sendKeys(password, Keys.TAB);
        driver.findElement(EMAIL_INPUT).sendKeys(email, Keys.TAB);
        driver.findElement(DESCRIPTION_INPUT).sendKeys(description);
        driver.findElement(REGISTER_SUBMIT_BUTTON).click();
    }




}