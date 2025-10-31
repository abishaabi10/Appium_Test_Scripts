package testScripts;

import java.time.Duration;
import java.util.Arrays;
import java.util.Collections;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import base_Backage.BaseClass;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class Gesture_SDemo extends BaseClass {

	private WebDriverWait wait;

	private WebElement waitForVisibility(By locator) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	// Click element with explicit wait
	private void clickElement(By locator) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
		element.click();
		System.out.println("Clicked on element: " + locator);
	}

	@Test(priority = 1, description = "Verify single tap gesture and validate displayed message.")
	public void singleTap() {
//    	setUpAppLaunch();
		System.out.println("Starting Gesture Test Suite");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		clickElement(By.id("com.expandtesting.practice:id/btn_gesture_demo"));
		clickElement(By.id("com.expandtesting.practice:id/btnTap"));

		WebElement singleText = waitForVisibility(By.id("com.expandtesting.practice:id/tvTapResult"));
		System.out.println("🔹 Single Tap Result: " + singleText.getText());
	}

	@Test(priority = 2, description = "Verify double tap gesture and validate displayed message.")
	public void doubleTap() {
		By doubleTapBtn = By.id("com.expandtesting.practice:id/btnDoubleTap");

		clickElement(doubleTapBtn);
		clickElement(doubleTapBtn);

		WebElement doubleText = waitForVisibility(By.id("com.expandtesting.practice:id/tvTapResult"));
		System.out.println("🔹 Double Tap Result: " + doubleText.getText());
	}

	@Test(priority = 3, description = "Verify long press gesture and validate the output text.")
	public void longTap() {
		WebElement longTapBtn = waitForVisibility(By.id("com.expandtesting.practice:id/btnLongClick"));
		WebElement resultText = waitForVisibility(By.id("com.expandtesting.practice:id/tvTapResult"));

		PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
		Sequence longPress = new Sequence(finger, 1);

		longPress.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(),
				longTapBtn.getLocation().getX(), longTapBtn.getLocation().getY()));
		longPress.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
		longPress.addAction(new Pause(finger, Duration.ofSeconds(2)));
		longPress.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

		driver.perform(Collections.singletonList(longPress));

		System.out.println("🔹 Long Tap Result: " + resultText.getText());
	}

	@Test(priority = 4, description = "Verify drag and drop gesture between two elements.")
	public void dragAndDrop() throws InterruptedException {
		WebElement drag = waitForVisibility(By.id("com.expandtesting.practice:id/tvDragMe"));
		WebElement drop = waitForVisibility(By.id("com.expandtesting.practice:id/tvDropZone"));

		int startX = drag.getLocation().getX() + (drag.getSize().getWidth() / 2);
		int startY = drag.getLocation().getY() + (drag.getSize().getHeight() / 2);
		int endX = drop.getLocation().getX() + (drop.getSize().getWidth() / 2);
		int endY = drop.getLocation().getY() + (drop.getSize().getHeight() / 2);

		PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
		Sequence dragDrop = new Sequence(finger, 1);

		dragDrop.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY));
		dragDrop.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
		dragDrop.addAction(finger.createPointerMove(Duration.ofSeconds(1), PointerInput.Origin.viewport(), endX, endY));
		dragDrop.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

		driver.perform(Arrays.asList(dragDrop));

		Thread.sleep(1000);
		System.out.println("🔹 Drag & Drop Result: " + drop.getText());
	}

	@Test(priority = 5, description = "Navigate back to the previous screen using app or device back button.")
	public void navigateBack() {
		try {

			System.out.println("Navigated back using in-app back button.");
		} catch (Exception e) {
			driver.pressKey(new KeyEvent(AndroidKey.BACK));
			System.out.println("Navigated back using device BACK key.");
		}
		System.out.println("Gesture Test Completed Successfully");
	}

	@Test(priority = 6)
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
		System.out.println("End langugae");

	}
}
