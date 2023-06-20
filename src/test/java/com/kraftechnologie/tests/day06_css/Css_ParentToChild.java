package com.kraftechnologie.tests.day06_css;

import com.kraftechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Css_ParentToChild {
    public static void main(String[] args) throws InterruptedException {
        //xpath
        // '/' ..>parent to Child
        //css
        //'>' -->parent to child
        //xpath
        // '//' --> parent to grandson
        //css
        //' ' -->parent to grandson

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://www.krafttechexlab.com/login");
        Thread.sleep(2000);

        //parent to child
        WebElement email= driver.findElement(By.cssSelector(".col-12:nth-of-type(1)>label"));
        System.out.println("email.getText() = " + email.getText());

        WebElement loginBtn=driver.findElement(By.cssSelector(".row.g-3.needs-validation button"));
        System.out.println("loginBtn.getText() = " + loginBtn.getText());

        Thread.sleep(2000);
        driver.quit();
    }
}
