package runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(
//        tags = "@fail",

        features = "src/test/resources",

        glue = "stepDefinitions",
        stepNotifications = true,

        plugin = {"pretty",
                "html:target/built-in-report/built-in-report.html",
                "json:target/cucumber.json"
        }


        ,dryRun = true             // step definition execution is skipped, used for generating snippets without running the code
)


public class CucumberRunner {
}
