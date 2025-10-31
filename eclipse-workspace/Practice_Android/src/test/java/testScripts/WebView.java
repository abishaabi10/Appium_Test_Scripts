package testScripts;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import base_Backage.BaseClass;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

/**
 * Test class for verifying WebView functionality in the app.
 * Author: Abisha M
 * Date: 31-Oct-2025
 */
public class WebView extends BaseClass {

    /**
     * Test Case 1: Verify behavior when clicking "Go" without entering a URL.
     */
    @Test(priority = 1, description = "Verify clicking 'Go' without entering a URL displays an error message.")
    public void verifyGoButtonWithoutURL() {
//   setUpAppLaunch();
   System.out.println("WebView Start");

        WebElement webViewBtn = driver.findElement(By.id("com.expandtesting.practice:id/btn_web_view"));
        webViewBtn.click();

        WebElement goBtn = driver.findElement(By.id("com.expandtesting.practice:id/btn_go"));
        click(goBtn);

        WebElement message = driver.findElement(
                By.xpath("//android.widget.TextView[@text='Please navigate to a web page']"));
        String displayedText = message.getText();

        if (displayedText.equals("Please navigate to a web page")) {
            System.out.println("Validation Passed: " + displayedText);
        } else {
            System.out.println("Validation Failed: Unexpected text displayed.");
        }

        navigateBack();
    }

    /**
     * Test Case 2: Verify behavior when clicking "Clear" without entering a URL.
     */
    @Test(priority = 2, description = "Verify clicking 'Clear' without entering a URL displays an error message.")
    public void verifyClearButtonWithoutURL() {
        try {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            WebElement webViewBtn = driver.findElement(By.id("com.expandtesting.practice:id/btn_web_view"));
            webViewBtn.click();

            WebElement clearBtn = driver.findElement(By.id("com.expandtesting.practice:id/btn_clear"));
            click(clearBtn);

            WebElement message = driver.findElement(
                    By.xpath("//android.widget.TextView[@text='Please navigate to a web page']"));
            String displayedText = message.getText();

            if (displayedText.equals("Please navigate to a web page")) {
                System.out.println("Validation Passed: " + displayedText);
            } else {
                System.out.println("Validation Failed: Unexpected text displayed.");
            }

            navigateBack();
        } catch (Exception e) {
            System.out.println("Exception in verifyClearButtonWithoutURL: " + e.getMessage());
        }
    }

    /**
     * Test Case 3: Verify navigation to a valid webpage after entering a URL.
     */
    @Test(priority = 3, description = "Verify entering a valid URL and navigating to the page.")
    public void verifyWebNavigationFlow() {
        try {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            WebElement webViewBtn = driver.findElement(By.id("com.expandtesting.practice:id/btn_web_view"));
            webViewBtn.click();

            WebElement urlInput = driver.findElement(By.id("com.expandtesting.practice:id/et_url"));
            click(urlInput);
            urlInput.sendKeys("https://letcode.in/");

            WebElement goBtn = driver.findElement(By.id("com.expandtesting.practice:id/btn_go"));
            click(goBtn);

            System.out.println("URL entered successfully and navigation initiated.");
        } catch (Exception e) {
            System.out.println("Exception in verifyWebNavigationFlow: " + e.getMessage());
        }
    }

    /**
     * Common Method: Handles back navigation within the app or device.
     */
    @Test(priority = 4, description = "Navigate back to the previous screen.")
    public void navigateBack() {
        try {
            driver.pressKey(new KeyEvent(AndroidKey.BACK));
        } catch (Exception e) {
            System.out.println("Back is"+ e.getMessage());
        }
        System.out.println("WebView end");
    }
}