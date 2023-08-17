package ru.javaAppium.pages.factories;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.remote.RemoteWebDriver;
import ru.javaAppium.pages.SavedPage;
import ru.javaAppium.pages.android.AndroidSavedPage;
import ru.javaAppium.pages.ios.IOSSavedPage;
import ru.javaAppium.properties.Platform;

public class SavedPageFactory {

    public static SavedPage get(RemoteWebDriver driver){
        if (Platform.getInstance().isAndroid()){
            return new AndroidSavedPage(driver);
        }else {
            return new IOSSavedPage(driver);
        }
    }
}
