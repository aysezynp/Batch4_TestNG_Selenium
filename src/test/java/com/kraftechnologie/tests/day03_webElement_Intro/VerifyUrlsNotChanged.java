package com.kraftechnologie.tests.day03_webElement_Intro;

import com.kraftechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VerifyUrlsNotChanged {

        public static void main(String[] args) throws InterruptedException {

            /**Class Task
             * open the chrome browser
             * go to page
             * click on Login Button
             * verify that url did not changed
             *
             */

            WebDriver driver = WebDriverFactory.getDriver("chrome"); //empty browser
            driver.get("https://www.krafttechexlab.com/login");

            String expectedUrl=driver.getCurrentUrl();
            System.out.println("expectedUrl = " + expectedUrl);


            //click on Login button
            WebElement loginBtn=driver.findElement(By.cssSelector("[type=\"submit\"]"));
            loginBtn.click();

            String actualUrl= driver.getCurrentUrl();
            System.out.println("actualUrl = " + actualUrl);

            if(expectedUrl.equals(actualUrl)){
                System.out.println("PASS");
            }else{
                System.out.println("FAIL");
            }

            Thread.sleep(5000);
            driver.close();

        }

    }

