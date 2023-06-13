package com.kraftechnologie.tests.day03_webElement_Intro;

import com.kraftechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GetAttribute {
    public static void main(String[] args) throws InterruptedException {



        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://www.krafttechexlab.com/login");

        WebElement emailInputBox=driver.findElement(By.id("email"));

        // getAttribute>>>> give me attribute I will give you value
        String value=emailInputBox.getAttribute("class");
        System.out.println("value = " + value);
        Thread.sleep(2000);
        driver.close();


    }
}
