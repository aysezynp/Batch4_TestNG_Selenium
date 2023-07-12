package com.kraftechnologie.tests.day14_properties_singleton;

import com.kraftechnologie.utilities.ConfigurationReader;
import com.kraftechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Properties_Test {

    @Test
    public void test1(){
        String browser= ConfigurationReader.get("browser");
        System.out.println(browser);
        String url=ConfigurationReader.get("url");
        System.out.println(url);
    }

    @Test
    public void test3() {
        WebDriver driver= WebDriverFactory.getDriver("chrome");

    }
}
