package org.example.pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BlogPageTest {
    WebDriver driver;
    private LandingPage landingPage;
    private LoginPage loginPage;
    private BlogPage blogPage;


    @BeforeEach
    void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = BaseTest.getWebDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        landingPage = new LandingPage(driver);
        loginPage=new LoginPage(driver);
        blogPage=new BlogPage(driver);
    }
    @AfterEach
    void quitBrowser() {
        driver.quit();
    }

    @Description("Reading a file and making a list of it.")
    public List<String> readFile() {
        List<String> namesList = new ArrayList<>();
        try {
            File text = new File("src/test/resources/BlogPosts.txt");
            Scanner names = new Scanner(text);

            while (names.hasNextLine()) {
                String name = names.nextLine();
                namesList.add(name);
            }

        } catch (Exception e) {
            System.out.println("File not found");
        }
        return namesList;
    }
    @Test
    @Epic("Portio website")
    @Description("Blog article's titles comparing with a file.")
    @DisplayName("Blog article's titles comparing with a file.")
    @Severity(SeverityLevel.NORMAL)
    public void testBlogArticlesTitle() throws InterruptedException {
        landingPage.navigateToLandingPage();
        landingPage.acceptTermsAndConditions();
        String userNameTestData="lovasia";
        String passwordTestData="kispal123";
        loginPage.login(userNameTestData, passwordTestData);
        Thread.sleep(2000);
        loginPage.clickOnBlogButton();
        blogPage.clickSeeAllPostButton();
        Thread.sleep(2000);
        List<String> actualResult=blogPage.getAllBlogPost();
        List<String> expectedResult=readFile();
        Assertions.assertEquals(expectedResult, actualResult);
    }

}
