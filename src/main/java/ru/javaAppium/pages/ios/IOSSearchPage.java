package ru.javaAppium.pages.ios;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.javaAppium.pages.SearchPage;

public class IOSSearchPage extends SearchPage {

    public IOSSearchPage(AppiumDriver<WebElement> driver) {
        super(driver);
    }

    static{
        SEARCH_INPUT_ELEMENT = By.xpath("//*[contains(@name,'Search Wikipedia')]");
        SEARCH_CLOSE_BUTTON = By.id("org.wikipedia:id/search_close_btn");
        ARTICLES_IN_SEARCH_LIST = By.xpath(
                "//*[@resource-id='org.wikipedia:id/search_results_list']//android.view.ViewGroup");
        PAGE_LIST_ITEM_TITLE = By.xpath(".//*[@resource-id='org.wikipedia:id/page_list_item_title']");

        SEARCH_RESULT_BY_SUBSTRING_TPL = "XCUIElementTypeStaticText[contains(@name,'{DESCRIPTION}')]";
        SEARCH_BY_TITLE_AND_DESCRIPTION_TPL = "//*[@resource-id ='org.wikipedia:id/search_results_list']" +
                "//*[@resource-id='org.wikipedia:id/page_list_item_title' and @text='{TITLE}']/following-sibling::" +
                SEARCH_RESULT_BY_SUBSTRING_TPL;
    }
}
