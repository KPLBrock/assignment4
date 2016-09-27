package edu.csumb.cst438fa16hello.webclient;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * User story:
 *
 *   As a user I want to be able to make sure that I'm not logged in with an empty form.
 *
 * Class name ends in IT so it runs with "mvn integration-test", not "mvn test".
 */
public class VolunteerLoginIT {
    // Requires chromedriver. See:
    // http://docs.seleniumhq.org/docs/03_webdriver.jsp#chromedriver
    // On Mac you can install it with "brew install googledriver" if you have Homebrew.
    WebDriver driver = new ChromeDriver();

    @Before
    public void setUp() {
        driver.get("http://localhost:8080/userlogin.html");
    }

    @After
    public void tearDown() {
        driver.quit(); // close browser
    }

    /**
     * Acceptance test:
     *
     *   Given I am on the login screen
     *   When I enter a username that is not empty
     *   Then I see the greeting "Welcome user!"
     */
    @Test
    public void testForEmptyUsername() {
        assertThat(driver.findElement(By.id("name")).getText(), not(equalTo("")));
        // The greeting is rendered dynamically with JavaScript.
        // Wait for the page to load, timeout after 10 seconds
        if(!driver.findElement(By.id("name")).getText().isEmpty())
        {
        (new WebDriverWait(driver, 10))
            .until(ExpectedConditions.textToBe(By.id("name"), "Welcome user!"));
        }

        // Success
    }
}
