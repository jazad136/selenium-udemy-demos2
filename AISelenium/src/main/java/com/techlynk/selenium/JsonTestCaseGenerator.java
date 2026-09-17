package com.techlynk.selenium;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.openai.client.OpenAIClient;
import com.openai.client.okhttp.OpenAIOkHttpClient;
import com.openai.models.ChatModel;
import com.openai.models.chat.completions.ChatCompletion;
import com.openai.models.chat.completions.ChatCompletionCreateParams;

public class JsonTestCaseGenerator {
	public static void main(String[] args) {
		String userStory = UserStoryReader.readFromClasspath("user-story.txt");
		System.out.println("User story content:\n" + userStory);
		
		System.out.println("\n Sending user story to AI for JSON Test Case generation...");
		
		try { 
			String jsonOutput = generateJsonTestCase(userStory);
			String ts = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
			String filename = "target/generated-tests/AI_GeneratedTest_" + ts + ".json";
			OpenAIClientWrapper.saveToFile(jsonOutput, filename);
			System.out.println("\nSaved generated file: " + filename);
		} catch(IOException e) { 
			throw new RuntimeException("Could not generate code due to IOException", e);
		}
		// from SampleTestOpenAI
//		String prompt = 
//				"""
//				You are a software QA engineer. Given the following user story, generate 3 test cases in Gherkin format (Given/When/Then)."
//				Provide each test case with:
//				- Title
//				- Preconditions
//				- Steps in Gherkin (Given/When/Then)
//				- Expected result summary
//				
//				"User story:
//				%s
//				Respond only with a JSON array of objects with fields: title, preconditions, gherkin, expected.;
//				""".formatted(userStory);
//		ResponseCreateParams params = ResponseCreateParams.builder()
//				.input(prompt).model("gpt-4.1").build();
//		try {
//			Response response = client.responses().create(params);
//			System.out.println(response.output());	
//		} catch(Exception e) { 
//			System.err.println("Error calling OpenAI: " + e.getMessage());
//		}
		
		// from GenerateTestFromExternalizeStory
//		try {
//			String generatedCode = OpenAIClientWrapper.generateCodeFromStory(userStory);
//			System.out.println("\nAI Generated Test Code\n");
////			System.out.println(generatedCode);
//			// build timestamp-based filename and save
//			String ts = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
//			String filename = "target/generated-tests/AI_GeneratedTest_" + ts + ".java";
//			OpenAIClientWrapper.saveToFile(generatedCode, filename);
//			System.out.println("\nSaved generated file: " + filename);
//		} catch(IOException e) { 
//			throw new RuntimeException("Could not generate code due to IOException", e);
//		}
		
	}
	private static String generateJsonTestCase(String userStory) throws IOException {
		String systemPrompt = """
				You are an expert Test Automation Engineer. 
				Convert the following user story or requirement into a structured JSON Test Case.
				Use clear fields: testCaseName, description, and steps (each step should include 
				step number, action, target, and any input values or expected validations).
				Do NOT include code. Only return valid JSON.
		""";
		String apiKey = Config.getApiKey();
		OpenAIClient client = OpenAIOkHttpClient.builder().apiKey(apiKey).build();
		
		// below is similar to OpenAIClientWrapper
		// create parameters
		ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
				.model(ChatModel.GPT_5)
				.addSystemMessage(systemPrompt)
				.addUserMessage("User Story / Acceptance Criteria:\n\n" + userStory)
				.build();

		ChatCompletion result = client.chat().completions().create(params);
		String jsonTestCase = result.choices().get(0).message().content().orElseThrow(() -> 
			new IOException("No content in OpenAI response")
		);
		return jsonTestCase.trim();
	}
}
