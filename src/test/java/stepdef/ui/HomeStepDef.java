package stepdef.ui;

import io.cucumber.java.en.Then;
import org.junit.Assert;
import page.HomePage;

public class HomeStepDef extends BaseTest {

    HomePage homePage;

    @Then("user is on homepage")
    public void userIsOnHomepage () {
        homePage = new HomePage(driver);
        Assert.assertTrue( "Backpack item should be visible on the homepage.",homePage.validateBackPackDisplayed());
    }
}
