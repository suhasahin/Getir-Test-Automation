package tests;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.*;
import utils.DriverManager;
import java.net.MalformedURLException;

public class MobileWeb extends DriverManager {
    AppiumBy aboutBy = (AppiumBy) AppiumBy.className("user-text");

    @Parameters("platform")
    @BeforeClass(groups = {"hook"})
    void beforeClass(@Optional("platform") String platform) throws MalformedURLException {
        setDriver(platform);
    }

    @AfterClass(groups = {"hook"})
    void teardown() {
        driver.quit();
    }

    @Test(groups = {"safari", "chrome"})
    public void getirMobileWebTest() throws Exception {
        driver.get(baseURL);
        Thread.sleep(2000);
    }
}
