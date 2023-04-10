package org.example.pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

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
        registerPage=new RegisterPage(driver);
        loginPage=new LoginPage(driver);
        logoutPage=new LogoutPage(driver);
        profileModificationPage=new ProfileModificationPage(driver);
    }
  //  @AfterEach
    void quitBrowser() {
        driver.quit();
    }

    @Test
    public void testProfileModification(){
        landingPage.navigateToLandingPage();
        landingPage.acceptTermsAndConditions();
        String userNameTestData="testA";
        String passwordTestData="123";
        String emailTestData="abc@abc.hu";
        String descriptionTestData="something exciting";
        registerPage.registerNewUser(userNameTestData,passwordTestData,emailTestData,descriptionTestData);
        landingPage.navigateToLandingPage();
       // landingPage.acceptTermsAndConditions();
        loginPage.login(userNameTestData,passwordTestData);
        String nameTestData="Automation";
        String bioTestData="something bio";
        String phoneTestData="+36123456789";
        profileModificationPage.modifyProfile(nameTestData, bioTestData, phoneTestData);
        Assertions.assertTrue(profileModificationPage.isProfileModificationSuccesful());
    }
}
