package com.techlynk.selenium.scenario1;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author JonathanSaddler
 */
public class ExtractWebPagePart extends TestBase {

    public ExtractWebPagePart(String testName) { 
        super(testName);
        setTestUrl("https://edition.cnn.com/");
    }
    
    @Test
    public void extractWebElementTest() { 
        WebElement topStories = driver.findElement(By.xpath(
          "//*[@class='container container_lead-plus-headlines  lazy' and @data-collapsed-text='More top stories']"
        ));
        System.out.println("Is Top Stories Available : " + topStories.isDisplayed());
        List<WebElement> topStory = topStories.findElements(By.tagName("a"));
        System.out.println("Total Top Stories : " + topStory.size());
        
        for(WebElement story : topStory) 
            if(!story.getText().isEmpty()) 
                System.out.println(story.getText());
    }
}
