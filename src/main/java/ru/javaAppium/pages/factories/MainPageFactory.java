package ru.javaAppium.pages.factories;


import org.openqa.selenium.remote.RemoteWebDriver;
import ru.javaAppium.pages.MainPage;
import ru.javaAppium.pages.android.AndroidMainPage;
import ru.javaAppium.pages.ios.IOSMainPage;
import ru.javaAppium.pages.mobileWeb.MWMainPage;
import ru.javaAppium.properties.Platform;
import ru.javaAppium.properties.PlatformName;

public class MainPageFactory {

    public static MainPage get(RemoteWebDriver driver){

        PlatformName platformName = Platform.getInstance().getEnumPlatformName();
        switch (platformName) {
            case PLATFORM_ANDROID:
                return new AndroidMainPage(driver);
            case PLATFORM_IOS:
                return new IOSMainPage(driver);
            case PLATFORM_MOBILE_WEB:
                return new MWMainPage(driver);
            default:
                throw new IllegalArgumentException("Failed to select specific MainPage for" + platformName);
        }
    }
}
