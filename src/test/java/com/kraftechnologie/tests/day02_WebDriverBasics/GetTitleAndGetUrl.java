package com.kraftechnologie.tests.day02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetTitleAndGetUrl {
    public static void main(String[] args) {
////TASK
//        //Open chrome and navigate to https://www.krafttechexlab.com/
//        //get title and display


        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(" https://www.krafttechexlab.com");
        //driver.navigate().to(" https://www.krafttechexlab.com");
        System.out.println("driver.getTitle() = " + driver.getTitle());

        //Getting the URL
        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());

        //getting the source code of the page
        System.out.println("driver.getPageSource() = " + driver.getPageSource());

    }
}