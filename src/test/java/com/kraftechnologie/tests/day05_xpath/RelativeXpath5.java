package com.kraftechnologie.tests.day05_xpath;

import com.kraftechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RelativeXpath5 {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://www.krafttechexlab.com/forms/input");
        Thread.sleep(3000);

        //1.parent to child >>> xpath/xpath
        WebElement home=driver.findElement(By.xpath("//div[@class='row mb-3'][1]/label"));
        System.out.println("home.getText() = " + home.getText());

        //2.child to Parent >>> xpath/..
        WebElement home2=driver.findElement(By.xpath("(//input[@type='text'])[1]/../../label"));
        System.out.println("home2.getText() = " + home2.getText());

        //3.from sibling to previous sibling >>> xpath/preceding-sibling::*
        WebElement home3=driver.findElement(By.xpath("(//div[@class='col-sm-10'])[1]/preceding-sibling::*"));
        System.out.println("home3.getText() = " + home3.getText());

        //4.from parent to grandson >>> xpath//xpath
        WebElement home4=driver.findElement(By.xpath("(//form[@method='post']//label)[1]"));
        System.out.println("home4.getText() = " + home4.getText());

        driver.quit();
    }
}
