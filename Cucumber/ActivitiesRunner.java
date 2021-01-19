package CucumberTest;

import io.cucumber.junit.CucumberOptions;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "Features",
    glue = {"stepDefinitions"},
    tags = "@activity1_2",
    strict = true
)

public class ActivitiesRunner {
    //empty
}
