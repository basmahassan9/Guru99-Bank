package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;

public class baseTest {

    public WebDriver driver;
    public LoginPage login;

    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.gecko.driver", "Resources/geckodriver.exe");
        driver= new FirefoxDriver();
        driver.get("https://clicks.aweber.com/y/ct/?l=9Mo7O&m=3_ACVc2oQoFEjy9&b=tHLgIc3uQtDlLtdyZ3vTDQ");
        driver.manage().window().maximize();
        login = new LoginPage(driver);
    }


    @AfterClass
    public void closeDriver(){
        driver.quit();
    }
}
