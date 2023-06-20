package com.kraftechnologie.tests.day03_webElement_Intro;

import com.kraftechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VerifyUserNameIsCorrect {
    public static void main(String[] args) throws InterruptedException {
        /** Class Task 3
         * open chrome browser
         * go to https://www.krafttechexlab.com/login  page
         * enter email as mike@gmail.com
         * enter password as mike1234
         * click login button
         * verify that username is "mike"
         *///verify that home page is "DashBoard"


        String email="mike@gmail.com";
        String password="mike1234";
        String expectedprofilUserName="Mike";

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://www.krafttechexlab.com/login");

        //enter e mail by lazy way
        driver.findElement(By.id("email")).sendKeys(email);

        //enter password by lazy way
        driver.findElement(By.id("yourPassword")).sendKeys(password);

        //click login btn
        driver.findElement(By.cssSelector("[type=\"submit\"]")).click();

       WebElement profilUserName=driver.findElement(By.cssSelector("[class=\"d-none d-md-block dropdown-toggle ps-2\"]"));
        //2 ways to get text from web element
        //1. getText() -> it will work %99 , it will return string
        //2. getAttribute("") --> second way of getting text especially


        String actualprofilUserName=profilUserName.getText();

        if(expectedprofilUserName.equals(actualprofilUserName)){
            System.out.println("PAss");
        }else{
            System.out.println("FAIL");
        }

        Thread.sleep(2000);
        driver.close();

    }
}
