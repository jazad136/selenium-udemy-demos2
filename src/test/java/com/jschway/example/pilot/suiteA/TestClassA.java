package com.jschway.example.pilot.suiteA;

import com.jschway.example.extentreportdemo.dataprovider.TestDataProvider;
import com.jschway.example.pilot.testbase.TestBase;
import org.testng.annotations.Test;

public class TestClassA extends TestBase {
    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "dataProviderSuiteA")
    public void TestA() throws InterruptedException {
        log("Starting Test A");
        Thread.sleep(5000);
        log("Ending Test A");
    }
}
