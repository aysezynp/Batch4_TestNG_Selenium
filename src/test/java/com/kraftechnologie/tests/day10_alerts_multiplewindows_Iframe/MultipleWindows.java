package com.kraftechnologie.tests.day10_alerts_multiplewindows_Iframe;

import com.kraftechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class MultipleWindows {
    WebDriver driver;

    @BeforeMethod
    public void setUp() throws InterruptedException {
        driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://the-internet.herokuapp.com/windows");
        Thread.sleep(2000);
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void switchBetweenTwoWindows() throws InterruptedException {
               WebElement clickHereBtn = driver.findElement(By.xpath("//a[.='Click Here']"));
        clickHereBtn.click();

        Thread.sleep(2000);
        //switched between windows
        String currentWindow = driver.getWindowHandle();
        Set<String> windowHandles = driver.getWindowHandles();

        for (String windowHandle : windowHandles) {
            if (!currentWindow.equals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }

        }
        //verification
        WebElement newWindow = driver.findElement(By.xpath("//h3[.='New Window']"));
        String actual = newWindow.getText();
        String expected = "New Window";
        Assert.assertEquals(actual, expected);

    }
    @Test
    public void switchBetweenMultipleWindows(){
        WebElement clickHereBtn = driver.findElement(By.xpath("//a[.='Click Here']"));
        clickHereBtn.click();
        clickHereBtn.click();
        clickHereBtn.click();
        clickHereBtn.click();
        clickHereBtn.click();

        String expectedUrl="https://the-internet.herokuapp.com/windows/new";

        Set<String> windowHandles = driver.getWindowHandles();

        for (String windowHandle : windowHandles) {
            driver.switchTo().window(windowHandle);
            if (driver.getCurrentUrl().equals(expectedUrl)) {
                driver.switchTo().window(windowHandle);
                break;
            }

        }


    }


    }

