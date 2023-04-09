package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogoutPage extends BasePage{
    //constructor
    LogoutPage(WebDriver driver) {
        super(driver);
    }
    //locators, test datas
    private final By LOGOUT_BUTTON = By.xpath("//a[text()='Logout']");
    //methods
}
