package testScripts;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import base_Backage.BaseClass;

/**
 * Test class for verifying the country list functionality.
 * Author: Abisha M
 * Date: 31-Oct-2025
 */
public class Countries_List_04 extends BaseClass {

    @Test(priority = 1, description = "Fetch all countries from the list and measure execution time.")
    public void getCountriesList() throws InterruptedException {

        // Record start time
        long startTime = System.currentTimeMillis();

//        setUpAppLaunch();

        // Click on "Countries" button
        WebElement clickCountryBtn = driver.findElement(By.id("com.expandtesting.practice:id/btn_countries"));
        click(clickCountryBtn);

        List<String> allCountries = new ArrayList<>();
        boolean continueScrolling = true;

        while (continueScrolling) {
            List<WebElement> visibleCountries = driver.findElements(By.id("com.expandtesting.practice:id/tv_country_name"));

            // Add new countries to the list
            for (WebElement country : visibleCountries) {
                String countryName = country.getText().trim();
                if (!allCountries.contains(countryName)) {
                    allCountries.add(countryName);
                }
            }

            int beforeScrollCount = allCountries.size();

            // Scroll down to load more items
            scrollDown();
            Thread.sleep(1000);

            List<WebElement> afterScrollCountries = driver.findElements(By.id("com.expandtesting.practice:id/tv_country_name"));

            for (WebElement country : afterScrollCountries) {
                String countryName = country.getText().trim();
                if (!allCountries.contains(countryName)) {
                    allCountries.add(countryName);
                }
            }

            int afterScrollCount = allCountries.size();

            // Stop scrolling when no new items are loaded
            if (beforeScrollCount == afterScrollCount) {
                continueScrolling = false;
            }
        }

        // Record end time
        long endTime = System.currentTimeMillis();

        // Calculate total execution time
        long executionTime = endTime - startTime;

        System.out.println("\n=========== All Countries Fetched ===========");
        System.out.println("Total Countries Found: " + allCountries.size());
        for (String name : allCountries) {
            System.out.println(name);
        }

        // Display total execution time
        System.out.println("\nTotal Execution Time: " + executionTime + " ms (" + (executionTime / 3000.0) + " seconds)");
    }
}
