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
    private final By PROFILE_ICON= By.id("profile-btn");
    private final By NAME_INPUT=By.id("name");
    private final By BIO_INPUT=By.id("bio");
    private final By PHONE_NUMBER_INPUT=By.id("phone-number");
    private final By SAVE_PROFILE_BUTTON=By.xpath("//div[@class='formGroup']/button[@type='button'][text()='Save Profile']");
    private final By SUCCESS_MESSAGE=By.xpath("//p[text()='Profile Edited!']");

    //methods
    public void modifyProfile(String name, String bio, String phoneNumber){
        driver.findElement(PROFILE_ICON).click();
        driver.findElement(NAME_INPUT).click();
        driver.findElement(NAME_INPUT).sendKeys(name, Keys.TAB);
        driver.findElement(BIO_INPUT).sendKeys(bio, Keys.TAB);
        driver.findElement(PHONE_NUMBER_INPUT).sendKeys(phoneNumber);
        driver.findElement(SAVE_PROFILE_BUTTON).click();
    }
    public boolean isProfileModificationSuccesful(){
        if(driver.findElement(SUCCESS_MESSAGE).isDisplayed()){
            return true;
        }
        else return false;
    }
}
