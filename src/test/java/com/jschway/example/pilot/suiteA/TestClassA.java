package com.jschway.example.pilot.suiteA;

import com.jschway.example.pilot.dataprovider.TestDataProvider;
import com.jschway.example.pilot.testbase.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestClassA extends TestBase {
    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "dataProviderSuiteA")
    public void TestA(String arg1, String arg2) throws InterruptedException {
        log("Starting Test A");
        log("UserName -- " + arg1);
        if(!arg1.equals("USERNAME_DEMO")) { 
            softAssert("Validation Failure --" + arg1 + " does not equal USERNAME_DEMO");
        }
//        softAssert.assertEquals(arg1,"USERNAME_DEMO");
        log("Password -- " + arg2);
        if(!arg2.equals("USER_PASSWORD")) { 
            softAssert("Validation Failure --" + arg2 + " does not equal USER_PASSWORD");
        }
//        softAssert.assertEquals(arg2,"USER_PASSWORD");
        Thread.sleep(2000);
        log("Ending Test A");
        softAssert.assertAll();
    }
}
