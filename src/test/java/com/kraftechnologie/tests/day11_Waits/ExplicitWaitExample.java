package com.kraftechnologie.tests.day11_Waits;

import com.kraftechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class ExplicitWaitExample {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void setUp() throws InterruptedException {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        wait=new WebDriverWait(driver, Duration.ofSeconds(15));

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
@Test
    public void explicitWaitExample(){
    driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
    driver.findElement(By.cssSelector("#start>button")).click();

    //how to wait explicitly
   // WebDriverWait wait=new WebDriverWait(driver,15);

    WebElement hello = driver.findElement(By.xpath("//h4[text()='Hello World!']"));
    //it will wait up to 15 seconds until hello element is visible
    wait.until(ExpectedConditions.visibilityOf(hello));//Akıllı wait
    System.out.println("hello.getText() = " + hello.getText());
    Assert.assertEquals(hello.getText(),"Hello World!");
}
@Test
    public void explicitWaitTest2(){
    driver.get("https://the-internet.herokuapp.com/dynamic_controls");
    driver.findElement(By.xpath("//button[text()='Enable']")).click();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    // driver.findElement(By.cssSelector("input[type=\"text\"]")).sendKeys("Batch4 is here");

    WebElement inputBox = driver.findElement(By.cssSelector("input[type=\"text\"]"));
    wait.until(ExpectedConditions.elementToBeClickable(inputBox));
    inputBox.sendKeys("Batch4 is here now");

    WebElement message = driver.findElement(By.id("message"));
    Assert.assertEquals(message.getText(), "It's enabled!");
}

}
