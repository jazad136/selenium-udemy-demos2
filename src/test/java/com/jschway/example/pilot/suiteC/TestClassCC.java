package com.jschway.example.pilot.suiteC;

import com.jschway.example.pilot.testbase.TestBase;
import org.testng.annotations.Test;

public class TestClassCC extends TestBase {
    @Test
    public void TestCC() throws InterruptedException {
        log("Starting TestCC");
        Thread.sleep(2000);
        log("Ending TestCC");
    }
}

