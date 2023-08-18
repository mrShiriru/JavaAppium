package ru.javaAppium.pages.factories;

import org.openqa.selenium.remote.RemoteWebDriver;
import ru.javaAppium.pages.ArticlePage;
import ru.javaAppium.pages.android.AndroidArticlePage;
import ru.javaAppium.pages.ios.IOSArticlePage;
import ru.javaAppium.pages.mobileWeb.MWArticlePage;
import ru.javaAppium.properties.Platform;
import ru.javaAppium.properties.PlatformName;


public class ArticlePageFactory {
    public static ArticlePage get(RemoteWebDriver driver){
        PlatformName platformName = Platform.getInstance().getEnumPlatformName();
        switch (platformName) {
            case PLATFORM_ANDROID:
                return new AndroidArticlePage(driver);
            case PLATFORM_IOS:
                return new IOSArticlePage(driver);
            case PLATFORM_MOBILE_WEB:
                return new MWArticlePage(driver);
            default:
                throw new IllegalArgumentException("Failed to select specific ArticlePage for" + platformName);
        }
    }
}
