package stepdef;


import io.cucumber.java.en.*;
import page.LoginPage;

import static org.junit.Assert.assertTrue;

public class LoginStepDef extends BaseTest{

    LoginPage loginPage;

    @Given("user is on login page")
    public void userIsOnLoginPage() {
        loginPage = new LoginPage(driver);
        loginPage.goToLoginPage();
    }

    @When("user input email text box with {string}")
    public void userInputEmailTextBoxWith(String email) {
       loginPage.inputUsername(email);
    }

    @And("user input password pada text box with {string}")
    public void userInputPasswordPadaTextBoxWith(String password) {
        loginPage.inputPassword(password);
    }

    @And("user click login button")
    public void userClickLoginButton() {
        loginPage.clickButton();
    }

    @Then("user see error message error {string}")
    public void userSeeErrorMessage(String errorMessage) {
        assertTrue(loginPage.validateErrorAppear().contains(errorMessage));
    }
}
