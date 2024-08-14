package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "./src/test/resources/features/GeneralEnquiry.feature",
        glue = {"stepDefinitions", "utils"},
        monochrome = true,
        plugin = {"pretty","io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
                  "json:target/MyReports/report.json",
                   "junit:target/MyReports/report.xml",
                    "rerun:target/failedrerun.txt",
                    "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
                    },
        publish = false,
        dryRun = false
        //tags = "@Smoke"
)

public class TestRunner {
}
