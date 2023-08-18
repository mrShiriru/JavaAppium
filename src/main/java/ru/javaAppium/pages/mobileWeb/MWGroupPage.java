package ru.javaAppium.pages.mobileWeb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import ru.javaAppium.pages.GroupPage;

import java.util.List;

public class MWGroupPage extends GroupPage {
    public MWGroupPage(RemoteWebDriver driver) {
        super(driver);
    }

    static {
        ARTICLE_LIST_TITLE = By.xpath("//ul[@class='content-unstyled page-list thumbs page-summary-list mw-mf-watchlist-page-list']//li");
        POPUP_INFO = By.id("org.wikipedia:id/snackbar_text");
    }

    @Override
    public void deleteArticle(int articleNumber) {
        List<WebElement> articleList = getArticlesList();
        By locator = By.xpath(".//a[@type='button']");

        WebElement element = articleList.get(articleNumber).findElement(locator);
        element.click();
        loadingPage();
        driver.navigate().refresh();
        loadingPage();
        By locator2 = By.xpath("//h1[@id='firstHeading']");
        waitElementsPresent(locator2,"ERROR", 10);
    }


    @Override
    public WebElement getArticleFromList(int numberOfArticle) {
        List<WebElement> articles = getArticlesList();
        return articles.get(numberOfArticle);
    }

}
