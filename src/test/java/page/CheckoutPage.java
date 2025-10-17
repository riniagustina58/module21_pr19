package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import stepdef.BaseTest;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CheckoutPage extends BaseTest {
    WebDriver driver;
    By addItem1 = By.id("add-to-cart-sauce-labs-backpack");

    By clickChartButton = By.cssSelector("[data-test='shopping-cart-link']");

    By checkoutPage = By.cssSelector("[data-test='inventory-item-name']");

    By clickCheckoutButton = By.id("checkout");

    By checkoutInformation = By.cssSelector("[data-test='title']");

    By firstNameField = By.cssSelector("[data-test='firstName']");
    By lastNameField = By.cssSelector("[data-test='lastName']");
    By postalCodeField = By.cssSelector("[data-test='postalCode']");

    By continueButton = By.cssSelector("[data-test='continue']");

    By checkoutOverview = By.xpath("//span[@data-test='title' and text()='Checkout: Overview']");

    By finishButton = By.id("finish");

    By thankYouMessage = By.cssSelector("[data-test='complete-header']");


    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectAllItem() {
        driver.findElement(addItem1).click();

    }

    public void clickChartButton() {
        driver.findElement(clickChartButton).click();
    }
    public boolean onCheckoutPage(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement backPackElement = wait.until(ExpectedConditions.visibilityOfElementLocated(checkoutPage));
        return backPackElement.isDisplayed();
    }

    public void clickCheckoutButton()  {
        driver.findElement(clickCheckoutButton).click();
    }

    public boolean onCheckoutInformation () {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement backPackElement = wait.until(ExpectedConditions.visibilityOfElementLocated(checkoutInformation));
        return backPackElement.isDisplayed();
    }

    public void inputCheckoutInformation (String firstName, String lastName, String zip)  {
        driver.findElement(firstNameField).sendKeys(firstName);
        driver.findElement(lastNameField).sendKeys(lastName);
        driver.findElement(postalCodeField).sendKeys(zip);

    }

    public void clickContinueButton () {
        driver.findElement(continueButton).click();
    }

    public boolean  onCheckoutOverview () {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement backPackElement = wait.until(ExpectedConditions.visibilityOfElementLocated(checkoutOverview));
        return backPackElement.isDisplayed();
    }

    public void clickFinishButton () {
        driver.findElement(finishButton).click();
    }

    public String onFinishPage () {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement backPackElement = wait.until(ExpectedConditions.visibilityOfElementLocated(thankYouMessage));
        if(backPackElement.isDisplayed()){
           return driver.findElement(thankYouMessage).getText();
        }
        return null;

    }

    public String onFinishPageNegative () {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement backPackElement = wait.until(ExpectedConditions.visibilityOfElementLocated(thankYouMessage));
        if(backPackElement.isDisplayed()){
            return driver.findElement(thankYouMessage).getText();
        }
        return null;
    }







}

