package com.kraftechnologie.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddEducationPage extends BasePage{
    @FindBy(css = "#school")
    public WebElement schoolBootcampBox;

    @FindBy(css = "#degree")
    public WebElement degreeCertificateBox;

    @FindBy(css = "#study")
    public WebElement studyBox;

    @FindBy(xpath = "(//input[@id='fromdate'])[2]")
    public WebElement fromDateBox;

    @FindBy(css = "#todateedu")
    public WebElement toDateBox;

    @FindBy(xpath= "(//textarea[@id='description'])[2]")
    public WebElement programDescriptionBox;

    @FindBy(xpath= "(//button[.='Add Education'])[2]")
    public WebElement addEducationBtn;

}


