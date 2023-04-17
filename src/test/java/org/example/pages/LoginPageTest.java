package org.example.pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;


public class LoginPageTest {
    WebDriver driver;
    private LandingPage landingPage;
    private RegisterPage registerPage;
    private LoginPage loginPage;
    private static final Map<String,String> credentials=new HashMap<>();
    @BeforeAll
    static void beforeAll() throws IOException, ParseException {

        JSONParser parser = new JSONParser();
        Object obj = parser.parse(new FileReader("src/test/resources/loginDatas.json"));

        JSONArray solutions = (JSONArray) obj;
        for (Object solution : solutions) {
            String key =  ((JSONObject) solution).get("login").toString();
            String value = ((JSONObject) solution).get("password").toString();
            credentials.put(key, value);
        }
    }

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
    @DisplayName("Login with valid username and password")
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
    @Description("Login with multiple valid username and passwords repeatedly from file.")
    @DisplayName("Login with multiple valid username and passwords repeatedly from file.")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void testLoginMultipleUsers(){
        landingPage.navigateToLandingPage();
        landingPage.acceptTermsAndConditions();
        for(String key:credentials.keySet()){
            loginPage.login(key, credentials.get(key));
            BaseTest.makingScreenshot(driver);
            Assertions.assertTrue(loginPage.isLoginSuccessful());
            landingPage.navigateToLandingPage();
        }
    }
    @Epic("Portio website")
    @Description("Login with invalid username and password")
    @DisplayName("Login with invalid username and password")
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
