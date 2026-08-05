/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.techlynk.selenium.test.provider;

import java.lang.reflect.Method;
import org.testng.annotations.DataProvider;

public class TestDataProvider {
    @DataProvider
    public static Object[][] dataProviderScenario1Tests() { 
        Object[][] data;
        data = new Object[][]{
            new Object[]{"Scenario 1", "https://jqueryui.com"}
        };
        return data;
    }
    @DataProvider
    public static Object[][] dataProviderScenario2Tests() { 
        Object[][] data;
        data = new Object[][]{
            new Object[]{"Scenario 2", 5}
        };
        return data;
    }
    
    static Object[][] dataProviderScenario1(Method method) { 
        Object data[][] = null;
        if(method.getName().toUpperCase().equals("VERIFYELEMENTDISPLAYEDTEST")) { 
            data = new Object[1][2];
            data[0][0] = "Verify Element Displayed Test"; // Test Title
            data[0][1] = "https://jqueryui.com"; // URL
        }
        if(method.getName().toUpperCase().equals("VERIFYELEMENTENABLEDTEST")) { 
            data = new Object[1][2];
            data[0][0] = "Verify Element Enabled Test"; // Test Title
            data[0][1] = "https://jqueryui.com"; // URL
        }
        return data;
    }
}
