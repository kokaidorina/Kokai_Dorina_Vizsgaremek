package org.example.pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.time.Duration;

@Epic("Portio website")
public class AboutPageTest {
    WebDriver driver;
    private LandingPage landingPage;
    private RegisterPage registerPage;
    private LoginPage loginPage;
    private AboutPage aboutPage;

    @BeforeEach
    void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = BaseTest.getWebDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        landingPage = new LandingPage(driver);
        registerPage=new RegisterPage(driver);
        loginPage=new LoginPage(driver);
        aboutPage=new AboutPage(driver);
    }
    @AfterEach
    void quitBrowser() {
        driver.quit();
    }

    @Test
    @Description("Checking About page's content and write it to a file.")
    @DisplayName("Checking About page's content.")
    @Severity(SeverityLevel.NORMAL)
    public void testAboutTextToFile() throws IOException {
        String userNameTestData="lovasia";
        String passwordTestData="kispal123";
        String fileNameTestData="aboutTestResult2.txt";
        landingPage.navigateToLandingPage();
        landingPage.acceptTermsAndConditions();
        loginPage.login(userNameTestData, passwordTestData);
        loginPage.clickOnAboutButton();
        BaseTest.createNewFile(fileNameTestData);
        BaseTest.writeToFile(fileNameTestData, aboutPage.getAbout());
        int actualResult=aboutPage.getNumberOfLines(fileNameTestData);
        int expectedResult=5;
        Assertions.assertEquals(expectedResult,actualResult);
    }

}
