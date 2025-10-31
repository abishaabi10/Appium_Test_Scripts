package testScripts;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;
import base_Backage.BaseClass;

public class TestSuiteSetup extends BaseClass {

    @BeforeSuite
    public void startApp() {
        setUpAppLaunch();
    }

    @AfterSuite
    public void closeApp() {
        tearDown();
    }
}
