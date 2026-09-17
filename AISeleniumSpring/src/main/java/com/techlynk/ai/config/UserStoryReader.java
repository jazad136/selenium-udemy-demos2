package com.techlynk.ai.config;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import org.springframework.stereotype.Component;
@Component
public class UserStoryReader {
	
	public String readFromClasspath(String userStoryPath) {
		if(userStoryPath == null || userStoryPath.isBlank()) 
			throw new IllegalArgumentException("resourcePath must not be null or empty");
		
		try {
			InputStream inputStream = UserStoryReader.class.getClassLoader().getResourceAsStream(userStoryPath);
			if(inputStream == null)
				throw new RuntimeException("File not found in resources: " + userStoryPath);
			BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
			StringBuilder content = new StringBuilder();
			String line;
			while((line = reader.readLine()) != null) { 
				content.append(line).append(System.lineSeparator());
			}
			reader.close();
			return content.toString().trim();
		}catch(Exception e) { 
			throw new RuntimeException(e);
		}
	}
}
