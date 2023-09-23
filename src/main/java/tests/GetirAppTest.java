package tests;

import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.*;
import utils.DriverManager;
import java.net.MalformedURLException;
import java.util.Arrays;
import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static java.time.Duration.ofMillis;


public class GetirAppTest extends DriverManager {

    By locationButtonBy = By.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button");
    By continueWithoutAccountBy = By.id("com.getir:id/onboarding_continueWithoutRegisterationTextView");
    By getirMainAddressButtonBy = By.id("com.getir:id/layoutaddress_destinationAddressTextView");
    By getirMainAddressAddNewBy = By.id("com.getir:id/itemAddAddress_addButton");
    By getirSearchAddressBy = By.id("com.getir:id/address_searchEditText");

    //----------------------- Add new Adress
    By getirStreetName = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[3]/androidx.appcompat.widget.LinearLayoutCompat/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.EditText");
    By getirStreetNoBy = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[3]/androidx.appcompat.widget.LinearLayoutCompat/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.EditText");
    By getirFloorNoBy = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[3]/androidx.appcompat.widget.LinearLayoutCompat/android.view.ViewGroup/android.widget.FrameLayout[3]/android.widget.EditText");
    By getirFlatNoBy = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[3]/androidx.appcompat.widget.LinearLayoutCompat/android.view.ViewGroup/android.widget.FrameLayout[4]/android.widget.EditText");
    By getirAddressTypeBy = By.id("com.getir:id/address_detailTypeSelectionOther");
    By getirAddressSubmitButtonBy = By.id("com.getir:id/address_detailSubmitButton");
    By getirBesiktasAddressBy = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.LinearLayout/android.widget.TextView");
    By getirSearchForBy = By.id("com.getir:id/getirhome_searchView");
    By getirSearchFor2By = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.EditText");
    By getirDialogYesButtonBy = By.id("com.getir:id/gaDialog_positiveButton");

    //----------------------- Add to Basket
    By getirAddtoBasketButtonBy = By.id("com.getir:id/foodproduct_addToBasketButtonFrameLayout");

    @Parameters("platform")
    @BeforeClass(groups = {"hook"})
    void beforeClass(@Optional("platform") String platform) throws MalformedURLException {
        setDriver(platform);
    }

    @AfterClass(groups = {"hook"})
    void teardown() {
        driver.quit();
    }

    @Test(groups = {"android"})
    public void mobileAppTest() throws Exception {

        TouchAction touchAction = new TouchAction((PerformsTouchActions) driver);

        wait.until(ExpectedConditions.visibilityOfElementLocated(locationButtonBy)).click();
        for (By by : Arrays.asList(continueWithoutAccountBy, getirMainAddressButtonBy, getirMainAddressAddNewBy)) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(by)).click();
        }

        //adres belirleme
        wait.until(ExpectedConditions.visibilityOfElementLocated(getirSearchAddressBy)).sendKeys("Besiktas");
        Thread.sleep(3000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(getirBesiktasAddressBy)).click();
        Thread.sleep(3000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Button[@text='Continue']"))).click();
        Thread.sleep(3000);
        wait.until(ExpectedConditions.elementToBeClickable(getirStreetName)).click();
        wait.until(ExpectedConditions.elementToBeClickable(getirStreetName)).sendKeys("Ulus, Kelaynak Sokak");
        wait.until(ExpectedConditions.elementToBeClickable(getirStreetNoBy)).sendKeys("16");
        wait.until(ExpectedConditions.elementToBeClickable(getirFloorNoBy)).sendKeys("0");
        wait.until(ExpectedConditions.elementToBeClickable(getirFlatNoBy)).sendKeys("0");
        touchAction.press(PointOption.point(515, 1270))
                .waitAction(waitOptions(ofMillis(1000)))
                .moveTo(PointOption.point(531, 282))
                .release()
                .perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(getirAddressTypeBy)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(getirAddressSubmitButtonBy)).click();
        //adres belirleme

        wait.until(ExpectedConditions.visibilityOfElementLocated(getirDialogYesButtonBy)).click();
        Thread.sleep(5000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(getirSearchForBy)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(getirSearchFor2By)).click();
        Thread.sleep(5000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(getirSearchFor2By)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(getirSearchFor2By)).sendKeys("Burger King");
        Thread.sleep(5000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.HorizontalScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[1]"))).click();

        Thread.sleep(5000);
        //swipe action
        touchAction.press(PointOption.point(515, 1270))
                .waitAction(waitOptions(ofMillis(1000)))
                .moveTo(PointOption.point(531, 282))
                .release()
                .perform();
        //swipe action
        Thread.sleep(5000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.LinearLayout[2]/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup/android.widget.LinearLayout/android.widget.TextView"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.widget.LinearLayout[2]/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.widget.LinearLayout"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(getirAddtoBasketButtonBy)).click();
        Thread.sleep(1500);
        wait.until(ExpectedConditions.visibilityOfElementLocated(getirAddtoBasketButtonBy)).click();
        Thread.sleep(1500);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.LinearLayout[2]/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.LinearLayout"))).click();
        Thread.sleep(1500);
        wait.until(ExpectedConditions.visibilityOfElementLocated(getirAddtoBasketButtonBy)).click();
        Thread.sleep(1500);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup/android.widget.LinearLayout[2]/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[8]/android.widget.LinearLayout"))).click();
        Thread.sleep(1500);
        wait.until(ExpectedConditions.visibilityOfElementLocated(getirAddtoBasketButtonBy)).click();
        Thread.sleep(1500);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.LinearLayout[2]/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.LinearLayout"))).click();
        Thread.sleep(1500);
        wait.until(ExpectedConditions.visibilityOfElementLocated(getirAddtoBasketButtonBy)).click();
        Thread.sleep(1500);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.LinearLayout[2]/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.widget.LinearLayout"))).click();
        Thread.sleep(1500);
        wait.until(ExpectedConditions.visibilityOfElementLocated(getirAddtoBasketButtonBy)).click();
        Thread.sleep(1500);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup/android.widget.LinearLayout[2]/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.LinearLayout"))).click();
        Thread.sleep(1500);
        wait.until(ExpectedConditions.visibilityOfElementLocated(getirAddtoBasketButtonBy)).click();
        Thread.sleep(1500);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup/android.widget.LinearLayout[2]/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[4]/android.widget.LinearLayout"))).click();
        Thread.sleep(1500);
        wait.until(ExpectedConditions.visibilityOfElementLocated(getirAddtoBasketButtonBy)).click();
        Thread.sleep(5000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.FrameLayout[@content-desc=\"Add to Basket\"]"))).click();
        Thread.sleep(5000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup"))).click();
        Thread.sleep(6000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.Button"))).click();
        Thread.sleep(5000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.FrameLayout/android.widget.EditText"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.FrameLayout/android.widget.EditText"))).sendKeys("5550000001");
        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.Button"))).click();
        Thread.sleep(15000);
    }
}
