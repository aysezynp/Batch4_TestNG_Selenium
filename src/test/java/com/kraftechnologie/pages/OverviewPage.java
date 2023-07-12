package com.kraftechnologie.pages;

import com.kraftechnologie.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OverviewPage extends BasePage{


    public String controlOverviewTableCell(String target){
       WebElement tdName= Driver.get().findElement(By.xpath("//tbody//td[.='"+target+"']"));
       return tdName.getText();
    }
}
