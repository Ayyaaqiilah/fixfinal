package web.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/web",
        glue = {"web.steps"},
        tags = "@web",
        plugin = {
                "pretty",
                "html:build/reports/cucumber/web/index.html",
                "json:build/reports/cucumber/web/report.json"
        },
        monochrome = true
)
public class WebTestRunner { }
