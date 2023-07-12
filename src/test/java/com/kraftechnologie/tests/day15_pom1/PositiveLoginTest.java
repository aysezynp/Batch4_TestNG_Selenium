package com.kraftechnologie.tests.day15_pom1;

import com.kraftechnologie.pages.LoginPage;
import com.kraftechnologie.tests.TestBase;
import com.kraftechnologie.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PositiveLoginTest extends TestBase {

    /**
     go to kraft login page
     login as Mike
     validate that you are on the dashboard with url*/

    @Test
    public void loginTest_1() throws InterruptedException {
        driver.get(ConfigurationReader.get("url"));

        //OLD WAY
       /*WebElement emailInputBox=driver.findElement(By.id("email"));
       WebElement passwordInputBox=  driver.findElement(By.id("yourPassword"));
       WebElement loginBtn= driver.findElement(By.xpath("//*[.='Login']"));

       emailInputBox.sendKeys("");
       passwordInputBox.sendKeys("");
       loginBtn.click();*/

        LoginPage loginPage=new LoginPage();

        WebElement emailBox = loginPage.emailInputBox;
        WebElement passwordBox = loginPage.passwordInputBox;
        WebElement login= loginPage.loginButton;

        emailBox.sendKeys(ConfigurationReader.get("userEmail"));
        passwordBox.sendKeys(ConfigurationReader.get("userPassword"));
        login.click();

        String actual=driver.getCurrentUrl();
        String expected="https://www.krafttechexlab.com/index";
        Assert.assertEquals(actual,expected);

        Thread.sleep(3000);

    }
    /**
     go to kraft login page
     login as Mike
     validate that you are on the dashboard with url
     use login(String username, String password)
     */

    @Test
    public void loginTest2() {
        driver.get(ConfigurationReader.get("url"));
        LoginPage loginPage = new LoginPage();

        //call login() method
        loginPage.login(ConfigurationReader.get("userEmail"), ConfigurationReader.get("userPassword"));

        String actual = driver.getCurrentUrl();
        String expected = "https://www.krafttechexlab.com/index";
        Assert.assertEquals(actual, expected);
    }


    @Test
    public void LoginTest3() {
/**

 go to kraft login page
 login as Mike
 use login()
 validate that you are on the dashboard with url
 */

        driver.get(ConfigurationReader.get("url"));
        LoginPage loginPage = new LoginPage();

        //call login() method
        loginPage.login();

        //assertion
        String actual = driver.getCurrentUrl();
        String expected = "https://www.krafttechexlab.com/index";
        Assert.assertEquals(actual, expected);

    }
}
