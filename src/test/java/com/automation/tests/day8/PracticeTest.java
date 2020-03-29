package com.automation.tests.day8;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class PracticeTest {


    private WebDriver driver;

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().version("79").setup();
        driver=new ChromeDriver();
        driver.get(" http://practice.cybertekschool.com/");
        driver.manage().window().maximize();
    }

    // How to handle SSL ISSUES in selenium.
    //ChromeOptions chromeOptions= new ChromeOptions();
    //chromeOptions.setAcceptInsecureCerts(true);

    // we put TEST annotation to make methods executable as tests
@Test
public void logInTest(){

        driver.findElement(By.linkText("Form Authentication")).click();
    BrowserUtils.wait(3);
        driver.findElement(By.name("username")).sendKeys("tomsmith");
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword",Keys.ENTER);

    BrowserUtils.wait(3);

    String expected= "Welcome to the Secure Area. When you are done click logout below.";
    String actual=driver.findElement(By.className("subheader")).getText();

    Assert.assertEquals(actual,expected, "Sub-header message is not matching");
    BrowserUtils.wait(3);
}
@Test
public void Checkboxes(){
        driver.findElement(By.linkText("Checkboxes")).click();

    List<WebElement> checkboxes= driver.findElements(By.tagName("input"));
    BrowserUtils.wait(4);
    checkboxes.get(0).click();


        Assert.assertTrue(checkboxes.get(0).isSelected(), "Checbox #1 is not selected");
         BrowserUtils.wait(4);
}
@Test
public void forgotPassword(){
     driver.findElement(By.linkText("Forgot Password")).click();
     BrowserUtils.wait(3);
     driver.findElement(By.name("email")).sendKeys("kuku@yahoo.com", Keys.ENTER);
     BrowserUtils.wait(3);

    String actual=driver.findElement(By.name("confirmation_message")).getText();

    String expected= "Your e-mail's been sent!";

     Assert.assertEquals(actual, expected, "Confirmation message is not valid");
     BrowserUtils.wait(3);



}


    @AfterMethod
    public void tearDown(){
       driver.quit();
    }
}
