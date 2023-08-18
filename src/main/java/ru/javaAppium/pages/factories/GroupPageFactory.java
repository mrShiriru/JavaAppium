package ru.javaAppium.pages.factories;

import org.openqa.selenium.remote.RemoteWebDriver;
import ru.javaAppium.pages.GroupPage;
import ru.javaAppium.pages.android.AndroidGroupPage;
import ru.javaAppium.pages.ios.IOSGroupPage;
import ru.javaAppium.pages.mobileWeb.MWGroupPage;
import ru.javaAppium.properties.Platform;
import ru.javaAppium.properties.PlatformName;

public class GroupPageFactory {

    public static GroupPage get(RemoteWebDriver driver){
        PlatformName platformName = Platform.getInstance().getEnumPlatformName();
        switch (platformName) {
            case PLATFORM_ANDROID:
                return new AndroidGroupPage(driver);
            case PLATFORM_IOS:
                return new IOSGroupPage(driver);
            case PLATFORM_MOBILE_WEB:
                return new MWGroupPage(driver);
            default:
                throw new IllegalArgumentException("Failed to select specific GroupPage for" + platformName);
        }
    }
}
