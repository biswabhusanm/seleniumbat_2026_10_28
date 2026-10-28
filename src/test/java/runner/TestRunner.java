package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"stepdefs","Hooks"},
        plugin = {
                "dev.reportinglabs.cucumber.ReportingLabsPlugin",
                "pretty",
                "html:target/cucumber-reports/cucumber.html",
                "json:target/cucumber-reports/cucumber.json"
        },
        monochrome = true,
        dryRun = false,
         tags ="@smoke"
)
public class TestRunner {
}
