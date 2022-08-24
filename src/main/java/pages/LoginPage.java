package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;
    public LoginPage(WebDriver driver){
        this.driver = driver;
    }
    public void addUserName(String username){
        driver.findElement(By.name("uid")).sendKeys(username);
    }
    public void addPassword(String pass){
        driver.findElement(By.name("password")).sendKeys(pass);
    }
    public void clickLoginBtn(){
        driver.findElement(By.name("btnLogin")).click();
    }

    public String getText(){
       return driver.findElement(By.xpath("//tr[@class=\"heading3\"]")).getText();
    }

    public void confirmAlert(){
        driver.switchTo().alert().accept();
    }
    public String getAlertMsg(){

        return driver.switchTo().alert().getText();
    }
}
