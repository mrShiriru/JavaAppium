package ru.javaAppium.pages.factories;


import org.openqa.selenium.remote.RemoteWebDriver;
import ru.javaAppium.pages.ArticlePage;
import ru.javaAppium.pages.android.AndroidArticlePage;
import ru.javaAppium.pages.ios.IOSArticlePage;
import ru.javaAppium.properties.Platform;

public class ArticlePageFactory {
    public static ArticlePage get(RemoteWebDriver driver){
        if (Platform.getInstance().isAndroid()){
            return new AndroidArticlePage(driver);
        }else {
            return new IOSArticlePage(driver);
        }
    }
}
