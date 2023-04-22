package org.example.pages;

import io.github.bonigarcia.wdm.WebDriverManager;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

@Epic("Portio website")
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
    @Description("Accepting terms and conditions")
    @DisplayName("Accepting terms and conditions")
    @Severity(SeverityLevel.NORMAL)
    void testAcceptTermsAndConditions() {
        landingPage.navigateToLandingPage();
        landingPage.acceptTermsAndConditions();
        BaseTest.makingScreenshot(driver);
        Assertions.assertTrue(landingPage.isAcceptSuccessful());
    }
    @Test
    @Severity(SeverityLevel.NORMAL)
    @Description("Not accepting terms and conditions")
    @DisplayName("Not accepting terms and conditions")
    public void TestNotAcceptTermsAndConditions() {
       landingPage.navigateToLandingPage();
       landingPage.notAcceptTermsAndConditions();
        BaseTest.makingScreenshot(driver);
       Assertions.assertFalse(landingPage.isAcceptSuccessful());
    }

}