package com.kraftechnologie.tests.day05_xpath;

import com.kraftechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RelativeXpath1 {
    public static void main(String[] args) throws InterruptedException {
        //go to amazon.com.tr
        //locate search bar with xpath
        //locate search button with xpath

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://www.amazon.com.tr");
        driver.manage().window().maximize();

        WebElement acceptCookies=driver.findElement(By.xpath("//input[@id='sp-cc-accept']"));
        acceptCookies.click();

        Thread.sleep(2000);

    //find the element with known attribute-value
       WebElement searchBar=driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));

    //find the element with known attribute-value
        WebElement searchBtn = driver.findElement(By.xpath("//input[@value='Git']"));
        Thread.sleep(2000);
        searchBar.sendKeys("Selenium");
        searchBtn.click();

        Thread.sleep(2000);
    //locate the web element
        WebElement seleniumElement=driver.findElement(By.xpath("//span[text()='\"Selenium\"']"));
        System.out.println(seleniumElement.getText());

        WebElement seleniumElement1=driver.findElement(By.xpath("//span[.='\"Selenium\"']"));
        System.out.println(seleniumElement1.getText());

        driver.quit();
    }
}
