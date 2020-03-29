package com.automation.tests.day12;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import java.util.List;

public class March22 {

    @Test
    public void test(){

        WebDriver driver= DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/tables");
        driver.findElement(By.xpath("//table[1]//*[text()='Last Name']")).click();
        BrowserUtils.wait(2);

        List<WebElement> column= driver.findElements(By.xpath("//table[1]//tbody//td[1]"));

        for (int x = 0; x <column.size()-1 ; x++) {
            String value= column.get(x).getText();
            String nextValue=column.get(x+1).getText();
            System.out.println(value.compareTo(nextValue));
            Assert.assertTrue(value.compareTo(nextValue)<=0);
        }

        driver.quit();
    }






}
