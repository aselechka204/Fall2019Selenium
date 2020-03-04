package com.automation.tests.day3;

import com.automation.utilities.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementsPractice {
    public static void main(String[] args) throws InterruptedException {

    //    WebDriverManager.chromedriver().setup();
     //   WebDriver driver= new ChromeDriver();
        //reusable methods are called utilities
        //test package - this is where we gonna store all tests
        // utilities - package , for storing reusable methods that will support our tests. For example we can create
        // a class with that will give us a WebDriver, whenever we need it


        WebDriver driver= DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/sign_up");

        WebElement fullName= driver.findElement(By.name("full_name"));
        fullName.sendKeys("Mister Twister");

        WebElement email= driver.findElement(By.name("email"));
        email.sendKeys("sdet@cybertek.com");

        WebElement signUp= driver.findElement(By.name("wooden_spoon"));
        // when you see type="submit" you can use submit() instead of click()
        // it make sence to use when click() method doesnt work
        signUp.submit();

        Thread.sleep(3000);




        driver.quit();
    }
}
