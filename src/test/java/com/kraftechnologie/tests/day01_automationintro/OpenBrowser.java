package com.kraftechnologie.tests.day01_automationintro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenBrowser {
    public static void main(String[] args) {

        //Make Selenium ready to talk with Chrome
        WebDriverManager.chromedriver().setup();

        //create a driver object
        //driver  --->> represent a empty browser
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.krafttechnologie.com");//pull this web page into the empty driver,
                                                       //if we do not write this line driver open an empty browser


     //  driver.get("https://www.amazon.com");//yukarıda oluşturduğum aynı ChromeDriver empty browserda önce kraft url in daha sonra amazon u açar.

      //  WebDriver driver1=new ChromeDriver();
      //  driver1.get("https://www.amazon.com");

        //How to maximize window
        driver.manage().window().maximize();

        System.out.println("driver.getTitle() = " + driver.getTitle());

        //how to get title
        String actualTitle=driver.getTitle();
        String expectedTitle="Kraft Technologie | Yazılım ve Bilişim Eğitimleri – Uzaktan Canlı Eğitim";
        if(actualTitle.equals(expectedTitle)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
        }


    }
}
