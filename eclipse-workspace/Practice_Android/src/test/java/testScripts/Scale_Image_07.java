package testScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import base_Backage.BaseClass;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class Scale_Image_07 extends BaseClass {
	@Test(priority = 1)
	public void Image_Deduction() {
//		setUpAppLaunch();
		System.out.println("Scale Start");
		WebElement Btn_Clickable = driver.findElement(By.id("com.expandtesting.practice:id/btn_scale_image"));
		click(Btn_Clickable);
		WebElement ele = driver.findElement(By.xpath("//android.widget.TextView[@text=\"ScaleImageActivity\"]"));

		String GetHeader = ele.getText();
		if (GetHeader.equals("ScaleImageActivity")) {
			System.out.println("The Header Value is" + GetHeader);
		} else {
			System.out.println("The Header value is not Capture");

		}

	}

	@Test(priority = 2)
	public void CaptureImage() {

		WebElement img = driver.findElement(By.id("com.expandtesting.practice:id/image"));

		String elementType = img.getAttribute("class");

		System.out.println("Captured Class Attribute: " + elementType);

		if (elementType.contains("ImageView")) {
			System.out.println("The element is an IMAGE");
		} else {
			System.out.println("The element is NOT an image");
		}
	}

	@Test(priority = 8)
	public void Back() {
		try {

			WebElement backBtn = driver
					.findElement(By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']"));
			backBtn.click();
			System.out.println("Navigated back using app back button.");
		} catch (Exception e) {
//			System.out.println("Back button not found, pressing device BACK key instead.");
			driver.pressKey(new KeyEvent(AndroidKey.BACK));
		}
		System.out.println("Scale End");
	}

}
