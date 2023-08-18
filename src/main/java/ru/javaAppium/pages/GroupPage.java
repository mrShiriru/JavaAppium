package ru.javaAppium.pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import ru.javaAppium.interfaces.Article;

import java.util.List;

public abstract class GroupPage extends AnyPage implements Article {

    protected static By
            ARTICLE_LIST_TITLE,
            POPUP_INFO;

    public GroupPage(RemoteWebDriver driver) {
        super(driver);
    }

    public List<WebElement> getArticlesList() {
        return  waitElementsPresent(
                ARTICLE_LIST_TITLE,
                "Cannot find articles in group list",
                5
        );
    }

    public void deleteArticle(int ArticleNumber) {
        List<WebElement> articleList = getArticlesList();

        swipeElementToLeft(articleList.get(ArticleNumber));

//        waitElementsPresent(
//                POPUP_INFO,
//                "Popup with info not found",
//                5
//        );
    }

    @Override
    public String getTitle(WebElement article) {
        return article.getText();
    }

    @Override
    public String getDescription(WebElement article) {
        return article.getText();
    }
}
