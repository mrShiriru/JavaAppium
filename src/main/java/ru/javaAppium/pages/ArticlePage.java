package ru.javaAppium.pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.javaAppium.panels.BottomPanel;
import ru.javaAppium.panels.TopPanel;

import java.util.List;


public abstract class ArticlePage extends AnyPage {

    TopPanel topPanel;
    BottomPanel bottomPanel;

    protected static By
            FRAGMENT_PAGE_COORDINATOR,
            ARTICLE_TITLE;
    protected static String TITLE_TPL;

    public ArticlePage(AppiumDriver<WebElement> driver) {
        super(driver);
        topPanel = new TopPanel(driver);
        bottomPanel = new BottomPanel(driver);
    }

    public TopPanel getTopPanel(){
        return topPanel;
    }

    /* TEMPLATES METHODS */
    private static By getArticleTitleLocator(String title){
        return By.xpath(TITLE_TPL.replace("{TITLE}", title));
    }
    /* TEMPLATES METHODS */

    public void saveArticleInSavedList(){
        bottomPanel.clickSaveButton();

        waitElementPresent(
                FRAGMENT_PAGE_COORDINATOR,
                "Popup with info not found",
                15
        );
    }

    public void checkTitlePresentInArticle(String titleName){

        waitElementPresent(getArticleTitleLocator(titleName),
                String.format("Cannot find title '%s' in the current article", titleName),
                15);
    }

    public String getTitle() {
        WebElement actualArticle =  waitElementPresent(
                ARTICLE_TITLE,
                "Article title not found",
                5);

        return actualArticle.getAttribute("name");
    }

    private int getAmountOfElements(By by){
        List<WebElement> elements = driver.findElements(by);
        return elements.size();
    }

    public void assertElementPresent(String title){
        By locator = getArticleTitleLocator(title);

        int amount = getAmountOfElements(getArticleTitleLocator(title));
        if (amount == 0){
            String default_message = "Element "+ locator + " supposed to be present";
            throw new AssertionError(default_message);
        }
    }


}
