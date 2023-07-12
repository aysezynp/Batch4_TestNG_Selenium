package com.kraftechnologie.tests.day17_pom3;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.kraftechnologie.pages.*;
import com.kraftechnologie.tests.TestBase;
import com.kraftechnologie.utilities.BrowserUtils;
import com.kraftechnologie.utilities.ConfigurationReader;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.module.Configuration;

public class AddEducationTest extends TestBase {

    @Test
    public void addEducationTest() {
        driver.get(ConfigurationReader.get("url"));
        LoginPage loginPage=new LoginPage();
        DashboardPage dashboardPage=new DashboardPage();
        UserProfilePage userProfilePage=new UserProfilePage();
        AddEducationPage addEducationPage=new AddEducationPage();
        OverviewPage overviewPage=new OverviewPage();

        loginPage.login();

        BrowserUtils.waitForVisibility(dashboardPage.userAccountName,5);

        dashboardPage.navigateToModule(dashboardPage.userAccountName.getText(),"My Profile");

        userProfilePage.navigateToOverViewMenu("Add Education");
        BrowserUtils.waitFor(1);

        addEducationPage.schoolBootcampBox.sendKeys("KraftTech Batch4");
        BrowserUtils.waitFor(1);

        addEducationPage.degreeCertificateBox.sendKeys("ISTQB");
        BrowserUtils.waitFor(1);

        addEducationPage.studyBox.sendKeys("Test Automation");
        BrowserUtils.waitFor(1);

        addEducationPage.fromDateBox.sendKeys("27.02.2023");
        BrowserUtils.waitFor(1);

        addEducationPage.toDateBox.sendKeys("20.06.2023");
        BrowserUtils.waitFor(1);

        addEducationPage.programDescriptionBox.sendKeys("Selenium, Test NG,Cucumber");
        BrowserUtils.waitFor(1);

        addEducationPage.addEducationBtn.click();
        BrowserUtils.waitFor(2);

        String control=overviewPage.controlOverviewTableCell("KraftTech Batch4");
        Assert.assertTrue(control.equals("KraftTech Batch4"));


    }
}
