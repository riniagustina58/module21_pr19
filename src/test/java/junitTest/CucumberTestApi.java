package junitTest;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/api",
        plugin = {"pretty", "html:reports/cucumber-api.html", "json:reports/cucumber-api.json"},
        glue = {"stepdef/api"},
        tags = "@api"
)
public class CucumberTestApi {

}
