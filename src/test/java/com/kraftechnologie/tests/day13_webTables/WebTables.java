package com.kraftechnologie.tests.day13_webTables;

import com.google.common.collect.Table;
import com.kraftechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebTables {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        driver.get("https://webdriveruniversity.com/Data-Table/index.html");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void printTAble() {
       // Print Whole Table
        WebElement table = driver.findElement(By.xpath("//table[@id='t01']"));//locate the whole table
        System.out.println("table.getText() = " + table.getText());
    }

    @Test
    public void getAllHeaders() {
        List<WebElement> headers = driver.findElements(By.xpath("//table[@id='t01']//th"));
        //number of columns
        System.out.println("headers.size() = " + headers.size());
        //print of all
        for (WebElement element: headers) {
            System.out.println(element.getText());
        }
    }

    @Test
    public void printTableSize() {
        //numbers of rows with headers
        List<WebElement> allRowsWithHeaders = driver.findElements(By.xpath("//table[@id='t01']//tr"));
        System.out.println(allRowsWithHeaders.size());

        //number of rows without headers
        List<WebElement> rows = driver.findElements(By.xpath("//table[@id='t01']//td/.."));
        System.out.println(rows.size());
    }
    @Test
    public void getRow() {
        //print the second row
        WebElement secondRow = driver.findElement(By.xpath("(//table[@id='t01']//td/..)[2]"));
        System.out.println("secondRow.getText() = " + secondRow.getText());

        System.out.println("....................................................");

        //get all rows dynamically and print the one by one
        List<WebElement> rows = driver.findElements(By.xpath("//table[@id='t01']//td/.."));
        for (WebElement row : rows) {
            System.out.println(row.getText());
        }
        System.out.println(".....................................................");

        //get all rows dynamically and print the one by one with by index formula
        for (int i = 1; i <= rows.size(); i++) {
            WebElement element = driver.findElement(By.xpath(("(//table[@id='t01']//td/..)[" + i + "]")));
            System.out.println("element.getText() = " + element.getText());
        }
    }
     @Test
    public void getAllCellInOneRow(){
        //get all cells of the first row
         List<WebElement> allCellsINOneRow = driver.findElements(By.xpath("(//table[@id='t01']//td/..)[1]/td"));
         for (WebElement webElement : allCellsINOneRow) {
         System.out.println("webElement.getText() = " + webElement.getText());

         }
    }
    @Test
    public void getASingleCellInOneRow(){
        //get the third cell of first row
        List<WebElement> thirdCellsINOneRow = driver.findElements(By.xpath("(//table[@id='t01']//td/..)[1]/td"));
        System.out.println("thirdCellsINOneRow.get(2).getText() = " + thirdCellsINOneRow.get(2).getText());

        List<WebElement> secondCellsINOneRow = driver.findElements(By.xpath("(//table[@id='t01']//td/..)[2]/td"));
        System.out.println("secondCellsINOneRow.get(1).getText() = " + secondCellsINOneRow.get(1).getText());
    }

    @Test
    public void printAllCellsByIndex(){
        //we would like to write a code that it will print all cells one by one
        int rowNumber=getNumberOfRows();
        int columnNumber=getNumberColumns();
        for (int i = 1; i <=rowNumber ; i++) {
            for (int j = 1; j <= columnNumber; j++) {
               WebElement element = driver.findElement(By.xpath("(//table[@id='t01']//td/..)[" + i + "]/td[" + j + "]"));
                System.out.println(i+"/"+j+"/"+element.getText());
            }
        }
    }

    private int getNumberOfRows() {
        List<WebElement> rows = driver.findElements(By.xpath("//table[@id='t01']//td/.."));
        return rows.size();
    }

    private int getNumberColumns() {
        List<WebElement> headers = driver.findElements(By.xpath("//table[@id='t01']//th"));
        return headers.size();
    }
    //here is the method that we aimed to reach during the whole evening
    private WebElement getSpecificalCell(int row, int column){
        WebElement element= driver.findElement(By.xpath("(//table[@id='t01']//td/..)[" + row + "]/td[" + column +"]"));
        return element;

    }

    @Test
    public void test() {
        //verify that value of 3rd row and 2nd column is 'Doe'
        WebElement element= getSpecificalCell(3,2);
        Assert.assertEquals(element.getText(),"Doe");

    }
}




















