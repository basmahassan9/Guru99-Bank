package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.util.concurrent.TimeUnit;

public class baseTest {

    public WebDriver driver;
    public LoginPage login;

    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.gecko.driver", "Resources/geckodriver.exe");
        driver= new FirefoxDriver();
        goHome();
        driver.manage().window().maximize();
        driver.manage().timeouts()
                .implicitlyWait(20, TimeUnit.SECONDS);
        login = new LoginPage(driver);
    }
    @BeforeMethod
    public void goHome(){
        driver.get("https://clicks.aweber.com/y/ct/?l=9Mo7O&m=3_ACVc2oQoFEjy9&b=tHLgIc3uQtDlLtdyZ3vTDQ");
    }

    @AfterClass
    public void closeDriver(){
        driver.quit();
    }
}
