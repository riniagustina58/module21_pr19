package stepdef;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import page.AddToChartPage;
import page.LoginPage;

public class AddToChart extends BaseTest{

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
    public void itemAddedToChart(String arg0) {
        addToChartPage.validate(arg0);
    }

    @Then("item not Added to chart {string}")
    public void itemNotAddedToChart(String arg0) {
        addToChartPage.validateError(arg0);
    }
}
