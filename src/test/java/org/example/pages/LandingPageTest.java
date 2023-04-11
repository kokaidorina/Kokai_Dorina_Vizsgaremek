package org.example.pages;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

class LandingPageTest {
    WebDriver driver;
    private LandingPage landingPage;

   @BeforeEach
    void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = BaseTest.getWebDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

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
        BaseTest.makingScreenshot(driver);
        Assertions.assertTrue(landingPage.isAcceptSuccessful());
    }
    @Test
    public void TestNotAcceptTermsAndConditions() {
       landingPage.navigateToLandingPage();
       landingPage.notAcceptTermsAndConditions();
        BaseTest.makingScreenshot(driver);
       Assertions.assertFalse(landingPage.isAcceptSuccessful());
    }



}