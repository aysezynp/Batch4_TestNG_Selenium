package com.kraftechnologie.tests.day04_basic_Locators;

import com.kraftechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ClassNameTest {
    public static void main(String[] args) throws InterruptedException {


        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("http://www.krafttechexlab.com/");


        System.out.println("driver.findElement(By.className(\"pagetitle\")).getText() = " + driver.findElement(By.className("pagetitle")).getText());
        System.out.println("driver.findElement(By.className(\"footer\")).getText() = " + driver.findElement(By.className("footer")).getText());


        // CSS de doğrulama yapınca elementi görümüyor, arasındaki boşluklardan dolayı 4 class varmış gibi algılıyor ve tanımıyor
                                 //By.classname i doğrulama başına nokta koyarak
        //if there is a space in the className locator we can not use clasName locator -> NoSuchElementException
        // System.out.println("driver.findElement(By.className(\"header fixed-top d-flex align-items-center header-scrolled\")).getText() = " + driver.findElement(By.className("header fixed-top d-flex align-items-center header-scrolled")).getText());


        Thread.sleep(2000);
        driver.close();

    }
}
