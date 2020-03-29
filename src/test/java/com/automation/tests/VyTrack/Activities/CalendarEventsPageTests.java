package com.automation.tests.VyTrack.Activities;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CalendarEventsPageTests {

    private By usernameBy= By.id("prependedInput");
    private By passwordBy=By.id("prependedInput2");
    private WebDriver driver;

    private Actions actions;

    private String username= "storemanager85";
    private String password= "UserUser123";
    private By activitiesBy= By.xpath("//span[@class='title title-level-1' and contains(text(),'Activities')]");
    private By createCalendarEvent=By.cssSelector("a[title='Create Calendar event']");
    private By currentUserby=By.cssSelector("#user-menu > a");
    private By ownerBy= By.id("s2id_oro_calendar_event_form_calendar");
    private By titleBy= By.cssSelector("[name='oro_calendar_event_form[title]']");

    @BeforeMethod

    public void setup(){


        driver= DriverFactory.createDriver("chrome");
        driver.get("https://qa2.vytrack.com/user/login");
        driver.manage().window().maximize();
        actions = new Actions(driver);

        BrowserUtils.wait(3);
        driver.findElement(usernameBy).sendKeys(username);
        driver.findElement(passwordBy).sendKeys(password, Keys.ENTER);
        BrowserUtils.wait(5);

        // hover over actions
        actions.moveToElement(driver.findElement(activitiesBy)).perform();
        BrowserUtils.wait(2);

        driver.findElement(By.linkText("Calendar Events")).click();
        BrowserUtils.wait(5);

    }



    @Test
    public void verifyCreateButton(){
       WebElement createCalendarEventbtn=driver.findElement(createCalendarEvent);
       Assert.assertTrue(createCalendarEventbtn.isDisplayed());



    }

    @Test (description = "Default options")
    public void verifyDefaultValues(){
        //click on create calendar event
        driver.findElement(createCalendarEvent).click();
        BrowserUtils.wait(4);

        String currentUserName= driver.findElement(currentUserby).getText();
        String defaultOwnerName=driver.findElement(ownerBy).getText();

        Assert.assertEquals(currentUserName, defaultOwnerName);

        WebElement titleElement= driver.findElement(titleBy);
        Assert.assertTrue(titleElement.getAttribute("value").isEmpty());


    }

    @AfterMethod
    public void quit(){
        driver.quit();

    }

}
