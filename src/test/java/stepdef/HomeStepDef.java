package stepdef;

import io.cucumber.java.en.Then;
import page.HomePage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class HomeStepDef extends BaseTest {

    HomePage homePage;

    @Then("user is on homepage")
    public void userIsOnHomepage () {
        homePage = new HomePage(driver);
        assertTrue(homePage.validateBackPackDisplayed(), "Backpack item should be visible on the homepage.");
    }
}
