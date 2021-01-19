package CucumberTest;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
	    features = "Features",
	    glue = {"stepDefinition"},
	    tags = "@SimpleAlert",
	    strict = true,
	    plugin = {"json:C:/Users/KavyaKode/eclipse-workspace/CucumberActivitiestest-reports/json-report.json"},
	    monochrome = true
	)

public class ActivitiesRunner1_3 {
    //empty
}