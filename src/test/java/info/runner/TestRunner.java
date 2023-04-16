package info.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
                 dryRun = false,
                 monochrome = true,
                 plugin = {"pretty", "html:test-output.html", "io.qameta.allure.cucumber4jvm.AllureCucumber4Jvm"},
                 glue = {"info.steps","info.steps.common"},
                 features = {"features/TestCase_v1.feature"}
                )

public class TestRunner {

}
