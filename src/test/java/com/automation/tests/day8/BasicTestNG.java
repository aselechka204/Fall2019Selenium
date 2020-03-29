package com.automation.tests.day8;

import org.testng.Assert;
import org.testng.annotations.*;

public class BasicTestNG {
    @BeforeTest // runs only once before class and method
    public void beforeTest(){
        System.out.println("Before Test");


    }
    @AfterTest
    public void afterTest(){
        System.out.println("After Test");
    }
    //runs only once after class and method
    @BeforeClass
    //runs only once in the class before @beforeMethod and before @Test
    //regardless of number of tests it runs only once
    public  void beforeClass(){
        //something that should be done only once in the class before all tests
        System.out.println("Before Class");
    }
    @AfterClass
    public void afterClass(){
        //something that should be done only once in the class after all tests

        System.out.println("After Class");
    }
    @BeforeMethod
    public void setup(){
        // runs before every test
        // if there is something that runs before everytest ....
        //works as a setup
        System.out.println("Before Method");


    }
    @AfterMethod
    //runs automatically after every test

    public void teardown(){
        System.out.println("After Method");

    }

    @Test
    public static void test1(){
        System.out.println("Test 1");
        String expected= "apple";
        String actual= "apple";
        Assert.assertEquals(actual,expected);
    }
    @Test
    public void test2(){
        System.out.println("Test 2");
        int num1= 5;
        int num2=10;
    // it calls hard assertion
        // if assertion fails it stops the execution(due to exception)
        Assert.assertTrue(num1<num2);
    }
}
