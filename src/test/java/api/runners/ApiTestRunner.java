package api.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/api",
        glue = {"api.steps"},
        tags = "@api",
        plugin = {"pretty", "html:reports/api-report.html", "json:reports/api-report.json"}
)
public class ApiTestRunner {
}
