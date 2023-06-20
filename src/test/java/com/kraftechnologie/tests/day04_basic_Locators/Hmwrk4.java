package com.kraftechnologie.tests.day04_basic_Locators;

import com.kraftechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Hmwrk4 {
    public static void main(String[] args) throws InterruptedException {
        /**
         * HW TASK 4
         * open chrome browser
         * go to https://demoqa.com/login
         * click on login button
         * VERIFY that url is not changed
         */

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://demoqa.com/login");
        String urlBeforeClick=driver.getCurrentUrl();
        System.out.println("urlBeforeClick = " + urlBeforeClick);

        Thread.sleep(2000);
        WebElement loginBtn= driver.findElement(By.id("login"));
        loginBtn.click();

        String urlAfterClick=driver.getCurrentUrl();
        System.out.println("urlAfterClick = " + urlAfterClick);

        if(urlBeforeClick.equals(urlAfterClick)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
        }

        Thread.sleep(2000);
        driver.close();
    }
}
