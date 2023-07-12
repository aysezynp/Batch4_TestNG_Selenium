package com.kraftechnologie.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddExperiencePage extends BasePage{

    @FindBy(xpath = "//input[@id='job']")
    public WebElement jobTitleBox;

    @FindBy(xpath = "(//input[@id='company'])[2]")
    public WebElement companyBox;

    @FindBy(xpath = "(//input[@id='location'])[2]")
    public WebElement locationBox;

    @FindBy(xpath = "(//input[@id=\"fromdate\"])[1]")
    public WebElement fromDateBox;

    @FindBy(css = "#currentexp")
    public WebElement currentBox;

    @FindBy(xpath = "(//textarea[@id='description'])[1]")
    public WebElement jobDescriptionBox;

    @FindBy(xpath = "(//button[.='Add Experience'])[2]")
    public WebElement addExperienceBtn;



}