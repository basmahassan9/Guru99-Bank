package Tests;

import base.baseTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utils.readXLFiles;


public class LoginTest extends baseTest {

    @Test(dataProviderClass = readXLFiles.class,dataProvider = "loginData")
    public void loginTest(String username, String password){


    login.addUserName(username);
    login.addPaddword(password);
    login.clickLoginBtn();
    SoftAssert soft = new SoftAssert();
    soft.assertEquals(login.getText(),"Welcome To Manager's Page of Guru99 Bank","wrong text");
    soft.assertEquals(driver.getCurrentUrl(),"https://www.demo.guru99.com/V4/manager/Managerhomepage.php","wrong URL");
    soft.assertAll();
    }
}
