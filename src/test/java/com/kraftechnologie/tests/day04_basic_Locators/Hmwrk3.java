package com.kraftechnologie.tests.day04_basic_Locators;

import com.kraftechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Hmwrk3 {
    public static void main(String[] args) throws InterruptedException {
        /** HW TASK 3
                * open chrome browser
         * go to https://demoqa.com/login
         * enter "test" into the username box
         * enter "Test.!123" into the password box
         * tap on login button
         * VERIFY that url is changed as "https://demoqa.com/profile"
                */

        String username="test";
        String password="Test.!123";
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.navigate().to("https://demoqa.com/login");
        driver.manage().window().maximize();

        driver.findElement(By.id("userName")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);

        Thread.sleep(2000);
        WebElement loginBtn= driver.findElement(By.id("login"));
        loginBtn.click();

        String expectedUrl="https://demoqa.com/profile";
        Thread.sleep(2000);
        String actualUrl=driver.getCurrentUrl();
        System.out.println(actualUrl);

        if(actualUrl.equals(expectedUrl)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
        }
        Thread.sleep(2000);
        driver.close();
    }
}
