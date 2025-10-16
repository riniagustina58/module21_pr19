/* Selenium Test
package junitTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import page.HomePage;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class LoginTest {

    @Test
    public void loginTest() {
        //configuration chrome version conflict
        WebDriverManager.chromedriver()
                .driverVersion("141.0.7390.66")  // Replace with correct version
                .setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        //Test
        driver.get("https://www.saucedemo.com/");

        // Perform login steps
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        // Validate HomePage
        HomePage homePage = new HomePage(driver);
        homePage.validateBackPackDisplayed();

        // Optionally assert you landed on inventory page
        assertEquals("https://www.saucedemo.com/inventory.html", driver.getCurrentUrl());

    }
}
*/
