package org.example.pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class RegisterPageTest {
    WebDriver driver;
    private LandingPage landingPage;
    private RegisterPage registerPage;

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
       // options.addArguments("--headless");
        options.addArguments("--window-size=1920,1080");
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);

        landingPage = new LandingPage(driver);
        registerPage=new RegisterPage(driver);
    }
    @AfterEach
    void quitBrowser() {
        driver.quit();
    }
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
        Assertions.assertTrue(registerPage.isRegistrationSuccessful(userNameTestData,passwordTestData));
    }
}
