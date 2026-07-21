package com.jschway.example.pilot.suiteA;

import com.jschway.example.pilot.dataprovider.TestDataProvider;
import com.jschway.example.pilot.testbase.TestBase;
import org.testng.annotations.Test;

public class TestClassA extends TestBase {
    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "dataProviderSuiteA")
    public void TestA(String arg1, String arg2) throws InterruptedException {
        log("Starting Test A");
        log("UserName -- " + arg1);
        log("Password -- " + arg2);
        Thread.sleep(2000);
        log("Ending Test A");
    }
}
