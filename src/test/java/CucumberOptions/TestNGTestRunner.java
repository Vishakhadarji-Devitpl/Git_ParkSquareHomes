package CucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
			features = "C:/Users/vishakha.darji/Git_ParkSquareHomes/src/test/java/Features",
			glue = "StepDefinition",
			monochrome = true,
			tags = "@ManageServiceRequest or @BPRACalculation",
			plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:","rerun:target/failed_Scenario.txt"}
		)
public class TestNGTestRunner extends AbstractTestNGCucumberTests{

}
