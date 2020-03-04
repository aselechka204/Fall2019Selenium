package com.automation.tests.day3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementsPractice {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        //reusable methods are called utilities
        //test package - this is where we gonna store all tests
        // utilities - package , for storing reusable methods that will support our tests. For example we can create
        // a class with that will give us a WebDriver, whenever we need it

    }
}
