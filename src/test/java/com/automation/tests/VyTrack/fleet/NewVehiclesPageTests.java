package com.automation.tests.VyTrack.fleet;

import com.automation.pages.AbstractPageBase;
import com.automation.pages.LogInPage;
import com.automation.pages.fleet.VehiclesPage;
import com.automation.tests.VyTrack.AbstractTestBase;
import com.automation.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NewVehiclesPageTests extends AbstractTestBase {

    @Test
    public void verifyTitle(){

        LogInPage loginPage= new LogInPage();
        VehiclesPage vehiclesPage= new VehiclesPage();

        loginPage.login();
        vehiclesPage.navigateTo("Fleet", "Vehicles");

        String expectedTitle= "All - Car - Entities - System - Car - Entities - System";

        String actualTitle= Driver.getDriver().getTitle();

        Assert.assertEquals(actualTitle, expectedTitle);
    }


}
