package stepdef;


import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.CheckoutPage;
import page.LoginPage;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CheckoutStepDef extends BaseTest {

    LoginPage loginPage;
    CheckoutPage checkoutPage;

    @Given("user is on homepage {string} {string}")
    public void userIsOnHomepage(String username, String password) {
        loginPage = new LoginPage(driver);
        loginPage.goToLoginPage();
        loginPage.inputUsername(username);
        loginPage.inputPassword(password);
        loginPage.clickButton();
    }


    @And("user select all item")
    public void userSelectAllItem() {
        checkoutPage = new CheckoutPage(driver);
        checkoutPage.selectAllItem();

    }

    @And("click chart")
    public void clickChart() {
        checkoutPage.clickChartButton();
    }

    @And("user at checkout page")
    public void userAtCheckoutPage() {
        checkoutPage.onCheckoutPage();
    }

    @And("click checkout button")
    public void clickCheckoutButton() {
        checkoutPage.clickCheckoutButton();
    }


    @And("user at input checkout information")
    public void userAtInputCheckoutInformation() {
        checkoutPage.onCheckoutInformation();
    }

    @Then("input checkout information {string} {string} {string}")
    public void inputCheckoutInformation(String firstName, String lastName, String zip) {
        checkoutPage.inputCheckoutInformation(firstName, lastName, zip);

    }

    @And("click continue button")
    public void clickContinueButton() {
        checkoutPage.clickContinueButton();
    }

    @And("user is on checkout overview")
    public void userIsOnCheckoutOverview() {
        checkoutPage.onCheckoutOverview();
    }

    @And("click finish button")
    public void clickFinishButton() {
        checkoutPage.clickFinishButton();
    }

    @Then("checkout completed {string}")
    public void checkoutCompleted(String message) {
        checkoutPage.onFinishPage(message);
    }

    @Then("checkout not completed {string}")
    public void checkoutNotCompleted(String message) {
        checkoutPage.onFinishPageNegative(message);

    }
}
