package org.example.pages;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

class LandingPageTest {
    WebDriver driver;
    private LandingPage landingPage;

    @BeforeEach
    void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("incognito");
        options.addArguments("ignore-certificate-errors");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-extensions");
        //options.addArguments("--headless");
        options.addArguments("--window-size=1920,1080");
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);

        landingPage = new LandingPage(driver);
    }
    @AfterEach
    void quitBrowser() {
        driver.quit();
    }

    @Test
    void testAcceptTermsAndConditions() {
        landingPage.navigateToLandingPage();
        landingPage.acceptTermsAndConditions();
        Assertions.assertTrue(landingPage.isAcceptSuccessful()); //accept button not disappearing
    }



}