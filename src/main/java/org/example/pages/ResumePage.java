package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ResumePage extends BasePage{
    //constructor
    ResumePage(WebDriver driver) {
        super(driver);
    }
    //locators
    private final By EXPERIENCES_BTN= By.xpath("//a[text()='Experiences']");
    private final By EXPERIENCE_CARDS=By.xpath("//div[@id='experience']/div[@class='resume__education_item']");

    //methods

    public void clickOnExperiences(){
        waitForElementVisibility(EXPERIENCES_BTN);
        driver.findElement(EXPERIENCES_BTN).click();
    }
    public Map<String,String> getAllExperiences(){
        List<WebElement> experienceCards=driver.findElements(EXPERIENCE_CARDS);
        Map<String,String> experienceResult=new HashMap<>();
        for (WebElement expCard:experienceCards){
            String key=expCard.findElement(By.xpath("./span")).getText();
            String value=expCard.findElement(By.xpath("./h4")).getText();
            experienceResult.put(key,value);
        }
        return experienceResult;
    }


}
