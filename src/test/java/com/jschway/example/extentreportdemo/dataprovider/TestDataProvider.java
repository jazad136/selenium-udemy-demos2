package com.jschway.example.extentreportdemo.dataprovider;

import java.lang.reflect.Method;
import org.testng.annotations.DataProvider;

public class TestDataProvider {

    @DataProvider
    public void dataProviderSuiteA(Method method) {
        // separate data for each test
        System.out.println("Test method name: " + method.getName());
        Object data[][] = null;
        if(method.getName().toUpperCase().equals("TESTA")) { 
            data = new Object[2][2];
            data[0][0] = "UserName 1";
            data[0][1] = "Password 1";
            data[1][0] = "UserName 2";
            data[1][1] = "Password 2";
        }
        else if(method.getName().toUpperCase().equals("TESTAA")) { 
            data = new Object[2][2];
            data[0][0] = "UserName 11";
            data[0][1] = "Password 11";
            data[1][0] = "UserName 22";
            data[1][1] = "Password 22";
        }
    }
    @DataProvider
    public void dataProviderSuiteB(Method method) { 
        System.out.println("Test method name: " + method.getName());
        Object data[][] = null;
        if(method.getName().toUpperCase().equals("TESTB")) { 
            data = new Object[2][2];
            data[0][0] = "UserName 100";
            data[0][1] = "Password 100";
            data[1][0] = "UserName 200";
            data[1][1] = "Password 200";
        }
        else if(method.getName().toUpperCase().equals("TESTBB")) { 
            data = new Object[2][2];
            data[0][0] = "UserName 111";
            data[0][1] = "Password 111";
            data[1][0] = "UserName 211";
            data[1][1] = "Password 211";
        }
    }
    
}