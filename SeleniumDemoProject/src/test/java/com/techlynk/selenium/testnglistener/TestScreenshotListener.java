/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.techlynk.selenium.testnglistener;

import org.testng.ITestResult;

/**
 *
 * @author JonathanSaddler
 */
public class TestScreenshotListener {
    public void onTestFailure(ITestResult result) { 
        String screenshotName = result.getAttribute("screenshotStub").toString();
        
    }
}
