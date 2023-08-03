package ru.javaAppium.pages.android;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.javaAppium.pages.GroupPage;

public class AndroidGroupPage extends GroupPage {
    public AndroidGroupPage(AppiumDriver<WebElement> driver) {
        super(driver);
    }

    static {
        ARTICLE_LIST_TITLE = By.xpath(
                "//android.widget.TextView[@resource-id='org.wikipedia:id/page_list_item_title']");
                POPUP_INFO = By.id("org.wikipedia:id/snackbar_text");
    }
}
