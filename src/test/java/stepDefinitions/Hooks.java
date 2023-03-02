package stepDefinitions;

import generic.Base;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

	Base base;

	@Before
	public void initializeTest() throws Exception {

		base = new Base();
		base.launchBrowser("Chrome");

	}

	@After
	public void closeBrowser() {
		base.quitBrowser();
	}

}
