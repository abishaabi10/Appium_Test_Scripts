package testScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import base_Backage.BaseClass;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

/**
 * Test class to verify Counter functionality in the Practice App.
 * Author: Abisha M
 * Date: 30-Oct-2025
 */
public class Counter_01 extends BaseClass {

    @Test(priority = 1, description = "Verify Counter button is clickable")
    public void verifyCounterButtonClickable() 
    {
// 	setUpAppLaunch();
//  	System.out.println("Counter Start..........");

        WebElement counterButton = driver.findElement(By.id("com.expandtesting.practice:id/btn_counter_demo"));

        Assert.assertTrue(counterButton.isEnabled(), "Counter button is not clickable!");
        System.out.println("Counter button is clickable.");
        click(counterButton);
    }

    @Test(priority = 2, description = "Verify counter value increases on '+' button click")
    public void verifyIncrementButton() {
        WebElement counterValue = driver.findElement(By.xpath("//android.widget.TextView[@content-desc='counter-value']"));
        int initialValue = Integer.parseInt(counterValue.getText());

        WebElement incrementButton = driver.findElement(By.id("com.expandtesting.practice:id/btn_increment"));
        incrementButton.click();

        WebElement updatedValueElement = driver.findElement(By.id("com.expandtesting.practice:id/tv_counter"));
        int updatedValue = Integer.parseInt(updatedValueElement.getText());

        Assert.assertTrue(updatedValue > initialValue, "Counter value did not increase.");
        System.out.println("Counter value increased successfully. Current count: " + updatedValue);
    }

    @Test(priority = 3, description = "Verify counter value decreases on '-' button click")
    public void verifyDecrementButton() {
        WebElement counterValue = driver.findElement(By.xpath("//android.widget.TextView[@content-desc='counter-value']"));
        int initialValue = Integer.parseInt(counterValue.getText());

        WebElement decrementButton = driver.findElement(By.id("com.expandtesting.practice:id/btn_decrement"));
        decrementButton.click();

        WebElement updatedValueElement = driver.findElement(By.id("com.expandtesting.practice:id/tv_counter"));
        int updatedValue = Integer.parseInt(updatedValueElement.getText());

        Assert.assertTrue(updatedValue < initialValue, "Counter value did not decrease.");
        System.out.println("Counter value decreased successfully. Current count: " + updatedValue);
    }

    @Test(priority = 4, description = "Verify counter value resets to zero on reset button click")
    public void verifyResetButton() {
        WebElement resetButton = driver.findElement(By.id("com.expandtesting.practice:id/btn_reset"));
        resetButton.click();

        WebElement counterValue = driver.findElement(By.id("com.expandtesting.practice:id/tv_counter"));
        int resetValue = Integer.parseInt(counterValue.getText());

        Assert.assertEquals(resetValue, 0, "Counter value did not reset to zero.");
        System.out.println("Counter reset successfully. Current count: " + resetValue);
    }
    @Test(priority = 5)
	public void Back() {
	    try {
	        // Try clicking the app's back button if it exists
	        WebElement backBtn = driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']"));
	        backBtn.click();
	        System.out.println("Navigated back using app back button.");
	    } catch (Exception e) {
//	        System.out.println("Back button not found, pressing device BACK key instead.");
	        driver.pressKey(new KeyEvent(AndroidKey.BACK));
	    }
//    System.out.println("COunter end..........");

}
}
