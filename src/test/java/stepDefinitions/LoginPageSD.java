package stepDefinitions;

import generic.Base;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CommonPagesInOrangeHRM;
import pages.OrangeLoginPage;

public class LoginPageSD {
	
	Base base = new Base();
	OrangeLoginPage loginPage = new OrangeLoginPage(base.getDriver());
	CommonPagesInOrangeHRM commonPage = new CommonPagesInOrangeHRM(base.getDriver());
	
	@Given("user launches OrangeHRM page")
	public void user_launches_orange_hrm_page() {
		loginPage.launchApplication();
	}

	@Then("validate user is on login page")
	public void validate_user_is_on_login_page() {
		commonPage.validateAnyPagesInOrangeHRM("Login");
	}

	@When("user enters username and password and clicks on login button")
	public void user_enters_username_and_password_and_clicks_on_login_button() {
		loginPage.loginOrangeHRM1();	
	}

	@Then("user able to see home page of OrangeHRM")
	public void user_able_to_see_home_page_of_orange_hrm() {
		commonPage.validateAnyPagesInOrangeHRM("Dashboard");	
	}
	
//	@When("user enters username as {string} and password{string} and clicks on login button")
//	public void user_enters_username_as_and_password_admin123_and_clicks_on_login_button1(String string, String string2) {
//
//	}
	
	@When("user enters username as {string} and password{string} and clicks on login button")
	public void user_enters_username_as_and_password_admin123_and_clicks_on_login_button(String string, String string2) throws Exception {
		System.out.println(string);
		System.out.println(string2);
		loginPage.loginOrangeHRM(string, string2);
	}
	
	
//	@When("user enters {string} and {string} and clicks on login button")
//	public void user_enters_and_and_clicks_on_login_button(String string, String string2) {
// 
//	}

}
