package Tests;

import base.baseTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;



public class LoginTest extends baseTest {

    @Test
    public void loginTest(){
    login.addUserName("mngr432952");
    login.addPaddword("atUjUra");
    login.clickLoginBtn();
    SoftAssert soft = new SoftAssert();
    soft.assertEquals(login.getText(),"Welcome To Manager's Page of Guru99 Bank","wrong text");
    soft.assertEquals(driver.getCurrentUrl(),"https://www.demo.guru99.com/V4/manager/Managerhomepage.php","wrong URL");
    soft.assertAll();
    }
}
