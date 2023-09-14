package com.kraftechnologie.tests.day20_ddf;

import com.kraftechnologie.pages.LoginPage;
import com.kraftechnologie.tests.TestBase;
import com.kraftechnologie.utilities.ConfigurationReader;
import com.kraftechnologie.utilities.ExcelUtil;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvider_LoginTest extends TestBase {
    @DataProvider
    public Object[][] userData(){
        ExcelUtil excelUtil=new ExcelUtil("src/test/resources/Book1.xlsx", "Sheet2");
        String[][] dataArrayWithoutFirstRow = excelUtil.getDataArrayWithoutFirstRow();
        return dataArrayWithoutFirstRow;
    }
    @Test(dataProvider = "userData")
    public void LoginTestWithDataProvider(String username,String password,String name){
        driver.get(ConfigurationReader.get("url"));

        LoginPage loginPage=new LoginPage();
        loginPage.emailInputBox.sendKeys(username);
        loginPage.passwordInputBox.sendKeys(password);
        loginPage.loginButton.click();

        String actual = loginPage.getUserAccountName();
        String expected=name;

        Assert.assertEquals(actual,expected);


    }


}
