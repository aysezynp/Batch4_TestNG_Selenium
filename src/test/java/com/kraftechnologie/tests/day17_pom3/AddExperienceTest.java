package com.kraftechnologie.tests.day17_pom3;

import com.kraftechnologie.pages.*;
import com.kraftechnologie.tests.TestBase;
import com.kraftechnologie.utilities.BrowserUtils;
import com.kraftechnologie.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddExperienceTest extends TestBase {

    @Test
    public void addExperienceTest() {
        driver.get(ConfigurationReader.get("url"));

        LoginPage loginPage=new LoginPage();
        DashboardPage dashboardPage=new DashboardPage();
        UserProfilePage userProfilePage=new UserProfilePage();
        AddExperiencePage addExperiencePage=new AddExperiencePage();
        OverviewPage overviewPage=new OverviewPage();

        loginPage.login("jennifer@gmail.com","Jenni1234");

        BrowserUtils.waitForVisibility(dashboardPage.userAccountName,5);

        dashboardPage.navigateToModule(dashboardPage.userAccountName.getText(),"My Profile");

        userProfilePage.navigateToOverViewMenu("Add Experience");
        BrowserUtils.waitFor(1);

        addExperiencePage.jobTitleBox.sendKeys("QA Engineer");
        BrowserUtils.waitFor(1);

        addExperiencePage.companyBox.sendKeys("Krafttech");
        BrowserUtils.waitFor(1);

        addExperiencePage.locationBox.sendKeys("evka3");
        BrowserUtils.waitFor(1);

        addExperiencePage.fromDateBox.sendKeys("23.02.2023");
        BrowserUtils.waitFor(1);

        addExperiencePage.currentBox.click();
        BrowserUtils.waitFor(3);

        addExperiencePage.jobDescriptionBox.sendKeys("Testing browsers with Selenium");
        BrowserUtils.waitFor(1);

        addExperiencePage.addExperienceBtn.click();

        String actual=overviewPage.controlOverviewTableCell("QA Engineer");
        String expected="QA Engineer";

        Assert.assertEquals(actual,expected);








    }
}
