package stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import page.AddToChartPage;
import page.LoginPage;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AddToChartStepDef extends BaseTest{

    AddToChartPage addToChartPage;
    LoginPage loginPage;

    @Given("user is already on homepage {string} {string}")
    public void userIsAlreadyOnHomepage(String username, String password) {
        loginPage = new LoginPage(driver);
        loginPage.goToLoginPage();
        loginPage.inputUsername(username);
        loginPage.inputPassword(password);
        loginPage.clickButton();
    }

    @And("user click add to chart button")
    public void userClickAddToChartButton() {
        addToChartPage = new AddToChartPage(driver);
        addToChartPage.selectItem();
    }


    @Then("item added to chart {string}")
    public void itemAddedToChart(String str) {
        assertTrue(addToChartPage.validate().equalsIgnoreCase(str));
    }

    @Then("item not Added to chart {string}")
    public void itemNotAddedToChart(String str) {
        assertFalse(addToChartPage.validateError().equalsIgnoreCase(str));
    }

}
