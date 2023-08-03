package ru.javaAppium.pages.factories;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import ru.javaAppium.pages.GroupPage;
import ru.javaAppium.pages.android.AndroidGroupPage;
import ru.javaAppium.pages.ios.IOSGroupPage;
import ru.javaAppium.properties.Platform;

public class GroupPageFactory {

    public static GroupPage get(AppiumDriver<WebElement> driver){
        if (Platform.getInstance().isAndroid()){
            return new AndroidGroupPage(driver);
        }else {
            return new IOSGroupPage(driver);
        }
    }
}
