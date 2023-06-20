package com.kraftechnologie.tests.day06_css;

import com.kraftechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.security.PrivilegedExceptionAction;

public class Css_MulipleAttributeValue {
    public static void main(String[] args) throws InterruptedException {
        //go to https://www.krafttechexlab.com/forms/input

        //locate the Read Only/Disabled web element with multiple attribute-value by using css syntax
        //get the text and display



        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://www.krafttechexlab.com/forms/input");

        WebElement readOnly=driver.findElement(By.cssSelector("input[type='text'][value='Read only / Disabled']"));
        System.out.println("readOnly.getAttribute(\"value\") = " + readOnly.getAttribute("value"));

        WebElement readOnly1=driver.findElement(By.cssSelector("[type='text'][value='Read only / Disabled']"));
        System.out.println("readOnly1.getAttribute(\"value\") = " + readOnly1.getAttribute("value"));
        Thread.sleep(2000);
        driver.quit();
    }
}
