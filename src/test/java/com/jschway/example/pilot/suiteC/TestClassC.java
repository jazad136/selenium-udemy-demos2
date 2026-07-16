package com.jschway.example.pilot.suiteC;

import com.jschway.example.pilot.testbase.TestBase;
import org.testng.annotations.Test;

public class TestClassC extends TestBase {
    @Test
    public void TestC() throws InterruptedException {
        System.out.println("Starting TestC");
        Thread.sleep(5000);
        System.out.println("Ending TestC");
    } 
}
