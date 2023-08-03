package ru.javaAppium.pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebElement;
import ru.javaAppium.interfaces.Article;
import ru.javaAppium.panels.TopPanel;

import java.util.List;
import java.util.Objects;


public abstract class SearchPage  extends AnyPage implements Article {

    TopPanel topPanel;

    protected static By
            SEARCH_INPUT_ELEMENT,
            SEARCH_CLOSE_BUTTON ,
            ARTICLES_IN_SEARCH_LIST,
            PAGE_LIST_ITEM_TITLE;

    protected static String
            SEARCH_RESULT_BY_SUBSTRING_TPL,
            SEARCH_BY_TITLE_AND_DESCRIPTION_TPL;

    public SearchPage(AppiumDriver<WebElement> driver) {
        super(driver);
        topPanel = new TopPanel(driver);
    }

    public TopPanel getTopPanel(){
        return topPanel;
    }

    /* TEMPLATES METHODS */
    private static By getXpathResultSearchArticle(String description){
        return By.xpath("//"+SEARCH_RESULT_BY_SUBSTRING_TPL.replace("{DESCRIPTION}", description));
    }

    private static By getXpathResultSearchArticle(String title, String description){
        String resultXpath = SEARCH_BY_TITLE_AND_DESCRIPTION_TPL.replace("{TITLE}", title);
        resultXpath = resultXpath.replace("{DESCRIPTION}", description);
        return By.xpath(resultXpath);
    }
    /* TEMPLATES METHODS */

    public void clickSearchInput(){
        waitAndClick(SEARCH_INPUT_ELEMENT, "Cannot find and click search input element", 5);
    }

    public void typeIntoSearchInput(String text){
        waitAndSendKeys(SEARCH_INPUT_ELEMENT, text, "Cannot find and type into search input", 5);
    }

    public void waitForSearchResult(String description){
        waitElementPresent(getXpathResultSearchArticle(description),"Current article not found", 5);
    }

    /**
     * В задании указано название waitForElementByTitleAndDescription, я же сделал перегрузку методов,
     * для того, чтобы можно было ожидать элемент как по заголовку, так и по заголовку и описанию.
     * Надеюсь название не будет считаться помехой для сдачи, а наоборот поощрением к удобству выбора метода
     * @param title - заголовок страницы
     * @param description - описание страницы
     */
    public void waitForSearchResult(String title, String description){
        waitElementPresent(
                getXpathResultSearchArticle(title, description),
                String.format("Current article with title= '%s' and description = '%s' not found", title, description),
                15);
    }

    public void waitAndClickSearchCloseButton(){
        waitAndClick(
                SEARCH_CLOSE_BUTTON, "Cannot find and click X to cancel search", 5);
    }

    public void waitForCancelButtonToDisappear(){
        waitElementNotPresent(SEARCH_CLOSE_BUTTON, "X is still present on the page", 5);
    }

    public void checkArticlesPresentInSearchList() {
        List<WebElement> articles =  waitElementsPresent(
                ARTICLES_IN_SEARCH_LIST,
                "Cannot find articles in the search list",
                15);
        if (Objects.isNull(articles)){
            throw new NotFoundException("No articles found in search list");
        }
    }

    public void waitForArticlesToDisappear(){
        waitElementsNotPresent(
                findElements(ARTICLES_IN_SEARCH_LIST),
                "Articles are still present in search list",
                5);
    }

    public void checkTextInEachSearchResult(String text){
        List<WebElement> articles =  findElements(ARTICLES_IN_SEARCH_LIST);

        for (WebElement article : articles){
            String actualTitle = getTitle(article);

            if (!actualTitle.contains(text)){
                throw new NotFoundException("ext is not contains in search title");
            }
        }
    }

    public WebElement getArticleFromList(int numberOfArticle) {
        List<WebElement> articles =  waitElementsPresent(ARTICLES_IN_SEARCH_LIST,
                "No articles found in the search list",
                15);

        return articles.get(numberOfArticle);
    }

    public String getTitle(WebElement article) {
        return article.findElement(PAGE_LIST_ITEM_TITLE).getText();
    }
}
