package com.kraftechnologie.tests.day02_WebDriverBasics;

import com.kraftechnologie.utilities.WebDriverFactory;
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

        class closeExeptionTest {
            public static void main(String[] args) throws InterruptedException {
                //added in day 4 class
                WebDriver driver = WebDriverFactory.getDriver("chrome");

                driver.get("https://www.google.com/");

                Thread.sleep(2000);

                //close current tab
                driver.close();

                //giving new browser tab
                driver=new ChromeDriver(); // if we don't give -> invalid session ID Exception
                driver.get("https://www.facebook.com/");

            }


        }







