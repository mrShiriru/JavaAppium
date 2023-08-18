package ru.javaAppium.pages.factories;

import org.openqa.selenium.remote.RemoteWebDriver;
import ru.javaAppium.pages.SearchPage;
import ru.javaAppium.pages.android.AndroidSearchPage;
import ru.javaAppium.pages.ios.IOSSearchPage;
import ru.javaAppium.pages.mobileWeb.MWSearchPage;
import ru.javaAppium.properties.Platform;
import ru.javaAppium.properties.PlatformName;

public class SearchPageFactory {
    public static SearchPage get(RemoteWebDriver driver){

        PlatformName platformName = Platform.getInstance().getEnumPlatformName();
        switch (platformName) {
            case PLATFORM_ANDROID:
                return new AndroidSearchPage(driver);
            case PLATFORM_IOS:
                return new IOSSearchPage(driver);
            case PLATFORM_MOBILE_WEB:
                return new MWSearchPage(driver);
            default:
                throw new IllegalArgumentException("Failed to select specific SearchPage for" + platformName);
        }
    }
}
