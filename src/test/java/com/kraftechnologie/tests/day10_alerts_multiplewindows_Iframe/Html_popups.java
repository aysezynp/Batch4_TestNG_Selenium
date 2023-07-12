package com.kraftechnologie.tests.day10_alerts_multiplewindows_Iframe;


import com.kraftechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Html_popups {

    @Test
    public void htmlPopUpTest() throws InterruptedException {

       //go to http://primefaces.org/showcase/ui/overlay/confirmDialog.xhtml?jfwid=73437
        //tap on Confirm button
        //tap on yes
        //make verification

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("http://primefaces.org/showcase/ui/overlay/confirmDialog.xhtml?jfwid=73437");
        WebElement confirmButton=driver.findElement(By.xpath("(//span[text()='Confirm'])[1]"));
        confirmButton.click();

        Thread.sleep(2000);
        WebElement yesBtn=driver.findElement(By.xpath("//span[.='Yes']"));
        yesBtn.click();
        Thread.sleep(2000);

        WebElement confirmation=driver.findElement(By.xpath("//p[.='You have accepted']"));

        //make verification
        String actual=confirmation.getText();
        String expected="You have accepted";
        Assert.assertEquals(actual,expected);

        Thread.sleep(2000);
        driver.quit();
    }

    }

