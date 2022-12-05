package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/java/FeatureFiles/"},
        glue = {"StepDefinations"},
        plugin = {"pretty", "html:src/test/java/Reports/HTMLReports/_01_RunOnlyReport.html", "json:src/test/java/Reports/HTMLReports/JsonReports/cucumber.json"}
)
public class RunAll extends AbstractTestNGCucumberTests {


}
