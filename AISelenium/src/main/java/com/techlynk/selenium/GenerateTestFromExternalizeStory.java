package com.techlynk.selenium;

import java.io.IOException;

public class GenerateTestFromExternalizeStory {

	public static void main(String[] args) { 
		String story = UserStoryReader.readFromClasspath("user-story.txt");
		System.out.println("User story content:\n" + story);
		try {
			String generatedCode = OpenAIClientWrapper.generateCodeFromStory(story);
			System.out.println("\nAI Generated Test Code\n");
			System.out.println(generatedCode);
		} catch(IOException e) { 
			throw new RuntimeException("Could not generate code due to IOException", e);
		}
	}
}
