package org.example.pages;

import io.github.bonigarcia.wdm.WebDriverManager;
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
    @Test
    public void testLogin(){
        String userNameTestData="lovasia";
        String passwordTestData="kispal123";
        landingPage.navigateToLandingPage();
        landingPage.acceptTermsAndConditions();
        loginPage.login(userNameTestData, passwordTestData);
        Assertions.assertTrue(loginPage.isLoginSuccessful());
    }
    @Test
    public void testLoginWithInvalidDatas(){
        String userNameTestData="invalid";
        String passwordTestData="password";
        landingPage.navigateToLandingPage();
        landingPage.acceptTermsAndConditions();
        loginPage.login(userNameTestData, passwordTestData);
        Assertions.assertFalse(loginPage.isLoginSuccessful());
    }
}
