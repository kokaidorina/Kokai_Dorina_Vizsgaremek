package org.example.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class AboutPage extends BasePage{
    //constructor
    AboutPage(WebDriver driver) {
        super(driver);
    }
    //locators, test datas
    private final By ABOUT_HEADER= By.xpath("//div[@class='about_header mb-5']");
    private final By ABOUT_TEXT=By.xpath("//div[@class='mb-4 text-light']");

    //methods
    @Step("Get the text of the About section.")
    public String getAbout(){
        return driver.findElement(ABOUT_HEADER).getText()+"\n"+driver.findElement(ABOUT_TEXT).getText();
    }
    @Step("Count the file's lines")
    public int getNumberOfLines(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("src/test/resources/"+fileName));
        int lines = 0;
        while (reader.readLine() != null) lines++;
        reader.close();
        return lines;
    }
}
