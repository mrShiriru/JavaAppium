package ru.javaAppium.pages.ios;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.javaAppium.pages.ArticlePage;

public class IOSArticlePage extends ArticlePage {

    public IOSArticlePage(AppiumDriver<WebElement> driver) {
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
