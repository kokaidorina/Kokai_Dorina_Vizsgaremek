package org.example.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import java.util.ArrayList;
import java.util.List;

public class BlogPage extends BasePage {
    //constructor
    BlogPage(WebDriver driver) {
        super(driver);
    }

    //locators, test datas
    private final By SEE_ALL_BUTTON = By.xpath("//div[@class='blog-preview__header_button desktop']/a[text()='See all post']");
    private final By NEXT_PAGE_BUTTON = By.xpath("//a[@rel='next']");
    private final By BLOG_ARTICLES = By.xpath("//div[@class='col-lg-4']/div[@class='blog-page__item']");
    private final By PAGES = By.xpath("//ul[@class='pagination justify-content-center pagination-lg']/li");

    //methods
    @Step("Click on 'See all posts' button")
    public void clickSeeAllPostButton() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(SEE_ALL_BUTTON).click();
    }
    @Step("Returning a List of all blog article's titles.")
    public List<String> getAllBlogPost() throws InterruptedException {
        List<String> articleTitles = new ArrayList<>();
        int pages = driver.findElements(PAGES).size() - 1;
        Actions actions = new Actions(driver);
        do {
            Thread.sleep(5000);
            List<WebElement> blogArticles = driver.findElements(BLOG_ARTICLES);
            for (WebElement article : blogArticles) {
                actions.moveToElement(article).build().perform();
                String articleTitle = article.findElement(By.xpath(".//h5/a")).getText();
                articleTitles.add(articleTitle);
            }
            if (pages != 1) {
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("window.scrollBy(0,500)", "");
                actions.moveToElement(driver.findElement(NEXT_PAGE_BUTTON)).click(driver.findElement(NEXT_PAGE_BUTTON)).build().perform();
            }
            pages -= 1;
        }
        while (pages > 0);
        return articleTitles;
    }

}
