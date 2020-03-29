package com.automation.tests.day10;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JSExecutor {

    private RemoteWebDriver driver;

    @BeforeMethod
    public void setUp(){

     //   driver= DriverFactory.createDriver("chrome");

        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();
    }


    @Test
    public void scrollTest() {

        driver.get("http://practice.cybertekschool.com/infinite_scroll");
        driver.manage().window().maximize();
        //   JavascriptExecutor js= (JavascriptExecutor) driver;

        for (int x = 0; x < 10; x++) {


        driver.executeScript("window.scrollBy(0,250)");
        BrowserUtils.wait(1);
    }

            BrowserUtils.wait(1);

}

@Test
public  void scrollToElementTest(){

        driver.get("http://practice.cybertekschool.com/");
        driver.manage().window().maximize();
        WebElement link= driver.findElement(By.linkText("Cybertek School"));
        driver.executeScript("arguments[0].scrollIntoView(true)",link);
}


    @AfterMethod
    public void tearDown(){

        driver.quit();
    }
}
