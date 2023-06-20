package com.kraftechnologie.tests.day04_basic_Locators;

import com.kraftechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NameDublicateTest {
    public static void main(String[] args) throws InterruptedException {
        /** this class for explaining that
         * When the name locator is duplicated,
         * only the first element is selected
         * but does NOT work
         *
         */

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://demo.aspnetawesome.com/");

        Thread.sleep(3000);
        //How to click the Cookies
        driver.findElement(By.id("btnCookie")).click();

        Thread.sleep(2000);
        System.out.println("driver.findElement(By.name(\"itemParentCat\")).getText() = " + driver.findElement(By.name("itemParentCat")).getText());
        Thread.sleep(3000);
        driver.close();

        driver.findElement(By.id("btnCookie")).click();
    }
}
