package ru.javaAppium.pages.factories;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import ru.javaAppium.pages.ArticlePage;
import ru.javaAppium.pages.android.AndroidArticlePage;
import ru.javaAppium.pages.ios.IOSArticlePage;
import ru.javaAppium.properties.Platform;

public class ArticlePageFactory {
    public static ArticlePage get(AppiumDriver<WebElement> driver){
        if (Platform.getInstance().isAndroid()){
            return new AndroidArticlePage(driver);
        }else {
            return new IOSArticlePage(driver);
        }
    }
}
