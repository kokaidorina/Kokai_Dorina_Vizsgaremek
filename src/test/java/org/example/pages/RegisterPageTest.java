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

public class RegisterPageTest {
    WebDriver driver;
    private LandingPage landingPage;
    private RegisterPage registerPage;

    @BeforeEach
    void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = BaseTest.getWebDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        landingPage = new LandingPage(driver);
        registerPage=new RegisterPage(driver);
    }
    @AfterEach
    void quitBrowser() {
        driver.quit();
    }
    @Epic("Portio website")
    @Description("Register a new user to the website")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void testRegister(){
        String userNameTestData="testA";
        String passwordTestData="123";
        String emailTestData="abc@abc.hu";
        String descriptionTestData="something exciting";
        landingPage.navigateToLandingPage();
        landingPage.acceptTermsAndConditions();
        registerPage.registerNewUser(userNameTestData, passwordTestData,emailTestData, descriptionTestData);
        landingPage.navigateToLandingPage();
        BaseTest.makingScreenshot(driver);
        Assertions.assertTrue(registerPage.isRegistrationSuccessful(userNameTestData,passwordTestData));
    }
}
