package runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(


<<<<<<< HEAD
      tags = "@db",
=======
       tags = "@db",
>>>>>>> f54008acc53cae50c9fddfe99d4267044dc81065


        features = "src/test/resources",

        glue = "stepDefinitions",
        stepNotifications = true,

        plugin = {"pretty",
                "html:target/built-in-report/built-in-report.html",
                //"html:target/built-in-reports/",
                "json:target/cucumber.json"
        }



<<<<<<< HEAD
    // ,dryRun = true             // step definition execution is skipped, used for generating snippets without running the code
=======
   //  ,dryRun = true             // step definition execution is skipped, used for generating snippets without running the code
>>>>>>> f54008acc53cae50c9fddfe99d4267044dc81065




)


public class CucumberRunner {
}
