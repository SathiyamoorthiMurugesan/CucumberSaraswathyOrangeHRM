package stepDefinitions;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;

import generic.Base;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;

public class Hooks {

	Base base;
	public static Scenario scenario;

	@Before()
	public void initializeTest() throws Exception {

		base = new Base();
		base.launchBrowser("Chrome");

	}

	@After()
	public void closeBrowser() {
		base.quitBrowser();
	}
	
	@BeforeStep()
	public void loggerHtml(Scenario scenario) {
		Hooks.scenario = scenario;
	}
	
	
	@AfterStep()
	public void captureScreenshot(Scenario scenario) throws Exception {
		base.attachScreenshot(scenario);
	}
}
