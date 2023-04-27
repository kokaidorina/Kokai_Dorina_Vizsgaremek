package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class ProfileModificationPage extends BasePage{
    //constructor
    ProfileModificationPage(WebDriver driver) {
        super(driver);
    }
    //locators, test datas
    private final By NAME_INPUT=By.id("name");
    private final By BIO_INPUT=By.id("bio");
    private final By PHONE_NUMBER_INPUT=By.id("phone-number");
    private final By SAVE_PROFILE_BUTTON=By.xpath("//div[@class='formGroup']/button[@type='button'][text()='Save Profile']");
    private final By SUCCESS_MESSAGE=By.xpath("//p[text()='Profile Edited!']");
    private final By DELETE_ACCOUNT=By.xpath("//div/button[@onclick='showRealDeleteAccBtn()']");
    private final By REAL_DELETE_ACCOUNT=By.xpath("//div/button[@onclick='deleteAccount()']");

    private final By LOGIN_SUBMIT_BUTTON = By.xpath("//div[@class='formGroup']/button[text()='Login']");

    //methods
    public void modifyProfile(String name, String bio, String phoneNumber){

        driver.findElement(NAME_INPUT).click();
        driver.findElement(NAME_INPUT).sendKeys(name, Keys.TAB);
        driver.findElement(BIO_INPUT).sendKeys(bio, Keys.TAB);
        driver.findElement(PHONE_NUMBER_INPUT).sendKeys(phoneNumber);
        driver.findElement(SAVE_PROFILE_BUTTON).click();
    }
    public boolean isProfileModificationSuccessful(){
        if(driver.findElement(SUCCESS_MESSAGE).isDisplayed()){
            return true;
        }
        else return false;
    }
    public void deleteAccount(){

        driver.findElement(DELETE_ACCOUNT).click();
        waitForElementVisibility(REAL_DELETE_ACCOUNT);
        driver.findElement(REAL_DELETE_ACCOUNT).click();
    }
    public boolean isProfileDeleted(){
       return driver.findElement(LOGIN_SUBMIT_BUTTON).isDisplayed();
    }

}
