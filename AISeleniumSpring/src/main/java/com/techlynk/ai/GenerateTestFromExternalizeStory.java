package com.techlynk.ai;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.techlynk.ai.config.UserStoryReader;

@SpringBootApplication
public class GenerateTestFromExternalizeStory implements CommandLineRunner {
	
	private UserStoryReader reader;
	public GenerateTestFromExternalizeStory(UserStoryReader reader) { 
		this.reader = reader;
	}

	@Override
	public void run(String... args) throws Exception {
		reader.readFromClasspath("user-story.txt");
	}
}

