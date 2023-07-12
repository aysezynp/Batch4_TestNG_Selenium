package com.kraftechnologie.tests.day18_ExtendReports;

import com.kraftechnologie.pages.LoginPage;
import com.kraftechnologie.tests.TestBase;
import com.kraftechnologie.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.module.Configuration;

public class WrongUserName extends TestBase {
    @Test
    public void wrongUserEmail() {
        LoginPage loginPage=new LoginPage();


        extentLogger=report.createTest("Wrong User Email Test");
        extentLogger.info("Go to Kraftech Login Pge");
        driver.get(ConfigurationReader.get("url"));

        extentLogger.info("Enter Wrong User Email");
        loginPage.emailInputBox.sendKeys("John@gmail.com");

        extentLogger.info("Enter User Password");
       loginPage.passwordInputBox.sendKeys("Jenni1234");

        extentLogger.info("Click login Button");
        loginPage.loginButton.click();

        String actualMessage=loginPage.userEmailErrorMessage.getText();
        extentLogger.info("Verify that NOt log in");
        Assert.assertEquals(actualMessage,"adress incorrect. Please check");
        Assert.assertEquals(actualMessage,"Email adress is incorrect. Please check");
        extentLogger.pass("PASSED");

    }

    @Test
    public void wrongPasswordTest() {
        LoginPage loginPage=new LoginPage();

        extentLogger=report.createTest("Wrong Password Test");

        extentLogger.info("Go to Kraftech Login page");
        driver.get(ConfigurationReader.get("url"));
        extentLogger.info("Enter valid user email");
        loginPage.emailInputBox.sendKeys("jennifer@gmail.com");
        extentLogger.info("Enter wrong user password");
        loginPage.passwordInputBox.sendKeys("wrong");
        extentLogger.info("Click login button");
        loginPage.loginButton.click();
        String actualMessage=loginPage.passwordErrorMessage.getText();
        extentLogger.info("Verify that NOT log in");
        Assert.assertEquals(actualMessage," password is incorrt. Please check"); //For fail
        //Assert.assertEquals(actualMessage,"Password is incorrect. Please check");
        extentLogger.pass("PASSED");
    }
}
