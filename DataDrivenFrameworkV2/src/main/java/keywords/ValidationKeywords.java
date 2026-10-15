package keywords;

import org.testng.Assert;

/**
 *
 * @author JonathanSaddler
 */
public class ValidationKeywords extends GenericKeywords {
    public void validateTitle(String expectedTitle) { 
        Assert.assertEquals(driver.getTitle(), prop.getProperty(expectedTitle));
    }
    public void validateText() { 
        
    }
    public void validateElementPresent() { 
        
    }
    public void validateElementClickable() { 
        
    }
    public void validateElementDisplayed() { 
        
    }
}
