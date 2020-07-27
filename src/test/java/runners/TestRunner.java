package runners;


import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = ".\\src\\test\\resources\\Feature\\api.feature",glue = ".\\src\\test\\java\\StepDef\\ApiTest.java",monochrome = true,dryRun = false)
public class TestRunner {

}
