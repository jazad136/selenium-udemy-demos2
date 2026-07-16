package com.jschway.example.pilot.suiteB;

import com.jschway.example.pilot.testbase.TestBase;
import org.testng.annotations.Test;

public class TestClassB extends TestBase {
    @Test
    public void TestB() throws InterruptedException {
        log("Starting TestB");
        Thread.sleep(5000);
        log("Ending TestB");
    }
}
