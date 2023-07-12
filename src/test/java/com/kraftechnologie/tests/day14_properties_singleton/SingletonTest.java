package com.kraftechnologie.tests.day14_properties_singleton;

import com.kraftechnologie.utilities.ConfigurationReader;
import com.kraftechnologie.utilities.Driver;
import com.kraftechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class SingletonTest {

    @Test
    public void test1() {
        WebDriver driver1= WebDriverFactory.getDriver("chrome");
        driver1.get("https://www.amazon.com/");
        WebDriver driver2= WebDriverFactory.getDriver("chrome");
        driver2.findElement(By.cssSelector("twotabsearchbox"));

    }

    @Test
    public void test2() {
        String str1=Singleton.getInstance();
        String str2=Singleton.getInstance();
        System.out.println("str1 = " + str1);
    }

    @Test
    public void test3() {
        WebDriver driver= Driver.get();
        driver.get("https://www.amazon.com/");
        driver.get(ConfigurationReader.get("url"));
    }

    @Test
    public void test4() {
        //WebDriver driver=WebDriverFactory.getDriver("chrome");
        WebDriver driver=Driver.get();
        driver.get("https://www.google.com/");
        //Driver.get().get("https://www.google.com");

        Driver.closeDriver();
    }

    @Test
    public void test5() {
        //WebDriver driver=WebDriverFactory.getDriver("chrome");
        WebDriver driver=Driver.get();
        driver.get("https://www.amazon.com/");
    }
}
