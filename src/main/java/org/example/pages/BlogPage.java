package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
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

    public void clickSeeAllPostButton() {
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(SEE_ALL_BUTTON)).click();
    }
    public List<String> getAllBlogPost() throws InterruptedException {
        List<String> articleTitles = new ArrayList<>();
        int pages = driver.findElements(PAGES).size() - 1;
        do {
            Thread.sleep(5000);
            List<WebElement> blogArticles = driver.findElements(BLOG_ARTICLES);
            for (WebElement article : blogArticles) {
                Actions actions=new Actions(driver);
                actions.moveToElement(article).build().perform();
                String articleTitle = article.findElement(By.xpath(".//h5/a")).getText();
                articleTitles.add(articleTitle);
            }
           if (pages!=1) {
               driver.findElement(NEXT_PAGE_BUTTON).click();
            }
            pages-=1;
        }
        while (pages > 0);
        return articleTitles;
    }
}
