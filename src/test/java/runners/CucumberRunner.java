package runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(



      tags = "@db",




        features = "src/test/resources",

        glue = "stepDefinitions",
        stepNotifications = true,

        plugin = {"pretty",
                "html:target/built-in-report/built-in-report.html",
                //"html:target/built-in-reports/",
                "json:target/cucumber.json",
                "rerun:target/failed.txt"

                // ,dryRun = true             // step definition execution is skipped, used for generating snippets without running the code
        }









)


public class CucumberRunner {
}
