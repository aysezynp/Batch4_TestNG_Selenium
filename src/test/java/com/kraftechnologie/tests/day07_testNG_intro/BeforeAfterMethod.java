package com.kraftechnologie.tests.day07_testNG_intro;

import org.testng.annotations.*;

public class BeforeAfterMethod {

    @BeforeMethod
    public void Setup() {
        System.out.println("*******************Before Method****************");
        System.out.println("WebDriver,Opening Browser");
    }

    @Test (priority = 1)
    public void test1() {
        System.out.println("First Test Case");

    }
    @Test (priority = 3)
    public void test2() {
        System.out.println("Second Test Case");
    }

    @Test (priority= 2)
    public void test3() {
        System.out.println("Third Test Case");

    }
    @AfterMethod
    public void tearDown() {
        System.out.println("*******************After Method****************");
            System.out.println("Closing Browser,quit");
        }

    @BeforeClass
    public void setUpClass(){
    System.out.println("........Before CLASS........................");
    }

    @AfterClass
    public void tearDownClass(){
    System.out.println("...............AFTER CLASS....................");
    }

}