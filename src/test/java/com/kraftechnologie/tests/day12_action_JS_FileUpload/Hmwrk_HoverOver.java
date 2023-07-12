package com.kraftechnologie.tests.day12_action_JS_FileUpload;

import com.kraftechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Hmwrk_HoverOver {

/**  Hover class Task
 *      go to https://the-internet.herokuapp.com/hovers url
 *      and get "view profile" elements' text (all of them)
 *      and verify element is displayed (one by one)
 *
 *      hind: Use list and for loop
 */

    WebDriver driver;
    Actions action;

    @BeforeMethod
    public void setUp() throws InterruptedException {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        action=new Actions(driver);

    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void hoverOver() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/hovers");
        List<WebElement> images= driver.findElements(By.xpath("//img[@src='/img/avatar-blank.jpg']"));
        System.out.println(images.size());


        for (int i = 0; i < images.size(); i++) {
            Thread.sleep(2000);
            action.moveToElement(images.get(i)).perform();
            WebElement viewProfile = driver.findElement(By.linkText("View profile"));
            Assert.assertTrue(viewProfile.isDisplayed());

        }
    }
}