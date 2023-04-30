package eat.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BlogPage {

    WebDriver driver;

    public BlogPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//h2[normalize-space()='Blog']")
    WebElement blogTextOnPage;
    @FindBy(xpath = "//a[normalize-space()='Advantageous Landscape of Integrating IoT and ERP']")
    WebElement blogListed;



    public boolean checkIfBlogPageLoaded(){
        return blogTextOnPage.isDisplayed();
    }

    public boolean checkIfBlogIsAvailableOnBlogPage(){
        return blogListed.isDisplayed();
    }


}
