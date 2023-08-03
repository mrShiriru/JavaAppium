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
        FRAGMENT_PAGE_COORDINATOR =  By.id("org.wikipedia:id/fragment_page_coordinator");
        ARTICLE_TITLE = By.xpath("//android.view.View[@resource-id='pcs-edit-section-title-description']" +
                "/preceding-sibling::android.view.View");
        TITLE_TPL =  "//android.webkit.WebView[contains(@content-desc,'{TITLE}')]";
    }
}
