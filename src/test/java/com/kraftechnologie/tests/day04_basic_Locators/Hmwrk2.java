package com.kraftechnologie.tests.day04_basic_Locators;

import com.kraftechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Hmwrk2 {
    public static void main(String[] args) throws InterruptedException {
        /** Class Task
         *  go to the amazon webpage
         *  write "selenium" to search box
         *  verify that the result of the search
         */

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://www.amazon.com/");
        driver.manage().window().maximize();

        driver.findElement(By.name("field-keywords")).sendKeys("selenium");
        driver.findElement(By.id("nav-search-submit-button")).click();

        String actualText = driver.findElement(By.cssSelector(".a-color-state.a-text-bold")).getText();
        String expectedText="selenium";

        if(actualText.contains(expectedText)){
            System.out.println("PASS");
        }else {
            System.out.println("FAIL");
        }

        Thread.sleep(2000);
        driver.close();

    }
}
