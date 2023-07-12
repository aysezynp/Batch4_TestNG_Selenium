package com.kraftechnologie.pages;

import com.kraftechnologie.utilities.ConfigurationReader;
import com.kraftechnologie.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    public LoginPage (){
       super();//Base Page'deki constructor ı çağırır.
       // PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(css="#email")
    public WebElement emailInputBox;

    @FindBy(css="#yourPassword")
    public WebElement passwordInputBox;

    @FindBy(xpath="//*[.='Login']")
    public WebElement loginButton;

    @FindBy(xpath = "//div[contains(text(),'incorrect')]")
    public WebElement passwordErrorMessage;

    @FindBy(xpath = "//div[contains(text(),'incorrect')]")
    public WebElement userEmailErrorMessage;

    //AND logic
    @FindBys({
            @FindBy(css="#email"),
            @FindBy(name="email")
    })
    public WebElement emailInputBoxWithFinBys;

    //OR logic
    @FindAll({
            @FindBy(id="email"),
            @FindBy(name="another")
    })
    public WebElement emailInputBoxFİndAll;


    public void login(String userEmail,String password){
        emailInputBox.sendKeys(userEmail);
        passwordInputBox.sendKeys(password);
        loginButton.click();

    }
    //method Overloading
    public void login() {
        emailInputBox.sendKeys(ConfigurationReader.get("userEmail"));
        passwordInputBox.sendKeys(ConfigurationReader.get("userPassword"));
        loginButton.click();
    }
}
