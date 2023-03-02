package generic;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Base {

	public WebDriver driver;

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
			return this.driver;
		}
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public void quitBrowser() {
		driver.quit();
	}
	
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
