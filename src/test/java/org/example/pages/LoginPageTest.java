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


public class LoginPageTest {
    WebDriver driver;
    private LandingPage landingPage;
    private RegisterPage registerPage;
    private LoginPage loginPage;

    @BeforeEach
    void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = BaseTest.getWebDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        landingPage = new LandingPage(driver);
        registerPage=new RegisterPage(driver);
        loginPage=new LoginPage(driver);
    }
    @AfterEach
    void quitBrowser() {
        driver.quit();
    }
    @Epic("Portio website")
    @Description("Login with valid username and password")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void testLogin(){
        String userNameTestData="lovasia";
        String passwordTestData="kispal123";
        landingPage.navigateToLandingPage();
        landingPage.acceptTermsAndConditions();
        loginPage.login(userNameTestData, passwordTestData);
        BaseTest.makingScreenshot(driver);
        Assertions.assertTrue(loginPage.isLoginSuccessful());
    }
    @Epic("Portio website")
    @Description("Login with invalid username and password")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void testLoginWithInvalidDatas(){
        String userNameTestData="invalid";
        String passwordTestData="password";
        landingPage.navigateToLandingPage();
        landingPage.acceptTermsAndConditions();
        loginPage.login(userNameTestData, passwordTestData);
        BaseTest.makingScreenshot(driver);
        Assertions.assertFalse(loginPage.isLoginSuccessful());
    }
}
