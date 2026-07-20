package com.jschway.example.pilot.suiteB;

import com.jschway.example.pilot.testbase.TestBase;
import org.testng.annotations.Test;

public class TestClassB extends TestBase {
    @Test
    public void TestB(String arg1, String arg2) throws InterruptedException {
        log("Starting TestB");
        log("UserName -- " + arg1);
        log("Password -- " + arg2);
        Thread.sleep(2000);
        log("Ending TestB");
    }
}
