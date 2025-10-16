package stepdef;

import io.cucumber.java.en.Then;
import page.HomePage;

public class HomeStepDef extends BaseTest {

    HomePage homePage;

    @Then("user is on homepage")
    public void userIsOnHomepage () {
        homePage = new HomePage(driver);
        homePage.validateBackPackDisplayed();
    }
}
