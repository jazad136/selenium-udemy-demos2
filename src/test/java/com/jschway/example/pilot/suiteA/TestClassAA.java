package com.jschway.example.pilot.suiteA;

import com.jschway.example.pilot.testbase.TestBase;
import org.testng.annotations.Test;

public class TestClassAA extends TestBase {
    @Test
    public void TestAA(String arg1, String arg2) throws InterruptedException {
        log("Starting TestAA");
        log("UserName -- " + arg1);
        log("Password -- " + arg2);
        Thread.sleep(2000);
        log("Ending TestAA");
    }
}

