package stepDefinitions;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;

import generic.Base;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

	Base base;
	public static Scenario scenario;

	@Before
	public void initializeTest() throws Exception {

		base = new Base();
		base.launchBrowser("Chrome");

	}

	@After
	public void closeBrowser() {
		base.quitBrowser();
	}
	
	
	@AfterStep
	public void attachScreenshot(Scenario scenario) throws Exception {
		final byte[] screenshot = ((TakesScreenshot) base.getDriver()).getScreenshotAs(OutputType.BYTES);

		if (Hooks.scenario.isFailed()) {
			Hooks.scenario.attach(screenshot, "image/png", "Failed Test Step Screenshot");
			Hooks.scenario.attach("Failed Screenshot", "text/html", "Failed Test Steps Text");
			ExtentCucumberAdapter.addTestStepScreenCaptureFromPath(Base.getBase64Screenshots());
			ExtentCucumberAdapter.addTestStepLog("Failed Screenshot");
		}

		else {
			Hooks.scenario.attach(screenshot, "image/png", "Passed Test Step Screenshot");
			Hooks.scenario.attach("Passed Screenshot", "text/html", "Failed Test Steps Text");
			ExtentCucumberAdapter.addTestStepScreenCaptureFromPath(Base.getBase64Screenshots());
			ExtentCucumberAdapter.addTestStepLog("Passed Screenshot");
		}

	}

}
