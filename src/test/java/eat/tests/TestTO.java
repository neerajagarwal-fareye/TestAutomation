package eat.tests;

import eat.pages.BlogPage;
import eat.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestTO {

    public static Properties prop = new Properties();
    public static WebDriver driver = null;
    public static HomePage homePage;
    public static BlogPage blogPage;



    public TestTO(){
        try {
            FileInputStream file = new FileInputStream(System.getProperty("user.dir")+File.separator+"resources"+File.separator+"testdata"+File.separator+"config.properties");
            prop.load(file);
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        } catch(IOException e1) {
            e1.printStackTrace();
        }
    }


    @BeforeClass(alwaysRun = true)
    public static void tearUp(){
        launchBrowser(prop.getProperty("browserName"));
        driver.get(prop.getProperty("url"));
        homePage = new HomePage(driver);
        blogPage = new BlogPage(driver);
    }

    @Test(priority = 1, groups = {"Sanity"})
    public static void verifyIfTheApplicationHasLaunch(){
        Assert.assertTrue(homePage.checkIfHomePageLoaded());
    }

    @Test(priority = 2, groups = {"Sanity"})
    public static void verifyFormCanSubmitSuccssfully(){
        homePage.enterNameInTextBox(prop.getProperty("username"));
        homePage.enterEmailInTextBox(prop.getProperty("emailId"));
        homePage.enterPhoneInTextBox(prop.getProperty("phoneNumber"));
        homePage.enterMessageInTextBox("test");
//        homePage.clickOnSubmitButton();
//        Assert.assertTrue(homePage.checkIfThankYouMessageDisplayed());
    }

    @Test(priority = 3)
    public static void verifyBlogPageIsLoadingSuccessfully(){
        homePage.clickOnBlogMenu();
        Assert.assertTrue(blogPage.checkIfBlogPageLoaded());
    }

    @Test(priority = 4)
    public static void verifyIfBlogsAreListedOnBlogPage() {
//        homePage.clickOnBlogMenu();
//        Assert.assertTrue(blogPage.checkIfBlogIsAvailableOnBlogPage());
        Assert.assertTrue(false);

    }

    @Test(priority = 5)
    public static void verifyIfSettingPageIsLoading() {
        Assert.assertTrue(false);
    }

    @Test(priority = 6, groups = {"Sanity"})
    public static void verifyIfContactUsPageIsLoading() {
        Assert.assertTrue(true);

    }

    @Test(priority = 8)
    public static void verifyIfCareerPageIsLoading() {
        Assert.assertTrue(true);

    }

    @Test(priority = 9, groups = {"Sanity"})
    public static void verifyIfRequestPageIsLoading() {
        Assert.assertTrue(false);

    }

    @Test(priority = 10)
    public static void verifyIfResourcePageIsLoading() {
        Assert.assertTrue(true);

    }

    @Test(priority = 11)
    public static void verifyIfServicePageIsLoading() {
        Assert.assertTrue(true);

    }




    @AfterClass(alwaysRun = true)
    public static void tearDown(){
        driver.quit();
    }















    public static WebDriver launchBrowser(String browserName){
        if (browserName.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver", "resources/drivers/chromedriver");
            driver = new ChromeDriver();
        }else  if (browserName.equalsIgnoreCase("firefox")){
            System.setProperty("webdriver.gecko.driver", "resources/drivers/geckodriver");
            driver = new FirefoxDriver();
        }else if (browserName.equalsIgnoreCase("edge")){

        }else if (browserName.equalsIgnoreCase("safari")){

        }else if (browserName.equalsIgnoreCase("opera")) {

        }else {
            System.setProperty("webdriver.chrome.driver", "resources/drivers/chromedriver");
            driver = new ChromeDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        return driver;
    }

}
