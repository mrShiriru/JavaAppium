package ru.javaAppium.pages.ios;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import ru.javaAppium.pages.GroupPage;

import java.util.List;

public class IOSGroupPage extends GroupPage {
    public IOSGroupPage(RemoteWebDriver driver) {
        super(driver);
    }

    static {
        ARTICLE_LIST_TITLE = By.xpath("//XCUIElementTypeCell");
        POPUP_INFO = By.id("org.wikipedia:id/snackbar_text");
    }

    @Override
    public WebElement getArticleFromList(int numberOfArticle) {
        List<WebElement> articles = getArticlesDescriptionList();
        return articles.get(numberOfArticle);
    }

    private List<WebElement> getArticlesDescriptionList() {
        By locator = By.xpath("//XCUIElementTypeStaticText[2]");

        return  waitElementsPresent(
                locator,
                "Cannot find articles in group list",
                5
        );
    }
}
