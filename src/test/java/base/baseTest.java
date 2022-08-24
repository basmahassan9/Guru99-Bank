package base;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.LoginPage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.concurrent.TimeUnit;

public class baseTest {

    public WebDriver driver;
    public LoginPage login;
     private int count = 1;

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
    @AfterMethod
    public void recordFailure(ITestResult result){

        TakesScreenshot camera = (TakesScreenshot)driver;
            File screen = camera.getScreenshotAs(OutputType.FILE);
            try {

                Files.move(screen.toPath(), new File("Resources/screenshots/"+result.getName()+count+".png").toPath());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            count++;
            System.out.println("screen taken "+ screen.getAbsolutePath() );
    }

    @AfterClass
    public void closeDriver() throws InterruptedException {

        driver.quit();
    }
}
