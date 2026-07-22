/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jschway.example.pilot.listener;

import org.testng.ITestListener;
import org.testng.ITestResult;

/**
 *
 * @author JonathanSaddler
 */
public class CustomListener implements ITestListener {
    
    public void onTestSuccess(ITestResult result) { 
        System.out.println("******** TEST SUCCESS ********");
        System.out.println("Test Name: " + result.getMethod());
    }
    
    public void onTestFailure(ITestResult result) { 
        System.out.println("******** TEST FAILURE ********");
        System.out.println("Error : " + result.getThrowable().getMessage());
        
    }
}
