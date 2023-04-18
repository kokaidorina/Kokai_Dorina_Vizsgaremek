package org.example.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage extends BasePage{
    //constructor
    ContactPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    //locators, test datas
    private final By GET_IN_TOUCH_BTN= By.xpath("//div[@class='footer__cta_action']/a[@href='https://lennertamas.github.io/portio/contact']");
    private final By MESSAGE=By.id("contact-form-status");
    /*private final By NAME_CONTACT_FORM=By.xpath("//input[@name='Name']");
    private final By EMAIL_CONTACT_FORM=By.xpath("//input[@name='email']");
    private final By MESSAGE_CONTACT_FORM=By.id("message");
    private final By AGREEMENT_CHECKBOX=By.id("aggrement");
    private final By SEND_MESSAGE_BTN=By.xpath("//button[text()='Send Message']");*/

    @FindBy(xpath ="//input[@name='Name']" )
    WebElement nameInput;

    @FindBy(xpath ="//input[@name='email']" )
    WebElement emailInput;

    @FindBy(id ="message" )
    WebElement messageInput;

    @FindBy(id="aggrement" )
    WebElement agreementCheckBox;
    @FindBy(xpath ="//button[text()='Send Message']" )
    WebElement sendMessageButton;

    @Step("Click on 'Get in touch' button.")
    public void clickOnGetInTouch(){
        waitForElementVisibility(GET_IN_TOUCH_BTN);
        driver.findElement(GET_IN_TOUCH_BTN).click();
    }
    @Step("Fill the contact form with {name}, {email}, {message} and send it. ")
    public void fillContactForm(String name, String email, String message){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,600)", "");
        nameInput.sendKeys(name);
        emailInput.sendKeys(email);
        messageInput.sendKeys(message);
        if(!agreementCheckBox.isSelected()){
            agreementCheckBox.click();
        }
        sendMessageButton.click();
    }
    @Step("Validating if the message is sent")
    public boolean isMessageSent(){
        if(driver.findElement(MESSAGE).isDisplayed()){
            return true;
        }
        else return false;
    }
}
