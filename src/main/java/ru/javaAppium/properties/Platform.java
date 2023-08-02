package ru.javaAppium.properties;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

import static ru.javaAppium.properties.PlatformName.PLATFORM_ANDROID;
import static ru.javaAppium.properties.Property.getConfigPropertyVariable;

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

    public AppiumDriver<WebElement> getDriver() throws Exception {
        PlatformName platformName = getEnumPlatformName();

        switch (platformName) {
            case PLATFORM_ANDROID:
                return new AndroidDriver<>(new URL(getPlatformURL()+"/wd/hub"), getAndroidDesiredCapabilities());
            case PLATFORM_IOS:
                return new IOSDriver<>(new URL(getPlatformURL()), getIOSDesiredCapabilities());
            default:
                throw new Exception("unknown platform name " + platformName);
        }
    }

    private String getPlatformURL(){
        return getConfigPropertyVariable("platformURL");
    }

    private PlatformName getEnumPlatformName(){
        String platformValue = getConfigPropertyVariable("platformName");
        return PlatformName.findEnum(platformValue);
    }

    private DesiredCapabilities getAndroidDesiredCapabilities(){
        DesiredCapabilities androidCaps = new DesiredCapabilities();
        androidCaps.setCapability("deviceOrientation", "portrait");
        androidCaps.setCapability("platformName", "android");
        androidCaps.setCapability("deviceName", "and80");
        androidCaps.setCapability("platformVersion", "8.1.0");
        androidCaps.setCapability("automationName", "Appium");
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
        return iosCaps;
    }

}
