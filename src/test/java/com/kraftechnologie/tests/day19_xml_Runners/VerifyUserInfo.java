package com.kraftechnologie.tests.day19_xml_Runners;

import com.kraftechnologie.pages.EditProfilePage;
import com.kraftechnologie.pages.LoginPage;
import com.kraftechnologie.pages.UserProfilePage;
import com.kraftechnologie.tests.TestBase;
import com.kraftechnologie.utilities.ConfigurationReader;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyUserInfo extends TestBase {
    /**
     * Class Task
     * <p>
     * Login as a mike
     * Verify that login is successful
     * Click on My profile
     * Click on Edit Profile
     * Verify that job is SDET
     */


    @Test
    public void VerifyUserInfo() {
        extentLogger = report.createTest("User Info Test");
        LoginPage loginPage = new LoginPage();
        UserProfilePage userProfilePage=new UserProfilePage();
        EditProfilePage editProfilePage=new EditProfilePage();


        extentLogger.info("Go to Kraftech Login page");
        driver.get(ConfigurationReader.get("url"));

        extentLogger.info("Login as jennifer");
        loginPage.login();

        extentLogger.info("Verify that you are on the home page by using jennifer");
        //String actual = loginPage.userAccountName.getText();
        String actual=loginPage.getUserAccountName();
        Assert.assertEquals(actual, "jennifer");

        extentLogger.info("Click on My Profile");
        loginPage.navigateToModule("jennifer", "My Profile");

        extentLogger.info("Click on Edit Profile");
        userProfilePage.navigateToOverViewMenu("Edit Profile");


        extentLogger.info("Verify that the job is Select Professional Statusu");
        String expectedJob="Select Professional Statusu";
        String actualJob=editProfilePage.getSelectedJob();
        Assert.assertEquals(actualJob,expectedJob);

        extentLogger.pass("PASSED");

    }
}