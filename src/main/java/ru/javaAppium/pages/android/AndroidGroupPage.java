package ru.javaAppium.pages.android;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import ru.javaAppium.pages.GroupPage;

import java.util.List;

public class AndroidGroupPage extends GroupPage {
    public AndroidGroupPage(RemoteWebDriver driver) {
        super(driver);
    }

    static {
        ARTICLE_LIST_TITLE = By.xpath(
                "//android.widget.TextView[@resource-id='org.wikipedia:id/page_list_item_title']");
                POPUP_INFO = By.id("org.wikipedia:id/snackbar_text");
    }

    @Override
    public WebElement getArticleFromList(int numberOfArticle) {
        List<WebElement> articles = getArticlesList();
        return articles.get(numberOfArticle);
    }
}
