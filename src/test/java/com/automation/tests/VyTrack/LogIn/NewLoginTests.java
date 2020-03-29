package com.automation.tests.VyTrack.LogIn;

import com.automation.pages.LogInPage;
import com.automation.tests.VyTrack.AbstractTestBase;
import com.automation.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NewLoginTests  extends AbstractTestBase {

    // login and verify that page title is a dashboard

    @Test
    public void verifyPageTitle(){

        LogInPage logInPage= new LogInPage();
        logInPage.login();
        Assert.assertEquals(Driver.getDriver().getTitle(),"Dashboard");

    }


@Test
    public void  verifyWarningMessage() {
    LogInPage loginPage = new LogInPage();

    loginPage.login("wrong", "wrong");
    Assert.assertEquals(loginPage.getWarningMessageText(), "Invalid user name or password.");


}


}
