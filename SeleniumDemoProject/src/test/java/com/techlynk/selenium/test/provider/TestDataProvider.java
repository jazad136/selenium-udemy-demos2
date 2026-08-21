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
    public static Object[][] dataProviderScenario2TestsNormalSpd() { 
        Object[][] data;
        data = new Object[][]{
            new Object[]{"Scenario 2"}
        };
        return data;
    }
    @DataProvider
    public static Object[][] dataProviderScenario2Tests() { 
        Object[][] data;
        data = new Object[][]{
            new Object[]{"Scenario 2", 3}
        };
        return data;
    }
    @DataProvider
    public static Object[][] dataProviderScenario3Tests() { 
        Object[][] data;
        data = new Object[][]{
            new Object[]{"Scenario 3", 3}
        };
        return data;
    }
    @DataProvider
    public static Object[][] dataProviderDraggable() { 
        Object[][] data = new Object[][]{
             {50, 50}
            ,{100, 150}
        };
        return data;
    }
    @DataProvider
    public static Object[][] dataProviderTable() { 
        Object[][] data = new Object[][]{
             {5, 1, 8, 3}
        };
        return data;
    }
    @DataProvider
    public static Object[][] dataProviderJavaScript() { 
        Object[][] data = new Object[][]{
             {100}
        };
        return data;
    }
    /** Test Name Providers */
    public static String getTestNameScenario2Suite(String methodName) {
        if(methodName.toUpperCase().equals("USEDROPDOWNTEST")) { 
            return "Use Dropdown Test";
        }
        else if(methodName.toUpperCase().equals("DROPDOWNMULTISELECTTEST")) {
            return "Dropdown Multi-Select Test";
        }
        else if(methodName.toUpperCase().equals("VERIFYRADIOBUTTON")) {
            return "Verify Radio Button Test";
        }
        else if(methodName.toUpperCase().equals("CAPTURESCREENSHOT")) {
            return "Capture Screen Shot Test";
        }
        else if(methodName.toUpperCase().equals("GETMULTIPLEWINDOWHANDLETEST")) {
            return "Get Multiple Window Handle Test";
        }
        else if(methodName.toUpperCase().equals("HANDLEALERTSTEST")) {
            return "Handle Alert Test";
        }
        else if(methodName.toUpperCase().equals("PERFORMMOUSEHOVERTEST")) {
            return "Perform Mouse Hover Test";
        }
        
        return "Dropdown Test";
    }
    
    public static String getTestNameScenario3Suite(String methodName) {
        if(methodName.toUpperCase().equals("WEBTABLEOPERATIONSTEST")) {
            return "Web Table Operations Test";
        }
        if(methodName.toUpperCase().equals("HANDLEJSTEST")) {
            return "Handle JavaScript Executor Test";
        }
        return "Advanced Test";
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
