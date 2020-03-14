package com.automation.tests.day8;

import org.testng.Assert;
import org.testng.annotations.Test;

public class UnitTestPractice {

    public static void main(String[] args) {


        System.out.println(reverseString("apple"));

        // unit test
        //to check if our method works properly
        //if assertion fails, that means our method doesnt work correctly
        //that means we have to fix the method
        String expected="cba";
        String toReverse="abc";
        String actual= reverseString(toReverse);
        // Assertion
         verifyEquals(expected, actual);




    }
    //annotation
    // make sure to use TestNG
    @Test(description= "Verify if method can reverse a string")
    public void test(){
     String expected="elppa";
     String actual= reverseString("apple");

     // to verify if expected result is equals to actual
        // its coming from testing, junit, also has this class
        // you can compare any data types here, string primitieves, arrays , objects
        Assert.assertEquals(actual,expected);



    }

    @Test(description= "Verify if method can reverse a string")
    public void test2(){

        String expected="rac";
        String actual=reverseString("car");
        Assert.assertEquals(actual,expected);


    }







    public static boolean verifyEquals(String expected, String actual){
        if(expected.equals(actual)){
            System.out.println("TEST PASSED");
            return true;
        }else{
            System.out.println("Test Failed");
            System.out.println("Expected"+expected);
            System.out.println("Actual"+actual);
            return false;
        }
    }
  public static String reverseString(String str){
      String reversed="";
      for (int x = str.length()-1; x >=0 ; x--) {
          reversed+=str.charAt(x);

      }
      return reversed;

  }
}
