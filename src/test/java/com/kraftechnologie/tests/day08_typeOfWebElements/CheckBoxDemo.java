package com.kraftechnologie.tests.day08_typeOfWebElements;

import com.kraftechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckBoxDemo {
    @Test
    public void checkboxDemo() throws InterruptedException {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://demoqa.com/automation-practice-form");
        WebElement sport= driver.findElement(By.cssSelector("[id='hobbies-checkbox-1']"));
        WebElement reading= driver.findElement(By.cssSelector("[id='hobbies-checkbox-2']"));
        WebElement music= driver.findElement(By.cssSelector("[id='hobbies-checkbox-3']"));
        Assert.assertFalse(sport.isSelected());
        Assert.assertFalse(reading.isSelected());

       // WebElement sportCheckBox=driver.findElement(By.xpath("//div[@id='hobbiesWrapper']/div[2]/div[1]"));
        WebElement sportCheckBox=driver.findElement(By.xpath("//div[@id='hobbiesWrapper']/div[2]//label"));
        sportCheckBox.click();
        Thread.sleep(2000);
        Assert.assertTrue(sport.isSelected());

        Thread.sleep(2000);
        driver.close();

    }

}
