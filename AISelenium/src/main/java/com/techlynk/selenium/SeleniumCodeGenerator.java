package com.techlynk.selenium;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SeleniumCodeGenerator {
	
	public static void main(String[] args) throws IOException { 
		String resourcePath = "src/test/resources/AI_Generated_JSON_Test.json";
		
		System.out.println("Reading JSON test case file: " + resourcePath);
		String userStory = Files.readString(Path.of(resourcePath));
		System.out.println("\nSending Test Cases to AI for Selenium Script generation...\n");
		try { 
			String generatedCode = OpenAIClientWrapper.generateCodeFromStory(userStory);
			System.out.println("\nAI Generated Test Code:\n");
			String ts = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
			String fileName = "target/generated-tests/AI_GeneratedTest_" + ts + ".java";
			OpenAIClientWrapper.saveToFile(generatedCode, fileName);
			System.out.println("\nSaved generated File: " + fileName);
		} catch(Exception e) { 
			e.printStackTrace();
		}
	}
}
