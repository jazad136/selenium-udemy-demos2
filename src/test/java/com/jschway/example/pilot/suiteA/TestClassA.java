package com.jschway.example.pilot.suiteA;

import com.jschway.example.pilot.testbase.TestBase;
import org.testng.annotations.Test;


public class TestClassA extends TestBase {
    
    @Test
    public void TestA() throws InterruptedException {
        System.out.println("Starting TestA");
        test.info("Starting TestA");
        Thread.sleep(5000);
        System.out.println("Ending TestA");
        test.info("Ending TestB");
    }
}
