package ru.javaAppium.panels;

import io.appium.java_client.AppiumDriver;
import ru.javaAppium.pages.AnyPage;
import org.openqa.selenium.By;

public class BottomPanel extends AnyPage {

    public BottomPanel(AppiumDriver driver) {
        super(driver);
    }

    public static final By
            SAVE_BUTTON_ARTICLE_NAV_TAB = By.xpath(
            "//android.widget.TextView[@content-desc='Save' and @resource-id='org.wikipedia:id/page_save']"),
            SAVED_BUTTON_NAVIGATION_TAB = By.xpath("//android.widget.FrameLayout[@content-desc='Saved']");

    public void clickSaveButton(){
        waitAndClick(
                SAVE_BUTTON_ARTICLE_NAV_TAB,
                "Unable to click on the 'Save' button in the bottom menu",
                5
        );
    }

    public void clickSavedButton(){
        waitAndClick(SAVED_BUTTON_NAVIGATION_TAB,
            "Unable to click on the 'Saved' button in the navigation tab",
                5);
    }
}
