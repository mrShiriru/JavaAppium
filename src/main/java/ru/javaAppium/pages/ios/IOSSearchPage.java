package ru.javaAppium.pages.ios;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import ru.javaAppium.pages.SearchPage;

public class IOSSearchPage extends SearchPage {

    public IOSSearchPage(RemoteWebDriver driver) {
        super(driver);
    }

    static{
        SEARCH_INPUT_ELEMENT = By.xpath("//*[contains(@name,'Search Wikipedia')]");
        SEARCH_INPUT = SEARCH_INPUT_ELEMENT;
        SEARCH_CLEAR_TEXT_BUTTON = By.xpath("//XCUIElementTypeButton[@name='Clear text']");
        ARTICLES_IN_SEARCH_LIST = By.xpath(
                "//XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeCollectionView//XCUIElementTypeCell");
        PAGE_LIST_ITEM_TITLE = By.xpath(".//XCUIElementTypeStaticText[1]");

        SEARCH_RESULT_BY_SUBSTRING_TPL = "//XCUIElementTypeStaticText[contains(@name,'{DESCRIPTION}')]";
        SEARCH_BY_TITLE_AND_DESCRIPTION_TPL = ARTICLES_IN_SEARCH_LIST +
                "//XCUIElementTypeStaticText[contains(@name,'{TITLE}')]/following-sibling::" +
                replaceFirstPathFromNode(SEARCH_RESULT_BY_SUBSTRING_TPL, "//", "");
    }

    By CANCEL_BUTTON = By.xpath("//XCUIElementTypeStaticText[@name='Cancel']");

    @Override
    protected void clickCancelButton(){
        waitAndClick(CANCEL_BUTTON, "Can not click cancel button", 5);
    }

}
