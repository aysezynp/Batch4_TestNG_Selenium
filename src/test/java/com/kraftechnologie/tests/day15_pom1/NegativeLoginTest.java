package com.kraftechnologie.tests.day15_pom1;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.kraftechnologie.pages.LoginPage;
import com.kraftechnologie.tests.TestBase;
import com.kraftechnologie.utilities.ConfigurationReader;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NegativeLoginTest extends TestBase {

    @Test
    public void wrongPasswordTest() {
/**

 go to kraft login page
 provide right username
 provide wrong password
 tap on login button
 validate that "Password is incorrect. Please check" message appears
 */

        driver.get(ConfigurationReader.get("url"));
        LoginPage loginPages=new LoginPage();

//provide right username
        loginPages.emailInputBox.sendKeys(ConfigurationReader.get("userEmail"));

 //provide wrong username
        loginPages.passwordInputBox.sendKeys("wrong password");

 // tap on login Button
        loginPages.loginButton.click();

 //verification
         String expected="Password is incorrect. Please check";
         String actual=loginPages.passwordErrorMessage.getText();

        Assert.assertEquals(actual,expected);

    }

    @Test
    public void wrongUserName() {
/**
 go to kraft login page
 provide wrong username
 provide right password
 tap on login button
 validate that "Email address is incorrect. Please check" message appears
 */

        driver.get(ConfigurationReader.get("url"));
        LoginPage loginPages=new LoginPage();

        loginPages.emailInputBox.sendKeys("hilayse");

        loginPages.passwordInputBox.sendKeys(ConfigurationReader.get("userPassword"));

        loginPages.loginButton.click();

        //verification
        String expected="Email address is incorrect. Please check";
        String actual=loginPages.userEmailErrorMessage.getText();

        Assert.assertEquals(actual,expected);
    }

    @Test
    public void listOfWebElements(){
        /**

         login with Mike
         Verify that uptitles are following
         Dashboard
         Developers
         Components
         Forms
         JavaScript
         mike
         */

        driver.get(ConfigurationReader.get("url"));
        LoginPage loginPage=new LoginPage();

        loginPage.emailInputBox.sendKeys(ConfigurationReader.get("userEmail"));
        loginPage.passwordInputBox.sendKeys(ConfigurationReader.get("userPassword"));
        loginPage.loginButton.click();

        List<WebElement> upTitles = loginPage.upTitles;

        List<String>actualList=new ArrayList<>();

        for (WebElement upTitle : upTitles) {
            actualList.add(upTitle.getText());
        }

        List<String>expectedList=new ArrayList<>(Arrays.asList("Dashboard","Developers","Components","Forms","JavaScript","jennifer"));
        Assert.assertEquals(actualList,expectedList);
    }

 }


