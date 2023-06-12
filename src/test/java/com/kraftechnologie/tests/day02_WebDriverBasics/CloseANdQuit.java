package com.kraftechnologie.tests.day02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CloseANdQuit {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.firefoxdriver().setup();
        WebDriver driver=new FirefoxDriver();

        driver.navigate().to("https://www.krafttechexlab.com/");
        driver.manage().window().maximize();

        Thread.sleep(3000);

        //close the driver with close() method
        //close the current tab
        driver.close();


        WebDriverManager.chromedriver().setup();
        WebDriver driver1=new ChromeDriver();
        driver1.get("https://www.amazon.com");
        driver1.manage().window().maximize();

        Thread.sleep(3000);

        //close the driver with quit() method
        //close all the tabs
        driver1.quit();



    }
}
