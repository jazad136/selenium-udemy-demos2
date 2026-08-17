/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.techlynk.selenium.scenario1;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
/**
 *
 * @author JonathanSaddler
 */

public class VerifyLinkStatus{
    public static int invalidLinkCount;
    public static void verifyLink(String link) throws IOException{ 
        if(link != null && !link.isEmpty()) {
            try { 
                URL url = new URL(link);
                // Open HTTP Connection
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                // set timeout
                connection.setConnectTimeout(3000);
                // Set Request Method to HEAD to check only headers, not the entire content
                connection.setRequestMethod("HEAD");
                connection.connect();
                if(connection.getResponseCode() == 200) { 

                } 
                else { 
                    System.out.println(link + " : " + connection.getResponseMessage() + " : " + connection.getResponseCode());
                    invalidLinkCount++;
                }
            } catch(MalformedURLException e) { 
                e.printStackTrace();
            }
        }
    }
    public static void getInvalidLinkCount() { System.out.println("Total Invalid Links : " + invalidLinkCount);}
}
