package com.kraftechnologie.tests.day13_webTables;

import com.kraftechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class NewWebTables {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        driver.get("https://webdriveruniversity.com/Data-Table/index.html");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void printTAble() {
        // Print Whole Table
        WebElement table = driver.findElement(By.xpath("//table[@id='t01']"));//locate the whole table
        System.out.println("table.getText() = " + table.getText());
    }
}
