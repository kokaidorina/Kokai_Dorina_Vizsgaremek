package org.example.pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class LogoutPageTest {
    WebDriver driver;
    private LandingPage landingPage;
    private RegisterPage registerPage;
    private LoginPage loginPage;
    private LogoutPage logoutPage;

    @BeforeEach
    void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = BaseTest.getWebDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        landingPage = new LandingPage(driver);
        registerPage=new RegisterPage(driver);
        loginPage=new LoginPage(driver);
        logoutPage=new LogoutPage(driver);
    }
    @AfterEach
    void quitBrowser() {
        driver.quit();
    }
    @Test
    public void testLogout(){
        landingPage.navigateToLandingPage();
        landingPage.acceptTermsAndConditions();
        String userNameTestData="lovasia";
        String passwordTestData="kispal123";
        loginPage.login(userNameTestData,passwordTestData);
        logoutPage.logout();
        Assertions.assertTrue(logoutPage.isLogoutSuccessful());
    }
}
