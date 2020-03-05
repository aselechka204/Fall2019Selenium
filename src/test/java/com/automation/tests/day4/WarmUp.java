package com.automation.tests.day4;

import com.automation.utilities.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.security.Key;

public class WarmUp {
    static WebDriver driver;


    public static void main(String[] args) throws InterruptedException {
//
//        WebDriverManager.chromedriver().setup();
//        WebDriver driver = new ChromeDriver();
//
//        driver.get("https://ebay.com");
//        driver.findElement(By.id("gh-ac")).sendKeys("Hermes");
//        driver.findElement(By.id("gh-btn")).click();
//        Thread.sleep(2000);
//        driver.findElement(By.className("srp-controls__count-heading"));
//        Thread.sleep(2000);
//
//        driver.quit();
  //   ebayTest();
    // amazonTest();
        wikiTest();
    }
    public static void ebayTest() throws InterruptedException {
        driver= DriverFactory.createDriver("chrome");
        driver.get("https://ebay.com");
        driver.findElement(By.id("gh-ac")).sendKeys("Hermes");
        driver.findElement(By.id("gh-btn")).click();
        Thread.sleep(2000);
        WebElement searchResults= driver.findElement(By.tagName("h1"));
        System.out.println(searchResults.getText().split(" ")[0]);

        Thread.sleep(2000);

        driver.quit();

    }

    public static void amazonTest(){
        driver= DriverFactory.createDriver("chrome");
        driver.get("https://amazon.com");
        driver.findElement(By.id("twotabseachtextbox")).sendKeys("java book", Keys.ENTER);
        String title= driver.getTitle();
        if(title.contains("java book")){
            System.out.println("TEST PASSED");
        }else{
            System.out.println("TEST FAILED");
        }



        driver.quit();

    }

    public static void wikiTest() throws InterruptedException {
        driver= DriverFactory.createDriver("chrome");
        driver.get("https://en.wikipedia.org/wiki/Main_Page");
        driver.findElement(By.id("searchInput")).sendKeys("selenium webdriver", Keys.RETURN);
        Thread.sleep(3000);
        driver.findElement(By.partialLinkText("Selenium (software)")).click();
        Thread.sleep(2000);

        String link=driver.getCurrentUrl();


        if(link.endsWith("Selenium_(software)")){
            System.out.println("TEST PASSED");
        }else{
            System.out.println("TEST FAILED");
        }



        driver.quit();

    }
    }


