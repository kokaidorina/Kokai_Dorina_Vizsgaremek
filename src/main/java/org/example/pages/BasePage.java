package org.example.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

abstract class BasePage {
    static WebDriver driver;

    //constructor
    BasePage(WebDriver driver) {
        this.driver = driver;
    }

    //common methods
    public static void waitForElementVisibility(By locator) {
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(driver.findElement(locator)));
    }


    //header locators
    private final By LOGOUT_BUTTON = By.xpath("//a[text()='Logout']");
    private final By PROFILE_ICON = By.id("profile-btn");
    private final By CONTACT_BUTTON = By.xpath("//a[text()='Hire Me Now']");
    private final By BLOG_BUTTON = By.xpath("//a[text()='Blog']");
    private final By SKILLS_BUTTON = By.xpath("//a[text()='Skills']");
    private final By RESUME_BUTTON = By.xpath("//a[text()='Resume']");
    private final By WORK_BUTTON = By.xpath("//a[text()='Work']");
    private final By SERVICE_BUTTON = By.xpath("//a[text()='Service']");
    private final By ABOUT_BUTTON = By.xpath("//a[text()='About']");
    private final By HOME_BUTTON = By.xpath("//a[text()='Home']");

    //header click methods
    public void logout() {
        driver.findElement(LOGOUT_BUTTON).click();
    }

    public void clickOnProfileButton() {
        driver.findElement(PROFILE_ICON).click();
    }

    public void clickOnContactButton() {
        driver.findElement(CONTACT_BUTTON).click();
    }

    public void clickOnBlogButton() {
        driver.findElement(BLOG_BUTTON).click();
    }

    public void clickOnSkillsButton() {
        driver.findElement(SKILLS_BUTTON).click();
    }
    public void clickOnResumeButton() {
        driver.findElement(RESUME_BUTTON).click();
    }
    public void clickOnWorkButton() {
        driver.findElement(WORK_BUTTON).click();
    }
    public void clickOnServiceButton() {
        driver.findElement(SERVICE_BUTTON).click();
    }
    public void clickOnAboutButton() {
        driver.findElement(ABOUT_BUTTON).click();
    }
    public void clickOnHomeButton() {
        driver.findElement(HOME_BUTTON).click();
    }
}
