package com.automation.tests.day8;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class SearchTests {

    private WebDriver driver;

    @Test
    public void googleSearchTest() {
        driver.get("http://google.com");
        //name ==q
        BrowserUtils.wait(3);

        driver.findElement(By.name("q")).sendKeys("java", Keys.ENTER);
        BrowserUtils.wait(3);
        // since every search item has a tag name <h3>
        // its easiest way to collect all of them
        List<WebElement> searchItems = driver.findElements(By.tagName("h3"));
        for (WebElement searchItem : searchItems) {
            String var = searchItem.getText();
            // if there is a text-print it
            if (!var.isEmpty()) {
                System.out.println(var);
                //verify that each search contains java
                Assert.assertTrue(var.toLowerCase().contains("java"));
            }
        }

    }

    /*
    given user is on the amazon.com page
    when user enters "java" as a search item
    then user clicks on the search button
    and user clicks on the first search item
    and user verifies that title of the search item contains "Java"

     */

    @Test (description = "Search for Java book on amazon")
    public void amazonSearchTest(){

        driver.get("http://amazon.com");
        BrowserUtils.wait(3);
        driver.manage().window().maximize();
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java", Keys.ENTER);
        BrowserUtils.wait(3);

         List<WebElement> searchItems= driver.findElements(By.xpath("//h2//a"));
         //find all links inside h2 elements
         // click on the first item
        for (WebElement searchItem:searchItems) {
            System.out.println("Title: "+searchItem.getText());
        }
        searchItems.get(0).click();
        BrowserUtils.wait(3);

        WebElement productTitle= driver.findElement(By.id("title"));
        String productTitleString= productTitle.getText();
        System.out.println(productTitleString);

        Assert.assertTrue(productTitleString.contains("Java"));

        // so h2 elements are nt clickable, even though they contain links
        // thats why instead of the collection all h2 elements
        //we collected all hyperlinks
        //represents some search items
    }

    @BeforeMethod
    public void setup(){

        WebDriverManager.chromedriver().version("79").setup();
        driver=new ChromeDriver();
    }

    @AfterMethod
    public void tearDown(){

        //closer browser and destroy webdriver object
        driver.quit();
    }

}
