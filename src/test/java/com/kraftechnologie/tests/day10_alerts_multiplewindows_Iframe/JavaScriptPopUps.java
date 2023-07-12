package com.kraftechnologie.tests.day10_alerts_multiplewindows_Iframe;

import com.kraftechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JavaScriptPopUps {

    WebDriver driver;

    @BeforeMethod
    public void setUp() throws InterruptedException {
        driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        Thread.sleep(2000);
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void test_jsPopUp_Accept() throws InterruptedException {

    WebElement clickForJsAlert=driver.findElement(By.xpath("//button[.='Click for JS Alert']"));
    clickForJsAlert.click();

    Thread.sleep(2000);

    Alert alert=driver.switchTo().alert();//driver objesi üzerinde oluşturyoruz
   //tap Ok button
    alert.accept();

   //verification
        String actual=driver.findElement(By.cssSelector("#result")).getText();
        String expected="You successfully clicked an alert";
        Assert.assertEquals(actual,expected);
    }

    @Test
    public void jsPopUp_dismiss() throws InterruptedException {
    //tap on click
        WebElement clickforJSConfirm = driver.findElement(By.xpath("//button[.='Click for JS Confirm']"));
        clickforJSConfirm.click();

        Thread.sleep(2000);

        Alert alert = driver.switchTo().alert();//driver objesi üzerinde oluşturyoru
    // tap Ok button
        alert.dismiss();

        String actual = driver.findElement(By.cssSelector("#result")).getText();
        String expected = "You clicked: Cancel";
        Assert.assertEquals(actual, expected);
    }
    @Test
    public void jsPopup_SendKeys() throws InterruptedException {
        WebElement clickForJsPrompt = driver.findElement(By.xpath("//button[.='Click for JS Prompt']"));
        clickForJsPrompt.click();

        Thread.sleep(2000);

        Alert alert=driver.switchTo().alert();
        String text="Alperen";
        alert.sendKeys(text);

        Thread.sleep(2000);

        alert.accept();

        String actual = driver.findElement(By.cssSelector("#result")).getText();
        String expected= "You entered: " +text;
        Assert.assertEquals(actual,expected);

    }
}
