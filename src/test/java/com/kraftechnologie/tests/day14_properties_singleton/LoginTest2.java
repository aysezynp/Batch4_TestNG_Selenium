package com.kraftechnologie.tests.day14_properties_singleton;

import com.kraftechnologie.tests.TestBase;
import com.kraftechnologie.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class LoginTest2 extends TestBase {
    @Test
    public void test1() {
        driver.get(ConfigurationReader.get("url1"));
        driver.findElement(By.id("userName")).sendKeys(ConfigurationReader.get("userName"));
        driver.findElement(By.id("password")).sendKeys(ConfigurationReader.get("password")+ Keys.TAB+Keys.ENTER);

    }
}
