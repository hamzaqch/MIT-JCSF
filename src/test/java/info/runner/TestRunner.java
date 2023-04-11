package info.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"features/TestCase_v1.feature"},
                 glue = {"info.steps"},
                 dryRun = false,
                 monochrome = true,
                 plugin = {"pretty", "html:test-output.html"}
                )

public class TestRunner {

}
