package base_Backage;

import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class BaseClass {

	public static AndroidDriver driver;

	public void setUpAppLaunch() {
		try {
			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setCapability("platformName", "Android");
			cap.setCapability("deviceName", "vivo 1915");
			cap.setCapability("udid", "YHB6TOS4Q8W8PF9X");
			cap.setCapability("automationName", "UiAutomator2");
			cap.setCapability("platformVersion", "12.0");
			cap.setCapability("appPackage", "com.expandtesting.practice");
			cap.setCapability("appActivity", "com.expandtesting.practice.MainActivity");

			URL url = new URL("http://0.0.0.0:4723/");
			driver = new AndroidDriver(url, cap);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			System.out.println("Application launched successfully.");
		} catch (Exception e) {
			System.out.println("App launch failed: " + e.getMessage());
		}
	}

	public void tearDown() {
		if (driver != null) {
			driver.quit();
			System.out.println("Application closed after all tests.");
		}
	}

	// ============= Common Methods =============
	public WebElement findElement(String type, String path) {
		WebElement element = null;
		switch (type.toLowerCase()) {
		case "id":
			element = driver.findElement(By.id(path));
			break;
		case "name":
			element = driver.findElement(By.name(path));
			break;
		case "classname":
			element = driver.findElement(By.className(path));
			break;
		case "xpath":
			element = driver.findElement(By.xpath(path));
			break;
		default:
			System.out.println("Invalid locator type: " + type);
			break;
		}
		return element;
	}

	public void click(WebElement element) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();

	}

	public void sendKeys(WebElement element, String value) {
		element.sendKeys(value);
	}

	public void clear(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.clear();
	}

	public String getText(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		wait.until(ExpectedConditions.elementToBeClickable(element));
		return element.getText();
	}

	public void scrollDown() {
		driver.findElement(
				AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollForward();"));
	}
}
