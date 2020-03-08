package com.automation.tests.day6;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SelectByText {
    public static void main(String[] args) {

        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtils.wait(3);
        WebElement simpleDropdown= driver.findElement(By.id("dropdown"));
        Select selectSimpleDropdown = new Select(simpleDropdown);
        selectSimpleDropdown.selectByVisibleText("Option 2");
        BrowserUtils.wait(3);
        selectSimpleDropdown.selectByVisibleText("Option 1");

        Select selectYear = new Select(driver.findElement(By.id("year")));
        Select selectMonth = new Select(driver.findElement(By.id("month")));
        Select selectDay = new Select(driver.findElement(By.id("day")));


        selectDay.selectByVisibleText("1");
        selectMonth.selectByVisibleText("1");
        selectYear.selectByVisibleText("2003");



        BrowserUtils.wait(3);



        driver.quit();

    }
}
