package ru.javaAppium.pages.mobileWeb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import ru.javaAppium.pages.SearchPage;
import ru.javaAppium.properties.Platform;

public class MWSearchPage extends SearchPage {

    public MWSearchPage(RemoteWebDriver driver) {
        super(driver);
    }

    static{
        SEARCH_INPUT_ELEMENT = By.xpath("//button[@id='searchIcon']");
        SEARCH_INPUT = By.xpath("//input[@class='search mw-ui-background-icon-search' and @type='search']");
        SEARCH_CLEAR_TEXT_BUTTON = By.xpath("//div[@class='header-action']//button[contains(@class,'cancel')]");
        ARTICLES_IN_SEARCH_LIST = By.xpath("//ul[@class='page-list thumbs actionable']//li");
        PAGE_LIST_ITEM_TITLE = By.xpath(".//h3");
        SEARCH_RESULT_BY_SUBSTRING_TPL = "//div[@class='wikidata-description' and contains(text(),'{DESCRIPTION}')]";

        SEARCH_BY_TITLE_AND_DESCRIPTION_TPL = ARTICLES_IN_SEARCH_LIST +
                "//h3[./strong[contains(text(),'{TITLE}')]]/following-sibling::" +
                replaceFirstPathFromNode(SEARCH_RESULT_BY_SUBSTRING_TPL, "//", "");
    }

    @Override
    public String getSearchInputText(){
        if (Platform.getInstance().isMW()){
            waitAndClick(SEARCH_INPUT_ELEMENT, "Cannot click search_input_element", 5);
        }
        WebElement element = waitElementPresent(SEARCH_INPUT,"Error",10);
        return element.getAttribute("placeholder");
    }

}
