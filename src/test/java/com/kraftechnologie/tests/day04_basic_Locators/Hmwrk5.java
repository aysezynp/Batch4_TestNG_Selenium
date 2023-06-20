package com.kraftechnologie.tests.day04_basic_Locators;

import com.kraftechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Hmwrk5 {
    public static void main(String[] args) throws InterruptedException {
       /** Hw TASK 5
                * open chrome browser
         * go to https://demoqa.com/login
         * enter "test" into the username box
         * VERIFY that "test" is displayed in the username box
         * enter "Test.!123" into the password box
         * tap on login button
         * VERIFY that username is still "test"
                */

        String username="test";
        String password="Test.!123";
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.navigate().to("https://demoqa.com/login");
        driver.manage().window().maximize();

        driver.findElement(By.id("userName")).sendKeys(username);
        String expectedUsername="test";
        String actualUsername = driver.findElement(By.id("userName")).getAttribute("value");
        if(expectedUsername.equals(actualUsername)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
        }

        driver.findElement(By.id("password")).sendKeys(password);
        WebElement loginBtn= driver.findElement(By.id("login"));
        loginBtn.click();

        Thread.sleep(2000);
        String actualUserNameAfterLogin=driver.findElement(By.id("userName-value")).getText();
        if(expectedUsername.equals(actualUserNameAfterLogin)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
        }

        Thread.sleep(2000);
        driver.close();
    }
}
