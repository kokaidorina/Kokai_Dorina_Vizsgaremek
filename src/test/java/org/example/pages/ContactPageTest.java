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
public class ContactPageTest {
    WebDriver driver;
    private LandingPage landingPage;
    private LoginPage loginPage;
    private ContactPage contactPage;


    @BeforeEach
    void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = BaseTest.getWebDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        landingPage = new LandingPage(driver);
        loginPage=new LoginPage(driver);
        contactPage=new ContactPage(driver);
    }
    //@AfterEach
    void quitBrowser() {
        driver.quit();
    }

    @Test
    //@Epic("Portio website")
    @Severity(SeverityLevel.NORMAL)
    @Description("Sending a message with filling all fields with valid data.")
    @DisplayName("Sending a message with filling all fields with valid data.")
    public void testContact(){
        landingPage.navigateToLandingPage();
        landingPage.acceptTermsAndConditions();
        String userNameTestData="lovasia";
        String passwordTestData="kispal123";
        loginPage.login(userNameTestData, passwordTestData);
        contactPage.clickOnContactButton();
        contactPage.clickOnGetInTouch();
        contactPage.fillContactForm("Andras", "lovasi@kispal.hu", "Emese mostmár indul a buszod.");
        Assertions.assertTrue(contactPage.isMessageSent());
    }


}
