package generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Base64;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;

import io.cucumber.java.Scenario;
import stepDefinitions.Hooks;

public class Base {

	public static WebDriver driver;

	public WebDriver launchBrowser(String browserName) throws Exception {
		if (browserName.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver_109.exe");
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", ".\\drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("Edge")) {
			System.setProperty("webdriver.edge.driver", ".\\drivers\\msedgedriver.exe");
			driver = new EdgeDriver();
		} else {
			System.out.println("Error Message ---->" + "browser name not mentioned properly");
		}

		return getDriver();
	}

	public WebDriver getDriver() {
		if (driver != null) {
			return Base.driver;
		}
		return driver;
	}

	public void setDriver(WebDriver driver) {
		Base.driver = driver;
	}
	
	public static String getBase64Screenshots() throws IOException {

		String base64StringOfScreenshot = "";
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("ddMMYYYY_HHmmss");

		String sDate = sdf.format(date);

		String screenshotdir = System.getProperty("user.dir") + "/folderName/" + "imageName" + sDate + ".png";
		File screenshotName = new File(screenshotdir);
		FileUtils.copyFile(src, screenshotName);

		byte[] fileContent = FileUtils.readFileToByteArray(screenshotName);
		base64StringOfScreenshot = "date:image/png;png;base64," + Base64.getEncoder().encodeToString(fileContent);

		return base64StringOfScreenshot;
	}
	
	public void attachScreenshot(Scenario scenario) throws Exception {
		final byte[] screenshot = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);

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


//	 ************** WebDriver methods ********************
//void get(String url);
//String getCurrentUrl();
//String getTitle();
//List<WebElement> findElements(By by);
//WebElement findElement(By by);
//String getPageSource();
//void close();
//void quit();
//Set<String> getWindowHandles();
//String getWindowHandle();
//TargetLocator switchTo();
//	WebDriver frame(int index);
//	WebDriver frame(String nameOrId);
//	WebDriver frame(WebElement frameElement);
//	WebDriver parentFrame();
//	WebDriver window(String nameOrHandle);
//	WebDriver newWindow(WindowType typeHint);
//	WebDriver defaultContent();
//	WebElement activeElement();
//	Alert alert();
//		void dismiss();
//		void accept();
//		String getText();
//		void sendKeys(String keysToSend);
//
//Navigation navigate();
//	void back();
//	void forward();
//	void to(String url);
//	void to(URL url);
//	void refresh();
//Options manage();
//	void addCookie(Cookie cookie);
//	void deleteCookieNamed(String name);
//	void deleteCookie(Cookie cookie);
//	void deleteAllCookies();
//	Set<Cookie> getCookies();
//	Cookie getCookieNamed(String name);
//	Timeouts timeouts();
//		default Timeouts implicitlyWait(Duration duration)
//		default Duration getImplicitWaitTimeout()
//		default Timeouts pageLoadTimeout(Duration duration)
//	Window window();
//		Dimension getSize();
//		void setSize(Dimension targetSize);
//		Point getPosition();
//		void setPosition(Point targetPosition);
//		void maximize();
//		void minimize();
//		void fullscreen();
//	Logs logs();
//		LogEntries get(String logType);
//		Set<String> getAvailableLogTypes();

	public void quitBrowser() {
		driver.close();
		driver.quit();
	}

	public void closeCurrentActionWindow() {
		driver.close();
	}

	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}

	public void goBackToPreviousWebPage() {
		driver.navigate().back();
	}

	public void switchToFrameUsingFrameIndex(int index) {
		driver.switchTo().frame(index);
	}

	public void switchToFrameUsingFrameName(String frameName) {
		driver.switchTo().frame(frameName);
	}

	public void switchToFrameUsingWebElementName(WebElement elementName) {
		driver.switchTo().frame(elementName);
	}

//	******* WebElement methods************************
//void click();
//void submit();
//void sendKeys(CharSequence... keysToSend);
//void clear();
//String getTagName();
//default String getDomProperty(String name)
//default String getDomAttribute(String name)
//String getAttribute(String name);
//default String getAriaRole()
//default String getAccessibleName()
//boolean isSelected();
//boolean isEnabled();
//String getText();
//default SearchContext getShadowRoot()
//boolean isDisplayed();
//Point getLocation();
//Dimension getSize();
//Rectangle getRect();
//String getCssValue(String propertyName);
	
	
	public void clickAnWebElement(WebElement ele) {
		ele.click();
	}
	
	public void sendTextToAnWebElement(WebElement ele, String text) {
		ele.sendKeys(text);
	}

	/*
	 * Actions class methods
	 */

	/*
	 * Select class methods
	 */

	/*
	 * Robot class methods
	 */

	public void maximizeBrowserWindow() {
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}

//	public String getBase64Screenshots() throws IOException {
//		String Base64StringOfScreenshot = "";
//		File src = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
//
//		Date date = new Date();
//		SimpleDateFormat sdf = new SimpleDateFormat("ddMMYYYY_HHmmss");
//		String sDate = sdf.format(date);
//
//		String screentshotdir = System.getProperty("user.dir") + "\\test-output\\screenshots\\" + "image" + sDate
//				+ ".png";
//		File screenshotName = new File(screentshotdir);
//		FileUtils.copyFile(src, screenshotName);
//
//		byte[] FileContent = FileUtils.readFileToByteArray(screenshotName);
//		Base64StringOfScreenshot = "data:image/png;base64," + Base64.getEncoder().encodeToString(FileContent);
//		return Base64StringOfScreenshot;
//
//	}

	/*
	 * Wait Methods
	 */
	public void waitForElementToBeVisible(WebElement ele, long seconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		wait.until(ExpectedConditions.visibilityOf(ele));
	}

	public void pause(Integer seconds) {
		try {
			TimeUnit.SECONDS.sleep(seconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public String readAProperty(String propertyName) throws Exception {
		Properties prop = new Properties();
		String path = System.getProperty("user.dir") + "\\src\\test\\resources\\project.properties";
		FileInputStream fs = new FileInputStream(path);
		prop.load(fs);
		return prop.getProperty(propertyName);
	}
}
