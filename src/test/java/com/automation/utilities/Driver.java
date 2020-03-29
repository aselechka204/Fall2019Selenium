package com.automation.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {
// same for everyone
    private static WebDriver driver;

    //so no one can create object of Driver Class
    //everyone should call static getter method instead
     private Driver(){


     }

     public static WebDriver getDriver(){

         // if webdriver doesnt exist
         //create it
         if(driver==null){
             //specify browser type in configuration.properties file
             String browser=ConfigurationReader.getProperty("browser");
             switch(browser){
                 case "chrome":
                     WebDriverManager.chromedriver().version("79").setup();
                     driver=new ChromeDriver();
                     break;
                 case "firefox":
                     WebDriverManager.firefoxdriver().setup();
                     driver= new FirefoxDriver();
                     break;
                 default:
                     throw new RuntimeException("Wrong browser name!");

             }

         }
         return driver;
     }
     public static void closerDriver(){
         if(driver!=null){
             driver.quit();
             driver=null;
         }


     }
}
