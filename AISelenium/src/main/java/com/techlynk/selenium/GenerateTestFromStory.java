package com.techlynk.selenium;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class GenerateTestFromStory {
	public static void main(String[] args) {
		String userStory = """
				As a registered user,
				I want to log in to the website with valid credentials
				so that I can access my dashboard.
				
				Acceptance Criteria:
				- Navigate to https://opensource-demo.orangehrmlive.com/
				- Verify the Page Title
				- Enter valid username and password
				- Verify successful login by checking dashboard visibility or Page Title
				""";
		try { 
			// create AI code
			System.out.println("Sending user story to AI...");
			String generatedCode = OpenAIClientWrapper.generateCodeFromStory(userStory);
			System.out.println("\nAI Generated Test Code:\n");
			// System.out.println(generatedCode);
			
			// build timestamp-based filename and save
			String ts = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
			String filename = "target/generated-tests/AI_GeneratedTest_" + ts + ".java";
			OpenAIClientWrapper.saveToFile(generatedCode, filename);
			System.out.println("\nSaved generated file: " + filename);
		} catch(Exception e) { 
			e.printStackTrace();
		}
	}
	
}
