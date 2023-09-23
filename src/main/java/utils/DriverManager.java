package utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class DriverManager<XpathAssert> {
    public AppiumDriver driver;
    public WebDriverWait wait;
    public JavascriptExecutor js;
    public String baseURL;

    public void setDriver(String testPlatform) throws MalformedURLException {
        switch (testPlatform) {
            case "ios": {
                // TO DO
                System.out.println("***** iOS App *****");
                break;
            }
            case "chrome": {
                // TO DO
                DesiredCapabilities chromeCaps = new DesiredCapabilities();

                chromeCaps.setCapability("appium:deviceName", "Pixel_4_API_30");
                chromeCaps.setCapability("appium:automationName", "UIAutomator2");
                chromeCaps.setCapability("appium:udid", "emulator-5556"); //DeviceId from "adb devices" command
                chromeCaps.setCapability("appium:platformName", "Android");
                chromeCaps.setCapability("appium:platformVersion", "11.0"); //Android Version
                chromeCaps.setCapability("appium:skipUnlock", "true");
                chromeCaps.setCapability("appium:fullReset", "false");
                chromeCaps.setCapability("appium:noReset", "false");
                chromeCaps.setCapability("unicodeKeyboard", false);
                chromeCaps.setCapability("resetKeyboard", false);
                //chromeCaps.setCapability("appActivity", "com.getir.core.feature.splash.SplashActivity");
                chromeCaps.setCapability("appPackage", "com.android.chrome");


                System.out.println("***** Android Mobile Web - Chrome *****");
                break;
            }
            case "safari": {
                DesiredCapabilities iOSSafariCaps = new DesiredCapabilities();
                iOSSafariCaps.setCapability("appium:platformName", "iOS");
                iOSSafariCaps.setCapability("appium:browserName", "Safari");
                iOSSafariCaps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12.4");
                iOSSafariCaps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
                iOSSafariCaps.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone X");

                driver = new AppiumDriver(new URL("http://127.0.0.0:4723"), iOSSafariCaps);
                System.out.println("***** iOS Mobile Web - Safari *****");
                break;
            }
            default: {
                DesiredCapabilities androidCaps = new DesiredCapabilities();
                androidCaps.setCapability("appium:deviceName", "Pixel_4_API_30");
                androidCaps.setCapability("appium:automationName", "UIAutomator2");
                androidCaps.setCapability("appium:udid", "emulator-5556"); //DeviceId from "adb devices" command
                androidCaps.setCapability("appium:platformName", "Android");
                androidCaps.setCapability("appium:platformVersion", "11.0");
                androidCaps.setCapability("appium:skipUnlock", "true");
                androidCaps.setCapability("appium:fullReset", "false");
                androidCaps.setCapability("appium:noReset", "false");
                androidCaps.setCapability("unicodeKeyboard", false);
                androidCaps.setCapability("resetKeyboard", false);
                androidCaps.setCapability("appActivity", "com.getir.core.feature.splash.SplashActivity");
                androidCaps.setCapability("appPackage", "com.getir");

                //you can use this command if you have apk of the application. just change */APPLICATION.apk to your file name.

                /*androidCaps.setCapability("appium:app", System.getProperty("user.dir") + "/src/main/resources/files/APPLICATION.apk");*/

                driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), androidCaps);
                System.out.println("***** Android App *****");
                break;
            }

        }
        js = (JavascriptExecutor) driver;
        baseURL = "https://www.getir.com/";
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
        //wait = new WebDriverWait(driver, 20);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }


}