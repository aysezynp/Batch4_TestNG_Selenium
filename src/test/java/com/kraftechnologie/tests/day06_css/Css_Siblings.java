package com.kraftechnologie.tests.day06_css;

import com.kraftechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Css_Siblings {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://www.krafttechexlab.com/login");
        Thread.sleep(2000);

        WebElement emailBox= driver.findElement(By.cssSelector("label[for='email']~input"));
        emailBox.sendKeys("test@test.com");

        Thread.sleep(2000);
        driver.quit();

    }
}
