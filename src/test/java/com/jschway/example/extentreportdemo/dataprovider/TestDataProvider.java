package com.jschway.example.extentreportdemo.dataprovider;

import java.lang.reflect.Method;

public class TestDataProvider {
    
    public void dataProviderSuiteA(Method method) { 
        // separate data for each test
        System.out.println("Test method name: " + method.getName());
    }
}
