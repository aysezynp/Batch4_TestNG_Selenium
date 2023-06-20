package com.kraftechnologie.tests.day05_xpath;

import com.kraftechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RelativeXpath4 {
    public static void main(String[] args) throws InterruptedException {

//go to "https://www.krafttechexlab.com/components/modal"

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://www.krafttechexlab.com/components/modal");
        Thread.sleep(2000);

 //get the WebElement by using
        WebElement basicModal= driver.findElement(By.xpath("//button[@type='button' and @data-bs-target='#basicModal']"));
        System.out.println("basicModal.getText() = " + basicModal.getText());

        WebElement basicModal1= driver.findElement(By.xpath("//button[@type='button'][@data-bs-target='#basicModal']"));
        System.out.println("basicModal1.getText() = " + basicModal1.getText());

        //OR LOGIC
        //go to https://www.krafttechexlab.com/components/tabs
        driver.get("https://www.krafttechexlab.com/components/tabs");


     driver.quit();
    }
}
