package com.jschway.example.pilot.suiteB;

import com.jschway.example.pilot.testbase.TestBase;
import org.testng.annotations.Test;

public class TestClassBB extends TestBase {
    @Test
    public void TestBB() throws InterruptedException {
        System.out.println("Starting TestBB");
        test.info("Starting TestBB");
        Thread.sleep(5000);
        System.out.println("Ending TestBB");
        test.info("Ending TestBB");
    }
}

