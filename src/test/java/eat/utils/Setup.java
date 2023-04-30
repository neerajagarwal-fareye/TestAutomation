package eat.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Setup {

    public static WebDriver driver;

    public static WebDriver launchBrowser(String browserName){
        if (browserName.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver", "resources/drivers/chromedriver");
            driver = new ChromeDriver();
        }else  if (browserName.equalsIgnoreCase("firefox")){
            System.setProperty("webdriver.firefox.driver", "resources/drivers/geckodriver");
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
