package ru.javaAppium.pages.android;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import ru.javaAppium.pages.SearchPage;

public class AndroidSearchPage extends SearchPage {
    public AndroidSearchPage(RemoteWebDriver driver) {
        super(driver);
    }

    static{
                SEARCH_INPUT_ELEMENT = By.xpath("//*[contains(@text,'Search Wikipedia')]");
                SEARCH_CLEAR_TEXT_BUTTON = By.id("org.wikipedia:id/search_close_btn");
                ARTICLES_IN_SEARCH_LIST = By.xpath(
                        "//*[@resource-id='org.wikipedia:id/search_results_list']//android.view.ViewGroup");
                PAGE_LIST_ITEM_TITLE = By.xpath(".//*[@resource-id='org.wikipedia:id/page_list_item_title']");

                SEARCH_RESULT_BY_SUBSTRING_TPL = "XCUIElementTypeStaticText[contains(@name,'{DESCRIPTION}')]";
                SEARCH_BY_TITLE_AND_DESCRIPTION_TPL = "//*[@resource-id ='org.wikipedia:id/search_results_list']" +
                        "//*[@resource-id='org.wikipedia:id/page_list_item_title' and @text='{TITLE}']/following-sibling::" +
                        SEARCH_RESULT_BY_SUBSTRING_TPL;
    }
}
