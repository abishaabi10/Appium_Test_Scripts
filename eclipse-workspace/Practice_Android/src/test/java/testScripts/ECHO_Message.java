package testScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import base_Backage.BaseClass;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class ECHO_Message extends BaseClass {

	@Test(priority = 1)
	public void echo_Message_btn() {
//	setUpAppLaunch();
		System.out.println("Start echo");
		WebElement Click_echo_Message_btn = driver.findElement(By.id("com.expandtesting.practice:id/btn_echo_screen"));
		if (Click_echo_Message_btn.isEnabled()) {
			System.out.println("The EchoMessage button is clickable");
			click(Click_echo_Message_btn);
		} else {
			System.out.println("The EchoMessage button is not clickable");
		}

		WebElement Header = driver.findElement(By.xpath("//android.widget.TextView[@text=\"EchoActivity\"]"));
		String headerValidation = Header.getText();
		if (headerValidation.equals("EchoActivity")) {
			System.out.println("The Header Value is " + headerValidation);
		} else {
			System.out.println("Header value does not match. Found: " + headerValidation);
		}
	}

	@Test(priority = 2)
	public void TestBoxValidation() {
		WebElement TestBox = driver.findElement(By.id("com.expandtesting.practice:id/et_user_name"));
		click(TestBox);
		sendKeys(TestBox, "Abisha");
		WebElement Clk_ok_btn = driver.findElement(By.id("com.expandtesting.practice:id/btn_echo"));
		click(Clk_ok_btn);
		
		WebElement GetWelcomText = driver.findElement(By.id("com.expandtesting.practice:id/tv_echo_message"));
		String getTest= GetWelcomText.getText();
		System.out.println("The Test Value is " + getTest);

		
	}
	@Test(priority = 3)
	public void Back() {
	    try {
	        // Try clicking the app's back button if it exists
	        WebElement backBtn = driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']"));
	        backBtn.click();
	        System.out.println("Navigated back using app back button.");
	    } catch (Exception e) {
	        driver.pressKey(new KeyEvent(AndroidKey.BACK));
	    }
	    System.out.println("End echo");
	}
	

}
