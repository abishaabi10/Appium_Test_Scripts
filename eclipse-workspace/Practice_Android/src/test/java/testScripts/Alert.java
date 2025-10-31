package testScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import base_Backage.BaseClass;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

/**
 * Test class to handle Native Alert popups in the app. Author: Abisha M Date:
 * <Add today's date>
 */
public class Alert extends BaseClass {

	@Test(priority = 1, description = "Verify that native alert dialog is displayed and handled successfully")
	public void handleNativeAlert() {
		try {

			// Click the button that opens the alert dialog
			WebElement openAlertBtn = driver.findElement(By.id("com.expandtesting.practice:id/btn_alert_dialog"));
			click(openAlertBtn);

			// Capture and print the alert message text
			WebElement alertMessage = driver.findElement(By.id("com.expandtesting.practice:id/tv_message"));
			String messageText = alertMessage.getText();
			System.out.println("Alert Message: " + messageText);

			// Click on the OK button to close the alert dialog
			WebElement okBtn = driver.findElement(By.id("com.expandtesting.practice:id/btn_ok"));
			okBtn.click();

			// Log successful alert handling
			System.out.println("Alert handled successfully.");
		} catch (Exception e) {
			System.err.println("Exception occurred while handling alert: " + e.getMessage());
		}
	}

//	@Test(priority = 2)
//	public void Back() {
//		try {
//			// Try clicking the app's back button if it exists
//			WebElement backBtn = driver
//					.findElement(By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']"));
//			backBtn.click();
//			System.out.println("Navigated back using app back button.");
//		} catch (Exception e) {
//			System.out.println("Back button not found, pressing device BACK key instead.");
//			driver.pressKey(new KeyEvent(AndroidKey.BACK));
//		}
////		System.out.println("End Alert........");
//	}

}
