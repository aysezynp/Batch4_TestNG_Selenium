package com.kraftechnologie.tests.day17_pom3;

import com.kraftechnologie.pages.DashboardPage;
import com.kraftechnologie.pages.LoginPage;
import com.kraftechnologie.tests.TestBase;
import com.kraftechnologie.utilities.ConfigurationReader;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class DashBoardTest2 extends TestBase {

    @Test
    public void verifyList(){

        driver.get(ConfigurationReader.get("url"));
        LoginPage loginpage=new LoginPage();
        loginpage.login();

        DashboardPage dashboardPage=new DashboardPage();

        String actual=dashboardPage.dashboard.getText();
        String expected="Dashboard";

        Assert.assertEquals(actual,expected);

        List<String> expectedList=new ArrayList<>();
        expectedList.add("DashBoard");
        expectedList.add("Developers");
        expectedList.add("Components");
        expectedList.add("Forms");
        expectedList.add("JavaScript");
        expectedList.add("mike");

        List<String> actualList=new ArrayList<>();
        
        for (WebElement upTitle : dashboardPage.upTitles) {
           actualList.add(upTitle.getText());

        }





    }
}
