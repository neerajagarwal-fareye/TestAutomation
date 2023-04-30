package eat.pages;

import eat.utils.Util;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//img[@id='logo']")
    WebElement logo;
    @FindBy(xpath = "//input[@placeholder='Name*']")
    WebElement nameTextBox;
    @FindBy(xpath = "//input[@placeholder='Email*']")
    WebElement emailTextBox;
    @FindBy(xpath = "//input[@placeholder='Phone*']")
    WebElement phoneTextBox;
    @FindBy(xpath = "//textarea[@placeholder='Message*']")
    WebElement messageTextBox;
    @FindBy(xpath = "//input[@value='Submit']")
    WebElement submitButton;
    @FindBy(xpath = "(//div[contains(.,'Thank you for your message. It has been sent.')][@role=\"alert\"])[2]")
    WebElement alertAfterSubmit;
    @FindBy(xpath = "//ul[@id='top-menu']//a[normalize-space()='Blog']")
    WebElement blogMenu;



    public boolean checkIfHomePageLoaded(){
        return logo.isDisplayed();
    }

    public boolean checkIfThankYouMessageDisplayed(){
        return alertAfterSubmit.isDisplayed();
    }

    public void enterNameInTextBox(String input){
        nameTextBox.clear();
        nameTextBox.sendKeys(input);
    }

    public void enterEmailInTextBox(String input){
        emailTextBox.clear();
        emailTextBox.sendKeys(input);
    }

    public void enterPhoneInTextBox(String input){
        phoneTextBox.clear();
        phoneTextBox.sendKeys(input);
    }

    public void enterMessageInTextBox(String input){
        messageTextBox.clear();
        messageTextBox.sendKeys(input);
    }

    public void clickOnSubmitButton(){
        submitButton.click();
        Util.pauseExecution(2);
    }


    public void clickOnBlogMenu(){
        blogMenu.click();
        Util.pauseExecution(2);
    }









}
