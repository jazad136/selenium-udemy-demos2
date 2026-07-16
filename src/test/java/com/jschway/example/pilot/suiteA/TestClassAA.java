package com.jschway.example.pilot.suiteA;

import com.jschway.example.pilot.testbase.TestBase;
import org.testng.annotations.Test;

public class TestClassAA extends TestBase {
    @Test
    public void TestAA() throws InterruptedException {
        log("Starting TestAA");
        Thread.sleep(5000);
        log("Ending TestAA");
    }
}

