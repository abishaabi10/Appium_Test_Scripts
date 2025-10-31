package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import base_Backage.BaseClass;
import io.appium.java_client.AppiumBy;

public class UtilityClass extends BaseClass {

    // ✅ Screenshot capture method
	public void takeScreenshot(String fileName) {
        try {
            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String filePath = System.getProperty("user.dir") + "/Screenshots/" + fileName + "_" + timestamp + ".png";

            File destFile = new File(filePath);
            destFile.getParentFile().mkdirs(); // Create directory if missing

            FileUtils.copyFile(srcFile, destFile);
            System.out.println("Screenshot saved at: " + filePath);

        } catch (IOException e) {
            System.out.println("Failed to capture screenshot: " + e.getMessage());
        }
    }

    // ✅ Scroll down (Generic)
    public void scrollDown() {
        try {
            driver.findElement(AppiumBy.androidUIAutomator(
                    "new UiScrollable(new UiSelector().scrollable(true)).scrollForward()"));
            System.out.println("Scrolled down successfully.");
        } catch (Exception e) {
            System.out.println("Scroll failed: " + e.getMessage());
        }
    }

    // ✅ Scroll up (if needed)
    public void scrollUp() {
        try {
            driver.findElement(AppiumBy.androidUIAutomator(
                    "new UiScrollable(new UiSelector().scrollable(true)).scrollBackward()"));
            System.out.println("Scrolled up successfully.");
        } catch (Exception e) {
            System.out.println("Scroll up failed: " + e.getMessage());
        }
    }

    // ✅ Wait (simple thread sleep)
    public void waitForSeconds(int sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
