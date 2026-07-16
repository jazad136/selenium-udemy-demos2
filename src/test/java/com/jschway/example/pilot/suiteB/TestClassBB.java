package com.jschway.example.pilot.suiteB;

import com.jschway.example.pilot.testbase.TestBase;
import org.testng.annotations.Test;

public class TestClassBB extends TestBase {
    @Test
    public void TestBB() throws InterruptedException {
        log("Starting TestBB");
        Thread.sleep(5000);
        log("Ending TestBB");
    }
}

