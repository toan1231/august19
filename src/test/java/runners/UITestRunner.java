package runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty","html:target/cucumber",
        "json:target/cucumber.json"},
        features="src/test/resources/uiFeatures",
        glue="ui_automation.step_definitions",
        tags="@mb-01",//remember to take off 1
        dryRun = false
        //monochrome = true
)

public class UITestRunner {

}
/*
to have : cucumber-html-reports click terminal then type :
mvn "-Dtest=runners.UITestRunner" verify
if you want to clear up the console type clear then enter






 */