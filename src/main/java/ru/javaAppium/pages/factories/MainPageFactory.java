package ru.javaAppium.pages.factories;

import io.appium.java_client.AppiumDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import ru.javaAppium.pages.MainPage;
import ru.javaAppium.pages.android.AndroidMainPage;
import ru.javaAppium.pages.ios.IOSMainPage;
import ru.javaAppium.properties.Platform;

public class MainPageFactory {

    public static MainPage get(RemoteWebDriver driver){
        if (Platform.getInstance().isAndroid()){
            return new AndroidMainPage(driver);
        }else {
            return new IOSMainPage(driver);
        }
    }
}
