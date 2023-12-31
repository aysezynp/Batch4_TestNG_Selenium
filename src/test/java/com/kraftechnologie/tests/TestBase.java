package com.kraftechnologie.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.beust.ah.A;
import com.kraftechnologie.utilities.BrowserUtils;
import com.kraftechnologie.utilities.ConfigurationReader;
import com.kraftechnologie.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

    public class TestBase {
    protected WebDriver driver;
    protected Actions action;

        // this class is used for starting and building reports
        protected ExtentReports report;

        //this class is esud to create html report file
        protected ExtentHtmlReporter htmlReporter;

        //this will define a test, enable adding logs, authors and test steps
        protected ExtentTest extentLogger;

        @BeforeTest
        public void setUpTest(){
            //initialize the class
            report=new ExtentReports();
            //create a report path
            String projectPath=System.getProperty("user.dir");

            /**
             * //to take dynamic report
             * String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
             * String path=projectPath+"/test-output/report."+date+"html";
              */

            String path=projectPath+"/test-output/report.html";

            // initialize the html report with the report path
            htmlReporter=new ExtentHtmlReporter(path);

            //attach the html report to the report object
            report.attachReporter(htmlReporter);

            //title in report
            htmlReporter.config().setReportName("Kraftech smoke test ");

            // set environment information
            report.setSystemInfo("Environment","Production");
            report.setSystemInfo("Browser", ConfigurationReader.get("browser"));
            report.setSystemInfo("OS",System.getProperty("os.name"));
            report.setSystemInfo("Test Engineer","FT");
        }

        @AfterTest
        public void tearDownTest(){
            report.flush(); // this is when the report is actually created
        }


    @BeforeMethod
    public void setUp() throws InterruptedException {
        driver= Driver.get();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        action=new Actions(driver);

    }

    @AfterMethod
    public void tearDown(ITestResult result) throws InterruptedException, IOException {
            if(result.getStatus()==ITestResult.FAILURE){
                extentLogger.fail(result.getName());
                //Take the screenshot and return the location of ScreenShot
                String screenshotPath = BrowserUtils.getScreenshot(result.getName());
                //add the screenshot ..........
                extentLogger.addScreenCaptureFromPath(screenshotPath);
                extentLogger.fail(result.getThrowable());
            }
        Thread.sleep(2000);
        Driver.closeDriver();
    }

}
