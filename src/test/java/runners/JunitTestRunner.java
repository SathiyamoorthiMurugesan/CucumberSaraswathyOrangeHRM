package runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src\\test\\resources\\features"
		,glue = {"stepDefinitions"}
		, tags = "@LoginWithParameter1"
		, plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
//		, dryRun = true
		)	

public class JunitTestRunner {

}
