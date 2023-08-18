package ru.javaAppium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import ru.javaAppium.panels.BottomPanel;
import ru.javaAppium.pages.factories.BottomPanelFactory;
import ru.javaAppium.panels.TopPanel;
import ru.javaAppium.pages.factories.TopPanelFactory;

import java.util.List;


public abstract class ArticlePage extends AnyPage {

    TopPanel topPanel;
    BottomPanel bottomPanel;

    protected static By
            FRAGMENT_PAGE_COORDINATOR,
            STAR_LOCATOR_CLICKED,

            ARTICLE_TITLE;
    protected static String TITLE_TPL;

    public ArticlePage(RemoteWebDriver driver) {
        super(driver);
        topPanel = TopPanelFactory.get(driver);
        bottomPanel = BottomPanelFactory.get(driver);
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

    public void saveCurrentArticle(String  title){
        checkTitlePresentInArticle(title);
        saveArticleInSavedList();
    }


    public void checkTitlePresentInArticle(String titleName){
        waitElementPresent(getArticleTitleLocator(titleName),
                String.format("Cannot find title '%s' in the current article", titleName),
                15);
        checkPopupHelper();
    }

    protected void checkPopupHelper(){
        By locator = By.xpath("//*[contains(@name, 'Tap to go back')]");

        if (isElementPresent(locator)){
            waitElementNotPresent(locator,"Popup 'Tap to go back' still present on the page",15);
        }
    }

    public abstract String getDescription();

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


    public boolean isStarButtonClicked(){
        return isElementPresent(STAR_LOCATOR_CLICKED);
    };
}
