package com.techlynk.selenium;

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
			System.out.println("Sending user story to AI...");
			String generatedCode = OpenAIClientWrapper.generateCodeFromStory(userStory);
			System.out.println("\nAI Generated Test Code:\n");
			System.out.println(generatedCode);
		} catch(Exception e) { 
			e.printStackTrace();
		}
	}
	
}
