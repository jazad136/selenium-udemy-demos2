package com.jschway.example.extentreportdemo.dataprovider;

import java.lang.reflect.Method;
import org.testng.annotations.DataProvider;

public class TestDataProvider {

    @DataProvider
    public void dataProviderSuiteA(Method method) {
        // separate data for each test
        System.out.println("Test method name: " + method.getName());
    }
}