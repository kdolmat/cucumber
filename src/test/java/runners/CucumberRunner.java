package runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(
        tags = "@temp",
        features = "src/test/resources",
        glue = "stepDefinitions",
        stepNotifications = true,
        plugin = {"pretty",
                "html:target/built-in-report/built-in-report.html",
                "json:target/cucumber.json"
                //        ,dryRun = true
        }

        )


public class CucumberRunner {
}