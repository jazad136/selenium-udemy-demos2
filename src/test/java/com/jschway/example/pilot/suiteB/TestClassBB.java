package com.jschway.example.pilot.suiteB;

import com.jschway.example.extentreportdemo.dataprovider.TestDataProvider;
import com.jschway.example.pilot.testbase.TestBase;
import org.testng.annotations.Test;

public class TestClassBB extends TestBase {
    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "dataProviderSuiteB")
    public void TestBB(String arg1, String arg2) throws InterruptedException {
        log("Starting TestBB");
        log("UserName -- " + arg1);
        log("Password -- " + arg2);
        Thread.sleep(2000);
        log("Ending TestBB");
    }
}

