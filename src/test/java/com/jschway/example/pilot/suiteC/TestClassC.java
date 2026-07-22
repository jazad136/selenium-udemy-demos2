package com.jschway.example.pilot.suiteC;

import com.jschway.example.pilot.testbase.TestBase;
import org.testng.annotations.Test;

public class TestClassC extends TestBase {
    @Test
    public void TestC() throws InterruptedException {
        log("Starting TestC");
        Thread.sleep(2000);
        log("Ending TestC");
    }
}
