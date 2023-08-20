package ru.javaAppium.commonTests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
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
    String searchValue = "Appium";

    @Test
    @Features(value = {@Feature("Article"), @Feature("SavedGroup"), @Feature("Search")})
    @DisplayName("Delete article success test")
    @Description("Add two saved title, delete one")
    @Severity(value = SeverityLevel.BLOCKER)
    public void testEx5_testCreateTwoArticle() {

        searchPage.typeToSearch(searchValue);
        saveCurrentArticle(FIRST_ARTICLE);
        saveCurrentArticle(SECOND_ARTICLE);
        searchPage.returnOnTheMainPage();
        openGroupWithSavedArticles();

        List<WebElement> items = groupPage.getArticlesList();
        groupPage.deleteArticle(FIRST_ARTICLE);
        List<WebElement> items2 =  groupPage.getArticlesList();
        Assertions.assertTrue(items.size() > items2.size(), "The first article hasn't been removed");

        if(Platform.getInstance().isAndroid()){
            verifyTitleOfArticle();
        } else  if(Platform.getInstance().isIOS()){
            verifyDescriptionOfArticle();
        } else {
            verifyClickedStarButtonOfArticle();
        }
    }

    @Step("openGroupWithSavedArticles")
    private void openGroupWithSavedArticles(){
        if(Platform.getInstance().isMW()){
            mainPage.get().clickMainMenu();
            mainPage.get().clickWatchList();

        }else {
            mainPage.get().getBottomPanel().clickSavedButton();
            savedPage.clickSavedGroup();
        }
    }

    @Step("verifyDescriptionOfArticle")
    private void verifyDescriptionOfArticle() {
        String expectedDescription = groupPage.saveDescriptionAndOpenArticle(FIRST_ARTICLE);
        String actualDescription = articlePage.getDescription();
        Assertions.assertEquals(expectedDescription,actualDescription,ERROR_MESSAGE);
    }

    @Step("verifyTitleOfArticle")
    private void verifyTitleOfArticle() {
        String expectedTitle = groupPage.saveTitleAndOpenArticle(FIRST_ARTICLE);
        String actualTitle = articlePage.getTitle();
        Assertions.assertEquals(expectedTitle,actualTitle, ERROR_MESSAGE);
    }

    private void verifyClickedStarButtonOfArticle(){
        groupPage.saveTitleAndOpenArticle(FIRST_ARTICLE);
        Assertions.assertTrue(articlePage.isStarButtonClicked(),"Button star hasn't been clicked");
    }

    @Step("saveCurrentArticle")
    private void saveCurrentArticle(int articleNumber){
        String title = searchPage.saveTitleAndOpenArticle(articleNumber);
        articlePage.saveCurrentArticle(title);
        clickGoBack();
    }

    private void clickGoBack(){
        if(Platform.getInstance().isMW()){
            searchPage.typeToSearch(searchValue);
        }else {
            articlePage.getTopPanel().clickNavigateUpButton();
        }
    }


}
