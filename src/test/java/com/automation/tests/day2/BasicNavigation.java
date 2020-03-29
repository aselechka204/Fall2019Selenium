package com.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigation {
    public static void main(String[] args) throws Exception {

        // to start selenium script we need:
        // setup webdriver(browser driver) and create webdriver object
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        // in selenium, everything starts from WebDriver interface
        //chrome extends remotewebdriver -->implements WebDriver
        driver.get("http://google.com");// open website
        driver.manage().window().maximize(); // to maximize browser
        Thread.sleep(3000);// for demo , wait 3 seconds
        // method that returns page title
        // you can also see it as tab name, in the browser
        String expectedTitle= "Google";
        String title= driver.getTitle(); // returns title of the page
        System.out.println("URL :"+driver.getCurrentUrl());  // current website
        System.out.println("title is..."+title);
        driver.navigate().refresh(); // to reload page



        if(expectedTitle.equals(title)){
            System.out.println("TEST PASSED!");
        }else{
            System.out.println("TEST FAILED");
        }

        driver.navigate().to("http://amazon.com");

        if(driver.getTitle().toLowerCase().contains("amazon")){
            System.out.println("TEST PASSED");
        }else{
            System.out.println("TEST FAILED");
        }

        driver.navigate().back();

        verifyEquals(driver.getTitle(), "Google");
        // move forward in the browser history
        driver.navigate().forward();
        System.out.println("Title= "+driver.getTitle());


        driver.close(); // to close browser

    }

    public static void verifyEquals(String arg1, String arg2){
        if(arg1.equals(arg2)){
            System.out.println("TEST PASSED");
        }else{
            System.out.println("TEST FAILED");
        }
    }
}
