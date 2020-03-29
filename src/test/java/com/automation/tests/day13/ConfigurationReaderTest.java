package com.automation.tests.day13;

import com.automation.utilities.ConfigurationReader;
import org.testng.annotations.Test;

public class ConfigurationReaderTest {

    @Test
    public void readProperties(){

        //click control or command button it shows where you are using it

        String browser= ConfigurationReader.getProperty("browser");
        String url=ConfigurationReader.getProperty("qa1");
        String color=ConfigurationReader.getProperty("color");
        String storeManager =ConfigurationReader.getProperty("store_manager");
        String password= ConfigurationReader.getProperty("password");
        String driver= ConfigurationReader.getProperty("driver");
        System.out.println(browser);
        System.out.println(url);
        System.out.println(color);
        System.out.println(password);
        System.out.println(storeManager);
        System.out.println(driver);


    }
}
