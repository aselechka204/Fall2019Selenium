package com.automation.tests.day11;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.security.PublicKey;

public class JSExecutor2 {

private WebDriver driver;


@BeforeMethod
    public void setup(){
    driver = DriverFactory.createDriver("chrome");
    driver.get("http://practice.cybertekschool.com/");
    driver.manage().window().maximize();


}

@Test
    public void clickTest(){


    WebElement link= driver.findElement(By.linkText("Multiple Buttons"));
   // link.click();
    JavascriptExecutor js= (JavascriptExecutor) driver;
    //after double "" tou can list webelemnts that will be used
    //as a  part of your javascript code
    //its varargs , so you can list )+
    // use index to get specific webelement
    // Webelement arguments= {element, link, link2}
    js.executeScript("arguments[0].click()", link);

    WebElement button6= driver.findElement(By.id("disappearing_button"));

    js.executeScript("arguments[0].click()", button6);
    BrowserUtils.wait(2);
    WebElement result= driver.findElement(By.id("result"));
    Assert.assertEquals(result.getText(), "Now it's gone!");



}

@Test
public void textInputTest(){
    driver.findElement(By.linkText("Form Authentication")).click();
    BrowserUtils.wait(3);
    WebElement username = driver.findElement(By.name("username"));
    WebElement password = driver.findElement(By.name("password"));
    WebElement loginbtn = driver.findElement(By.id("wooden_spoon"));
    JavascriptExecutor js = (JavascriptExecutor) driver;
    //to get text from input box - read attribute "value"
    //to enter text - set attribute "value"
    //.setAttribute('value', 'text') - enter some text
    js.executeScript("arguments[0].setAttribute('value', 'tomsmith')" , username);
    js.executeScript("arguments[0].setAttribute('value', 'SuperSecretPassword')", password);
    js.executeScript("arguments[0].click()", loginbtn);

    BrowserUtils.wait(2);

    String subheader= js.executeScript("return document.getElementsByClassName('subheader')[0].textContent").toString();



}
@Test

public void verifyTitle(){

    String expected= "Practice";
    // we create javascriptexecutor object by casting webdriver object
    JavascriptExecutor is= (JavascriptExecutor) driver;
    // executeScript - this method executes javascript code
    // we provide is code as string
    String actual= is.executeScript("return document.title").toString();

    Assert.assertEquals(actual, expected);

}

@Test
public void scrollToElement(){
    BrowserUtils.wait(5);
    WebElement link=driver.findElement(By.linkText("Cybertek School"));
    JavascriptExecutor js= (JavascriptExecutor) driver;
    js.executeScript("arguments[0].scrollIntoView(true)", link);
}

@Test
public void scrollTest(){

    driver.navigate().to("http://practice.cybertekschool.com/infinite_scroll");
    JavascriptExecutor js= (JavascriptExecutor) driver;
    for (int x = 0; x <15 ; x++) {
        js.executeScript("window.scrollBy(0, 1000)");
        BrowserUtils.wait(2);

    }
}
@AfterMethod
    public void quit(){
    BrowserUtils.wait(3);
    driver.quit();
}

}
