package ru.javaAppium.commonTests;

import ru.javaAppium.lib.CoreTestCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import ru.javaAppium.properties.Platform;

import java.util.List;

import static ru.javaAppium.pages.AnyPage.FIRST_ARTICLE;
import static ru.javaAppium.pages.AnyPage.SECOND_ARTICLE;

public class Ex5Test extends CoreTestCase {

    /**
     * Написать тест, который:
     *
     * 1. Сохраняет две статьи в одну папку
     * 2. Удаляет одну из статей
     * 3. Убеждается, что вторая осталась
     * 4. Переходит в неё и убеждается, что title совпадает
     */
    @Test
    public void testEx5_testCreateTwoArticle() {
        String searchValue = "Appium";

        searchPage.clickSearchInput();
        searchPage.typeIntoSearchInput(searchValue);
        saveCurrentArticle(FIRST_ARTICLE);
        saveCurrentArticle(SECOND_ARTICLE);
        searchPage.returnOnTheMainPage();
        mainPage.get().getBottomPanel().clickSavedButton();
        savedPage.clickSavedGroup();

        List<WebElement> items = groupPage.getArticlesList();
        groupPage.deleteArticle(FIRST_ARTICLE);
        List<WebElement> items2 =  groupPage.getArticlesList();
        Assertions.assertTrue(items.size() > items2.size(), "The first article hasn't been removed");

        if(Platform.getInstance().isAndroid()){
            verifyTitleOfArticle();
        } else {
            verifyDescriptionOfArticle();
        }
    }

    private void verifyDescriptionOfArticle() {
        String expectedDescription = groupPage.saveDescriptionAndOpenArticle(FIRST_ARTICLE);
        String actualDescription = articlePage.getDescription();
        Assertions.assertEquals(expectedDescription,actualDescription,ERROR_MESSAGE);
    }

    private void verifyTitleOfArticle() {
        String expectedTitle = groupPage.saveTitleAndOpenArticle(FIRST_ARTICLE);
        String actualTitle = articlePage.getTitle();
        Assertions.assertEquals(expectedTitle,actualTitle, ERROR_MESSAGE);
    }

    private void saveCurrentArticle(int articleNumber){
        String title = searchPage.saveTitleAndOpenArticle(articleNumber);
        articlePage.checkTitlePresentInArticle(title);
        articlePage.saveArticleInSavedList();
        articlePage.getTopPanel().clickNavigateUpButton();
    }
}
