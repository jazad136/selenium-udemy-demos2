package keywords;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author JonathanSaddler
 */
public class ApplicationKeywords extends ValidationKeywords {
    public static String propsFilename = "src/test/resources/Properties/Project.properties";
    public ApplicationKeywords() { 
        prop = new Properties();
        try(FileInputStream fis = new FileInputStream(propsFilename)) { 
            prop.load(fis);
        } catch(IOException e) {
            throw new RuntimeException("Unexpected problem reading file %s properties file".formatted(propsFilename));
        }
    }
    public void login() {
        
    }
    
    public void selectDate() { 
        
    }
    public void quitDriver() { 
    	driver.quit();
    }
}
