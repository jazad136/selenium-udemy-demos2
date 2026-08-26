package com.techlynk.selenium;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.logging.Logger;

import com.openai.client.OpenAIClient;
import com.openai.client.okhttp.OpenAIOkHttpClient;
import com.openai.models.ChatModel;
import com.openai.models.chat.completions.ChatCompletion;
import com.openai.models.chat.completions.ChatCompletionCreateParams;

public class OpenAIClientWrapper {
	private static final Logger LOGGER = Logger.getLogger(OpenAIClientWrapper.class.getName());
	private final OpenAIClient client;
	public OpenAIClientWrapper() {
		String apiKey = Config.getApiKey();
		if(apiKey == null || apiKey.isBlank()) 
			throw new IllegalArgumentException("API key must not be blank");
		this.client = OpenAIOkHttpClient.builder().apiKey(apiKey).build();
	}
//	public OpenAIClientWrapper(OpenAIClient client) {
//		String apiKey = Config.getApiKey();
//		if(apiKey == null || apiKey.isBlank()) 
//			throw new IllegalArgumentException("API key must not be blank");
//		this.client = client;
//	}
	public String generateCodeFromStory(String userStory) throws IOException { 
		if(userStory == null || userStory.isBlank()) { 
			throw new IllegalArgumentException("userStory must not be blank");
		}
		// Construct the system prompt
		String systemPrompt = """
			You are an expert Test Automation Engineer. Generate a clean, maintainable Selenium + TestNG test in Java.
			Provide full Java source code with imports, class, method, ChromeDriver setup and teardown, descriptive naming, and assertions.
			""";
		
		// create chat completion parameters
		ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
				.model(ChatModel.GPT_5)
				.addSystemMessage(systemPrompt)
				.addUserMessage("User Story / Acceptance Criteria:\n\n" + userStory)
				.build();

		// call the API
		ChatCompletion result = client.chat().completions().create(params);
		// extract content
		String code = result.choices().get(0).message().content().orElseThrow(() -> 
			new IOException("No content in OpenAI response")
		);
		return code.trim();
	}
	public void saveToFile(String code, String fileName) throws IOException { 
		if(code == null || code.isBlank()) { 
			throw new IllegalArgumentException("code must not be blank.");
		}
		if(fileName == null || fileName.isBlank()) { 
			throw new IllegalArgumentException("fileName must not be blank.");
		}
		Path path = Path.of(fileName).toAbsolutePath();
		Files.writeString(path, code, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
		LOGGER.info("Saved generated code to: " + path);
	}
}
