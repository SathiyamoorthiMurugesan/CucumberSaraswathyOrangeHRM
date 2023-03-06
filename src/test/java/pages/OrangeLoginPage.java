package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import generic.Base;
import stepDefinitions.Hooks;

public class OrangeLoginPage {
	
	WebDriver driver ;
	Base base = new Base();
	
	public OrangeLoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "username")
	WebElement textBox_UserName;
	
	@FindBy(name = "password")
	WebElement textBox_Password;
	
	@FindBy(xpath = "//button[@type = 'submit']")
	WebElement button_Login;
	
	@FindBy(xpath = "//p[text()= 'Forgot your password? ']")
	WebElement link_ForgotPassword;
	
	@FindBy(xpath = "//div[@class = 'orangehrm-login-footer-sm']/a[1]")
	WebElement link_LinkedIn;
	
	@FindBy(xpath = "//div[@class = 'orangehrm-login-footer-sm']/a[2]")
	WebElement link_Facebook;
	
	@FindBy(xpath = "//div[@class = 'orangehrm-login-footer-sm']/a[3]")
	WebElement link_Twitter;
	
	@FindBy(xpath = "//div[@class = 'orangehrm-login-footer-sm']/a[4]")
	WebElement link_YouTube;
	
	@FindBy(xpath = "//h6[text() = 'Reset Password']")
	WebElement text_ForgotPassword_ResetPassword;
	
	@FindBy(name = "username")
	WebElement textBox_ForgotPassword_UserName;
	
	
	public void launchApplication() {
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		base.maximizeBrowserWindow();
	}
	
	public void loginOrangeHRM(String userName, String password) throws Exception {
		textBox_UserName.sendKeys(userName);
		textBox_Password.sendKeys(password);
		base.attachScreenshot(Hooks.scenario);
		button_Login.click();
		base.pause(10);
	}
	
	public void loginOrangeHRM1() {
		base.sendTextToAnWebElement(textBox_UserName, "Admin");
		base.sendTextToAnWebElement(textBox_Password, "admin123");
		base.clickAnWebElement(button_Login);
//		textBox_UserName.sendKeys("Admin");
//		textBox_Password.sendKeys("admin123");
//		button_Login.click();
		base.pause(10);
	}
	
	public void loginOrangeHRM() throws Exception {
		textBox_UserName.sendKeys(base.readAProperty("userName"));
		textBox_Password.sendKeys(base.readAProperty("password"));
		button_Login.click();
		base.pause(10);
	}
	
	public void resetPassword(String userName) {
		link_ForgotPassword.click();
		base.waitForElementToBeVisible(text_ForgotPassword_ResetPassword, 10);
	}
	
	

}
