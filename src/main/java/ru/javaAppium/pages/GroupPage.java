package ru.javaAppium.pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.javaAppium.interfaces.Article;

import java.util.List;

public class GroupPage extends AnyPage implements Article {

    private static final By ARTICLE_LIST_TITLE = By.xpath(
            "//android.widget.TextView[@resource-id='org.wikipedia:id/page_list_item_title']"),
            POPUP_INFO = By.id("org.wikipedia:id/snackbar_text");

    public GroupPage(AppiumDriver driver) {
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

        waitElementsPresent(
                POPUP_INFO,
                "Popup with info not found",
                5
        );
    }

    public WebElement getArticleFromList(int numberOfArticle) {
        List<WebElement> articles = getArticlesList();
        return articles.get(numberOfArticle);
    }

    public String getTitle(WebElement article) {
        return article.getText();
    }
}
