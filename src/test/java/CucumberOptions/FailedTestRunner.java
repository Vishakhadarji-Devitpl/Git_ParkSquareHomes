package CucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
			features = "@target/failed_Scenario.txt",
			glue = "StepDefinition",
			monochrome = true,
			plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
		)
public class FailedTestRunner extends AbstractTestNGCucumberTests{

}
