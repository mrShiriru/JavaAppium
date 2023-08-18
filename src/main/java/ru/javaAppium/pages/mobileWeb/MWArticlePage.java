package ru.javaAppium.pages.mobileWeb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import ru.javaAppium.pages.ArticlePage;

public class MWArticlePage extends ArticlePage {

    public MWArticlePage(RemoteWebDriver driver) {
        super(driver);
    }

    static {
        FRAGMENT_PAGE_COORDINATOR =  By.xpath("//XCUIElementTypeStaticText[contains(@name,'to a reading list?')]");
        TITLE_TPL =  "(//XCUIElementTypeStaticText[@name='{TITLE}'])[1]";
    }
    static final By ELEMENT_DESCRIPTION = By.xpath("//XCUIElementTypeOther[@name='banner']/XCUIElementTypeOther[2]/XCUIElementTypeStaticText");


    @Override
    public String getDescription() {
        WebElement actualArticle =  waitElementPresent(
                ELEMENT_DESCRIPTION,
                "Article title not found",
                5);

        return actualArticle.getAttribute("name");
    }

}
