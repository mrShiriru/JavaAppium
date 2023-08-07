package ru.javaAppium.interfaces;

import org.openqa.selenium.WebElement;

public interface Article {

    default String saveTitleAndOpenArticle(int numberOfArticle) {
        WebElement article = getArticleFromList(numberOfArticle);
        String expectedTitle = getTitle(article);
        article.click();
        return expectedTitle;
    }

    default String saveDescriptionAndOpenArticle(int numberOfArticle) {
        WebElement article = getArticleFromList(numberOfArticle);
        String expectedDescription = getDescription(article);
        article.click();
        return expectedDescription;
    }

    WebElement getArticleFromList(int numberOfArticle);

    String getTitle(WebElement article);

    String getDescription(WebElement article);


}
