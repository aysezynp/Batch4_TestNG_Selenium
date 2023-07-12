package com.kraftechnologie.tests.day11_Waits;

import com.kraftechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ImplicitWait {
    WebDriver driver;

    @BeforeMethod
    public void setUp() throws InterruptedException {
        driver = WebDriverFactory.getDriver("chrome");
        //setup once,all the findElement that will use this wait
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);//buraya konması en doğrsusu çünkü bütün testlerdeki find elementler için çalışır

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void implicitWaitTest(){
      //  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);buraya yazınca da altındaki tüm web elementeler için geçerli oluyor.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        driver.findElement(By.cssSelector("#checkbox-example>button")).click();
        WebElement message = driver.findElement(By.id("message"));
        //driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS) buraya konulduğunda click kısmı için wait yapmıyor ve hata veriyor.
                                                                         // Buraya konulması sadece message elementi için geçerli oluyor.
        Assert.assertEquals(message.getText(),"It's gone!");
    }
}