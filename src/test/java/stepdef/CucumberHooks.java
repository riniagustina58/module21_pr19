package stepdef;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

public class CucumberHooks extends BaseTest {

    @Before
    public void beforeTest() {
        getDriver();
    }

    @After
    public void AfterTest() {
        driver.close();
    }
}
