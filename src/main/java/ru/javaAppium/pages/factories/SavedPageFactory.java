package ru.javaAppium.pages.factories;

import org.openqa.selenium.remote.RemoteWebDriver;
import ru.javaAppium.pages.SavedPage;
import ru.javaAppium.pages.android.AndroidSavedPage;
import ru.javaAppium.pages.ios.IOSSavedPage;
import ru.javaAppium.pages.mobileWeb.MWSavedPage;
import ru.javaAppium.properties.Platform;
import ru.javaAppium.properties.PlatformName;

public class SavedPageFactory {

    public static SavedPage get(RemoteWebDriver driver){

        PlatformName platformName = Platform.getInstance().getEnumPlatformName();
        switch (platformName) {
            case PLATFORM_ANDROID:
                return new AndroidSavedPage(driver);
            case PLATFORM_IOS:
                return new IOSSavedPage(driver);
            case PLATFORM_MOBILE_WEB:
                return new MWSavedPage(driver);
            default:
                throw new IllegalArgumentException("Failed to select specific SavedPage for" + platformName);
        }
    }
}
