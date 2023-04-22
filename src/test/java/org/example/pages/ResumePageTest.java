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

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

@Epic("Portio website")
public class ResumePageTest {
    WebDriver driver;
    private LandingPage landingPage;
    private LoginPage loginPage;
    private ResumePage resumePage;



    @BeforeEach
    void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = BaseTest.getWebDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        landingPage = new LandingPage(driver);
        loginPage = new LoginPage(driver);
        resumePage = new ResumePage(driver);
    }

    @AfterEach
    void quitBrowser() {
        driver.quit();
    }

    @Test
    @Description("Checking resume page experiences")
    @DisplayName("Checking resume page experiences")
    @Severity(SeverityLevel.CRITICAL)
    public void testResumeExperiences() throws IOException, ParseException {
        landingPage.navigateToLandingPage();
        landingPage.acceptTermsAndConditions();
        String userNameTestData = "lovasia";
        String passwordTestData = "kispal123";
        loginPage.login(userNameTestData, passwordTestData);
        landingPage.clickOnResumeButton();
        resumePage.clickOnExperiences();

        final Map<String,String> expectedResult=new HashMap<>();

        JSONParser parser = new JSONParser();
        Object obj = parser.parse(new FileReader("src/test/resources/resume_expected.json"));

        JSONArray solutions = (JSONArray) obj;
        for (Object solution : solutions) {
            String key =  ((JSONObject) solution).get("date").toString();
            String value = ((JSONObject) solution).get("company").toString();
            expectedResult.put(key, value);
        }
        Map<String,String> actualResult = resumePage.getAllExperiences();
        Assertions.assertEquals(expectedResult, actualResult);
    }
}
