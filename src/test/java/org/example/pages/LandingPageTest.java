package org.example.pages;

import io.github.bonigarcia.wdm.WebDriverManager;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
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

    @Epic("Portio website")
    @Description("Accepting terms and conditions")
    @Severity(SeverityLevel.NORMAL)
    @Test
    void testAcceptTermsAndConditions() {
        landingPage.navigateToLandingPage();
        landingPage.acceptTermsAndConditions();
        BaseTest.makingScreenshot(driver);
        Assertions.assertTrue(landingPage.isAcceptSuccessful());
    }
    @Epic("Portio website")
    @Description("Not accepting terms and conditions")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void TestNotAcceptTermsAndConditions() {
       landingPage.navigateToLandingPage();
       landingPage.notAcceptTermsAndConditions();
        BaseTest.makingScreenshot(driver);
       Assertions.assertFalse(landingPage.isAcceptSuccessful());
    }



}