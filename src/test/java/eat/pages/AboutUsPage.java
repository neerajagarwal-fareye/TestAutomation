package eat.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AboutUsPage {
    WebDriver driver;

    public AboutUsPage(WebDriver driver){

        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//h2[normalize-space()='About Us']")
    WebElement aboutUsText;
    @FindBy(xpath = "//h2[normalize-space()='About Us']")
    WebElement aboutUsText1;
    @FindBy(xpath = "//h2[normalize-space()='About Us']")
    WebElement aboutUsText2;
    @FindBy(xpath = "//h2[normalize-space()='About Us']")
    WebElement aboutUsText3;







}
