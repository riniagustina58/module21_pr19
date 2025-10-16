package page;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;
public class HomePage {

    WebDriver driver;
    By backPackItem = By.xpath("//*[@id='item_4_title_link']/div");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void validateBackPackDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement backPackElement = wait.until(ExpectedConditions.visibilityOfElementLocated(backPackItem));
        assertTrue(backPackElement.isDisplayed(), "Backpack item should be visible on the homepage.");
    }

}
