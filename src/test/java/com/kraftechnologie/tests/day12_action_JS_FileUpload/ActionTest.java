package com.kraftechnologie.tests.day12_action_JS_FileUpload;

import com.kraftechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ActionTest {
    WebDriver driver;
    Actions action;

    @BeforeMethod
    public void setUp() throws InterruptedException {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        action=new Actions(driver);

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
    @Test
     public void hoverOver(){
        driver.get("https://the-internet.herokuapp.com/hovers");
        WebElement img2 = driver.findElement(By.xpath("(//img)[2]"));

//Actions --> class that contains all the user interactions
       // Actions action=new Actions(driver);
        //moveToElement()--> move your mouse to the web (hover over)
        //perform() --> perform the action, complete the action
        action.moveToElement(img2).perform();

        WebElement viewProfile1 = driver.findElement(By.linkText("View profile"));
        System.out.println(viewProfile1.getText());
        Assert.assertTrue(viewProfile1.isDisplayed(),"Verify that element is displayed");

    }
@Test
    public void dragAndDrop(){
        driver.get("https://demoqa.com/droppable");
    WebElement source = driver.findElement(By.id("draggable"));

    WebElement target = driver.findElement(By.xpath("(//div[@id='droppable'])[1]"));

  //  Actions action=new Actions(driver);
    action.dragAndDrop(source,target).perform();
    WebElement verifyMessage=driver.findElement(By.xpath("//p[text()='Dropped!']"));
    Assert.assertTrue(verifyMessage.isDisplayed(),"verify that element is displayed");
    Assert.assertEquals(verifyMessage.getText(),"Dropped!","Verify that element is dropped");

    }
    @Test
    public void dragAndDrop2(){
        driver.get("https://demoqa.com/droppable");
        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.xpath("(//div[@id='droppable'])[1]"));
      //  Actions action=new Actions(driver);
        action.moveToElement(source).clickAndHold().moveToElement(target).pause(1000).release().perform();
        WebElement verifyMessage=driver.findElement(By.xpath("//p[text()='Dropped!']"));
        Assert.assertTrue(verifyMessage.isDisplayed());
        Assert.assertEquals(verifyMessage.getText(),"Dropped!","Verify that element");


    }

}
