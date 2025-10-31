package testScripts;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import base_Backage.BaseClass;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

@Test(priority = 1, description = "Validate the header text in Language screen")
public class Language_03 extends BaseClass {

    public void RadioBtn() {
//        setUpAppLaunch();
    	System.out.println("Start Language");
        WebElement Language_btn = driver.findElement(By.id("com.expandtesting.practice:id/btn_languages_screen"));
        click(Language_btn);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement HeaderValidtion = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//android.widget.TextView[contains(@text,'Select your Subject')]")));

        String HeaderValue = HeaderValidtion.getText();
        System.out.println("Header text fetched: " + HeaderValue);

        Assert.assertEquals(HeaderValue, "Select your Subject ?", "Header text mismatch!");
        System.out.println("Header text validated successfully.");
    }



	// Test Count of the language
	@Test(priority = 2)
	public void Language_Count() {
		List<WebElement> radioButtons = driver.findElements(By.className("android.widget.RadioButton"));

		int count = radioButtons.size();
		System.out.println("Total Radio Buttons: " + count);

		for (WebElement rb : radioButtons) {
			System.out.println("Option: " + rb.getText());
		}
	}
	// Choose without value and click "Submit" button.

	@Test(priority = 3)
	public void Withoutsel_language() {
		WebElement submitBtn = driver.findElement(By.id("com.expandtesting.practice:id/btn_submit"));

		if (submitBtn.isEnabled()) {
			System.out.println("The 'Submit' button is clickable.");
			submitBtn.click();

			WebElement msg = driver.findElement(By.id("com.expandtesting.practice:id/tv_result"));
			String actualText = msg.getText();
			String expectedText = "No answer has been selected";

			if (actualText.equals(expectedText)) {
				System.out.println(actualText + " text is displayed");
			} else {
				System.out.println("Incorrect text is displayed: " + actualText);
			}

		} 
		else {
			System.out.println("The 'Submit' button is not clickable.");
		}
	}

	@Test(priority = 4)
	public void choose_Lag_Java() {

		WebElement javaRadio = driver.findElement(By.id("com.expandtesting.practice:id/rb_language_1"));
		click(javaRadio);

		WebElement submitBtn = driver.findElement(By.id("com.expandtesting.practice:id/btn_submit"));
		click(submitBtn);

		WebElement result = driver.findElement(By.id("com.expandtesting.practice:id/tv_result"));
		String actualText = result.getText();
		String expectedText = "Java";

		if (actualText.equals(expectedText)) {
			System.out.println("PASS: The user selected 'Java'. Result: " + actualText);
		} else {
			System.out.println("FAIL: Wrong selection. Displayed: " + actualText);
		}
	}
	
	@Test(priority = 5)
	public void choose_Lag_C_CPlus() {

		WebElement javaRadio = driver.findElement(By.id("com.expandtesting.practice:id/rb_language_2"));
		click(javaRadio);

		WebElement submitBtn = driver.findElement(By.id("com.expandtesting.practice:id/btn_submit"));
		click(submitBtn);

		WebElement result = driver.findElement(By.id("com.expandtesting.practice:id/tv_result"));
		String actualText = result.getText();
		String expectedText = "C/C++";

		if (actualText.equals(expectedText)) {
			System.out.println("PASS: The user selected 'Java'. Result: " + actualText);
		} else {
			System.out.println("FAIL: Wrong selection. Displayed: " + actualText);
		}
	}

	
	@Test(priority = 6)
	public void choose_Lag_CSharp() {

		WebElement javaRadio = driver.findElement(By.id("com.expandtesting.practice:id/rb_language_3"));
		click(javaRadio);

		WebElement submitBtn = driver.findElement(By.id("com.expandtesting.practice:id/btn_submit"));
		click(submitBtn);

		WebElement result = driver.findElement(By.id("com.expandtesting.practice:id/tv_result"));
		String actualText = result.getText();
		String expectedText = "C#";

		if (actualText.equals(expectedText)) {
			System.out.println("PASS: The user selected 'Java'. Result: " + actualText);
		} else {
			System.out.println("FAIL: Wrong selection. Displayed: " + actualText);
		}
	}
	
	@Test(priority = 7)
	public void choose_Lag_C_JavaScript() {

		WebElement javaRadio = driver.findElement(By.id("com.expandtesting.practice:id/rb_language_4"));
		click(javaRadio);

		WebElement submitBtn = driver.findElement(By.id("com.expandtesting.practice:id/btn_submit"));
		click(submitBtn);

		WebElement result = driver.findElement(By.id("com.expandtesting.practice:id/tv_result"));
		String actualText = result.getText();
		String expectedText = "JavaScript";

		if (actualText.equals(expectedText)) {
			System.out.println("PASS: The user selected 'Java'. Result: " + actualText);
		} else {
			System.out.println("FAIL: Wrong selection. Displayed: " + actualText);
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
		System.out.println("End langugae");

	}
	
	
}

