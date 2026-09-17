package com.techlynk.selenium.generated;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class OrangeHRMLoginTest {

    private WebDriver driver;
    private WebDriverWait wait;

    private static final String BASE_URL = "https://opensource-demo.orangehrmlive.com/";
    private static final String EXPECTED_TITLE = "OrangeHRM";
    private static final String VALID_USERNAME = "Admin";
    private static final String VALID_PASSWORD = "admin123";

    @BeforeClass
    public void setUpChromeDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        if (Boolean.getBoolean("headless")) {
            options.addArguments("--headless=new");
        }
        driver = new ChromeDriver(options); // Selenium Manager (Selenium 4.6+) will resolve the driver
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0)); // Prefer explicit waits
    }

    @AfterClass(alwaysRun = true)
    public void tearDownAndQuitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test(description = "As a registered user, I can log in with valid credentials and see the Dashboard")
    public void testUserCanLoginWithValidCredentials() {
        // Navigate to application
        driver.get(BASE_URL);

        // Verify initial page title
        wait.until(ExpectedConditions.titleIs(EXPECTED_TITLE));
        Assert.assertEquals(driver.getTitle(), EXPECTED_TITLE, "Unexpected page title before login.");

        // Enter valid username and password
        WebElement usernameInput = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.name("username"))
        );
        WebElement passwordInput = driver.findElement(By.name("password"));

        usernameInput.clear();
        usernameInput.sendKeys(VALID_USERNAME);
        passwordInput.clear();
        passwordInput.sendKeys(VALID_PASSWORD);

        // Submit login form
        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
        loginButton.click();

        // Verify successful login by checking Dashboard visibility and URL
        WebElement dashboardHeader = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//h6[normalize-space()='Dashboard']"))
        );
        Assert.assertTrue(dashboardHeader.isDisplayed(), "Dashboard header should be visible after login.");

        // Optionally assert URL contains dashboard path for extra confidence
        wait.until(ExpectedConditions.urlContains("/dashboard"));
        Assert.assertTrue(driver.getCurrentUrl().contains("/dashboard"),
                "Expected to be navigated to the dashboard after login.");

        // Title typically remains "OrangeHRM" after login; verify it remains correct
        Assert.assertEquals(driver.getTitle(), EXPECTED_TITLE, "Unexpected page title after login.");
    }
}
