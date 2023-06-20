package com.kraftechnologie.tests.day04_basic_Locators;

import com.github.javafaker.Faker;
import com.kraftechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import javax.print.DocFlavor;

public class Hmwrk1 {
    public static void main(String[] args) throws InterruptedException {
        /** Class Task- Home work
         *  go to the url -  "https://www.browserstack.com/users/sign_up"
         *  maximize the window
         *  accept cookies if any ,
         *  fill in the blanks with the faker class
         *  click "Term of service" checkbox
         *  and close the window
         *
         *  hint: u can use any locator you want
         *
         */
        Faker faker = new Faker();

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.browserstack.com/users/sign_up");
        driver.manage().window().maximize();

        driver.findElement(By.id("accept-cookie-notification")).click();
        driver.findElement(By.name("user[full_name]")).sendKeys(faker.gameOfThrones().character());
        driver.findElement(By.id("user_email_login")).sendKeys(faker.internet().emailAddress());
        driver.findElement(By.id("user_password")).sendKeys(faker.internet().password());
        Thread.sleep(2000);
        driver.findElement(By.id("tnc_checkbox_link_terms_sso")).click();

        Thread.sleep(2000);
        driver.close();



    }
}
