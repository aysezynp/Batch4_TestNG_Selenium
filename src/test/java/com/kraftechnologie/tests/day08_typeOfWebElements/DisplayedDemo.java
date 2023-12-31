package com.kraftechnologie.tests.day08_typeOfWebElements;

import com.kraftechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DisplayedDemo {
    @Test
    public void displayedTest1() throws InterruptedException {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        WebElement startBtn=driver.findElement(By.cssSelector("#start>button"));

        WebElement hello= driver.findElement(By.xpath("//*[text()='Hello World!']"));
        System.out.println("hello.getText() = " + hello.getText());
        System.out.println("hello.isDisplayed() = " + hello.isDisplayed());

        Assert.assertFalse(hello.isDisplayed());

        startBtn.click();
        Thread.sleep(5000);
        Assert.assertTrue(hello.isDisplayed());
        System.out.println("hello.getText() = " + hello.getText());

        Thread.sleep(2000);
        driver.close();
    }
    @Test
    public void displayedTest2() throws InterruptedException {
        /**  HOME TASK
         https://the-internet.herokuapp.com/dynamic_loading
         Example 2: Element rendered after the fact -->click
         click that element
         verify that hello world is not displayed
         click start button
         verify that hello element is displayed
         and verify that "Hello World!" text is present
         */

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://the-internet.herokuapp.com/dynamic_loading");

        WebElement example2=driver.findElement(By.linkText("Example 2: Element rendered after the fact"));
        example2.click();

        WebElement hello=driver.findElement(By.xpath("//div[@id='content']/script"));
        //System.out.println("hello.isDisplayed() = " + hello.isDisplayed());
        Assert.assertFalse(hello.isDisplayed(),"Verify that \"Hello World\" is NOT displayed");
        System.out.println("hello.getText() = " + hello.getText());

        WebElement startBtn= driver.findElement(By.xpath("//button[text()='Start']"));
        startBtn.click();
        Thread.sleep(5000);

        WebElement helloAfterClick=driver.findElement(By.xpath("//h4[text()='Hello World!']"));
        Assert.assertTrue(helloAfterClick.isDisplayed(),"Verify that \"Hello World\" is displayed");
        System.out.println("helloAfterClick.getText() = " + helloAfterClick.getText());
        Assert.assertEquals(helloAfterClick.getText(),"Hello World!");

        Thread.sleep(2000);
        driver.close();
    }
}
