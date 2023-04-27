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
public class ProfileModificationTest {
    WebDriver driver;
    private LandingPage landingPage;
    private RegisterPage registerPage;
    private LoginPage loginPage;
    private LogoutPage logoutPage;
    private ProfileModificationPage profileModificationPage;

    @BeforeEach
    void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = BaseTest.getWebDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        landingPage = new LandingPage(driver);
        registerPage = new RegisterPage(driver);
        loginPage = new LoginPage(driver);
        logoutPage = new LogoutPage(driver);
        profileModificationPage = new ProfileModificationPage(driver);
    }

    @AfterEach
    void quitBrowser() {
        driver.quit();
    }

    @Test
    @Description("Profile modification")
    @DisplayName("Profile modification")
    @Severity(SeverityLevel.NORMAL)
    public void testProfileModification() {
        landingPage.navigateToLandingPage();
        landingPage.acceptTermsAndConditions();
        String userNameTestData = "testA";
        String passwordTestData = "123";
        String emailTestData = "abc@abc.hu";
        String descriptionTestData = "something exciting";
        registerPage.registerNewUser(userNameTestData, passwordTestData, emailTestData, descriptionTestData);
        landingPage.navigateToLandingPage();
        loginPage.login(userNameTestData, passwordTestData);
        String nameTestData = "Automation";
        String bioTestData = "something bio";
        String phoneTestData = "+36123456789";
        profileModificationPage.clickOnProfileButton();
        profileModificationPage.modifyProfile(nameTestData, bioTestData, phoneTestData);
        BaseTest.makingScreenshot(driver);
        Assertions.assertTrue(profileModificationPage.isProfileModificationSuccessful());
    }

    @Test
    @Description("Delete profile")
    @DisplayName("Delete profile")
    @Severity(SeverityLevel.CRITICAL)
    public void testDeleteAccount() {
        landingPage.navigateToLandingPage();
        landingPage.acceptTermsAndConditions();
        String userNameTestData = "testB";
        String passwordTestData = "12345";
        String emailTestData = "abc@cba.hu";
        String descriptionTestData = "something exciting";
        registerPage.registerNewUser(userNameTestData, passwordTestData, emailTestData, descriptionTestData);
        landingPage.navigateToLandingPage();
        loginPage.login(userNameTestData, passwordTestData);
        profileModificationPage.clickOnProfileButton();
        profileModificationPage.deleteAccount();
        BaseTest.makingScreenshot(driver);
        Assertions.assertTrue(profileModificationPage.isProfileDeleted());

    }
}
