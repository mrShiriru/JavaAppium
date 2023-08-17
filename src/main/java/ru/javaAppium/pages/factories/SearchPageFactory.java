package ru.javaAppium.pages.factories;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import ru.javaAppium.pages.SearchPage;
import ru.javaAppium.pages.android.AndroidSearchPage;
import ru.javaAppium.pages.ios.IOSSearchPage;
import ru.javaAppium.properties.Platform;

public class SearchPageFactory {
    public static SearchPage get(RemoteWebDriver driver){
        if (Platform.getInstance().isAndroid()){
            return new AndroidSearchPage(driver);
        }else {
            return new IOSSearchPage(driver);
        }
    }
}
