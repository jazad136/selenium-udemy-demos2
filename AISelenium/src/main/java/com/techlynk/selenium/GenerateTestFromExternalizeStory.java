package com.techlynk.selenium;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GenerateTestFromExternalizeStory {

    public static void main(String[] args) { 
        String story = UserStoryReader.readFromClasspath("user-story.txt");
        System.out.println("User story content:\n" + story);
        try {
            String generatedCode = OpenAIClientWrapper.generateCodeFromStory(story);
            System.out.println("\nAI Generated Test Code\n");
            // System.out.println(generatedCode);
            // build timestamp-based filename and save
            String ts = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
            String filename = "target/generated-tests/AI_GeneratedTest_" + ts + ".java";
            OpenAIClientWrapper.saveToFile(generatedCode, filename);
                System.out.println("\nSaved generated file: " + filename);
        } catch(IOException e) { 
            throw new RuntimeException("Could not generate code due to IOException", e);
        }
    }
}
