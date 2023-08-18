package ru.javaAppium.properties;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import static ru.javaAppium.properties.PlatformName.*;
import static ru.javaAppium.properties.Property.getCustomProperty;

public class Platform {

    private Platform(){}

    private static Platform instance;

    public static Platform getInstance(){
        if(instance == null){
            instance = new Platform();
        }
        return instance;
    }

    public boolean isAndroid(){
        return PLATFORM_ANDROID.equals(getEnumPlatformName());
    }

    public boolean isIOS(){
        return PLATFORM_IOS.equals(getEnumPlatformName());
    }

    public boolean isMW(){
        return PLATFORM_MOBILE_WEB.equals(getEnumPlatformName());
    }

    public RemoteWebDriver getDriver() throws Exception {
        PlatformName platformName = getEnumPlatformName();

        switch (platformName) {
            case PLATFORM_ANDROID:
                return new AndroidDriver<>(new URL(getPlatformURL()), getAndroidDesiredCapabilities());
            case PLATFORM_IOS:
                return new IOSDriver<>(new URL(getPlatformURL()), getIOSDesiredCapabilities());
            case PLATFORM_MOBILE_WEB:
                System.setProperty("webdriver.chrome.driver", getCustomProperty("chromeDriverPath"));
                return new ChromeDriver(getMWChromeOptions());
            default:
                throw new Exception("unknown platform name " + platformName);
        }
    }

    private String getPlatformURL(){
        return getCustomProperty("platformURL");
    }

    public PlatformName getEnumPlatformName(){
        String platformValue = getCustomProperty("platformName");
        return PlatformName.findEnum(platformValue);
    }

    private ChromeOptions getMWChromeOptions(){
        Map<String, Object> deviceMetrics = new HashMap<>();
        deviceMetrics.put("width", 360);
        deviceMetrics.put("height", 640);
        deviceMetrics.put("pixelRatio", 3.0);

        Map<String, Object> mobileEmulation = new HashMap<>();
        mobileEmulation.put("deviceMetrics", deviceMetrics);
        mobileEmulation.put("userAgent", "Mozilla/5.0 (Linux; Android 4.2.1; en-us; Nexus 5 Build/JOP40D) AppleWebKit/535.19 (KHTML, like Gecko) Chrome/18.0.1025.166 Mobile Safari/535.19");

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
        chromeOptions.addArguments("window-size=360,840");

        return chromeOptions;
    }

    private DesiredCapabilities getAndroidDesiredCapabilities(){
        DesiredCapabilities androidCaps = new DesiredCapabilities();
        //androidCaps.setCapability("deviceOrientation", "portrait");
        androidCaps.setCapability("platformName", "android");
        androidCaps.setCapability("deviceName", "and80");
        androidCaps.setCapability("avd", "and80");
        androidCaps.setCapability("platformVersion", "8.1.0");
        androidCaps.setCapability("automationName", "UiAutomator2");
        androidCaps.setCapability("appPackage", "org.wikipedia");
        androidCaps.setCapability("appActivity", ".main.MainActivity");
        androidCaps.setCapability("app", "/Users/user/Desktop/javaAppium/JavaAppium/src/main/resources/apks/org.wikipedia.apk");
        return androidCaps;
    }

    private DesiredCapabilities getIOSDesiredCapabilities(){
        DesiredCapabilities iosCaps = new DesiredCapabilities();
        iosCaps.setCapability("platformName", "iOS");
        iosCaps.setCapability("deviceName", "My iPhone SE");
        iosCaps.setCapability("platformVersion", "14.3");
        iosCaps.setCapability("automationName", "XCUITest");
        iosCaps.setCapability("app", "/Users/user/Desktop/javaAppium/JavaAppium/src/main/resources/apks/Wikipedia.app");
        iosCaps.setCapability("newCommandTimeout", "15");
        iosCaps.setCapability("launchTimeout", "20000");
        return iosCaps;
    }

}
