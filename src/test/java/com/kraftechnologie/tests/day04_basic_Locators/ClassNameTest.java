package com.kraftechnologie.tests.day04_basic_Locators;

import com.kraftechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ClassNameTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.krafttechexlab.com/");

        System.out.println("driver.findElement(By.className(\"pagetitle\")).getText() = " + driver.findElement(By.className("pagetitle")).getText());
        System.out.println("driver.findElement(By.className(\"footer\")).getText() = " + driver.findElement(By.className("footer")).getText());

        Thread.sleep(2000);
        driver.close();
    }
}
