package keywords;

import org.openqa.selenium.support.ui.Select;
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
    public void validateSelectedValueInDropdown(String locatorKey, String value) { 
        Select dropdown = new Select(getElement(locatorKey));
        String selectedValue = dropdown.getFirstSelectedOption().getText();
        i("Selected value in DropDown : " + selectedValue);
        if(!selectedValue.equals(value)) { 
            reportFailure("Entered " + value + " is not available in Portfolio List", true);
        }
    }
    public void validateSelectedValueNotInDropdown(String locatorKey, String value) { 
        Select dropdown = new Select(getElement(locatorKey));
        String selectedValue = dropdown.getFirstSelectedOption().getText();
        i("Selected value in DropDown : " + selectedValue);
        if(selectedValue.equals(value)) { 
            reportFailure("Entered " + value + " is available in Portfolio List", true);
        }
    }
}
