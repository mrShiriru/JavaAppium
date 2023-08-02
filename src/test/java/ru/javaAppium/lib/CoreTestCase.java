package ru.javaAppium.lib;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import ru.javaAppium.pages.*;

import java.net.URL;

import static ru.javaAppium.properties.Property.getConfigPropertyVariable;


public class CoreTestCase {

    protected AppiumDriver<WebElement> driver;

    public static final long
            DEFAULT_WAIT_TIME = 15,
            SHORT_WAIT_TIME = 5;
    public static final String ERROR_MESSAGE = "Element not found";

    public MainPage mainPage;
    public SearchPage searchPage;
    public ArticlePage articlePage;
    public SavedPage savedPage;
    public GroupPage groupPage;


    @BeforeEach
    public void setUp() throws Exception
    {
        driver = getDriverByEnv();
        loadingPages();
        mainPage.skipOnboarding();
    }

    private AppiumDriver<WebElement> getDriverByEnv() throws Exception {
        String platformValue = getConfigPropertyVariable("platformName");
        String url = getConfigPropertyVariable("platformURL");
        PlatformName platformName = PlatformName.findEnum(platformValue);

        switch (platformName) {
            case ANDROID_PLATFORM_NAME:
                DesiredCapabilities androidCaps = new DesiredCapabilities();
                androidCaps.setCapability("deviceOrientation", "portrait");
                androidCaps.setCapability("platformName", "android");
                androidCaps.setCapability("deviceName", "and80");
                androidCaps.setCapability("platformVersion", "8.1.0");
                androidCaps.setCapability("automationName", "Appium");
                androidCaps.setCapability("appPackage", "org.wikipedia");
                androidCaps.setCapability("appActivity", ".main.MainActivity");
                androidCaps.setCapability("app", "/Users/user/Desktop/javaAppium/JavaAppium/src/main/resources/apks/org.wikipedia.apk");
                return new AndroidDriver<>(new URL(url+"/wd/hub"), androidCaps);
            case IOS_PLATFORM_NAME:
                DesiredCapabilities iosCaps = new DesiredCapabilities();
                iosCaps.setCapability("platformName", "iOS");
                iosCaps.setCapability("deviceName", "My iPhone SE");
                iosCaps.setCapability("platformVersion", "14.3");
                iosCaps.setCapability("automationName", "XCUITest");
                iosCaps.setCapability("app", "/Users/user/Desktop/javaAppium/JavaAppium/src/main/resources/apks/Wikipedia.app");
                return new IOSDriver<>(new URL(url), iosCaps);
            default:
                throw new Exception("unknown platform name " + platformName);
        }
    }

    private void loadingPages(){
        searchPage = new SearchPage(driver);
        articlePage = new ArticlePage(driver);
        savedPage = new SavedPage(driver);
        groupPage = new GroupPage(driver);
        mainPage = new MainPage(driver);
    }

    @AfterEach
    public void tearDown(){
        driver.quit();
    }

}
