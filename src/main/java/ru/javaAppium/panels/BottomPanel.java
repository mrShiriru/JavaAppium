package ru.javaAppium.panels;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import ru.javaAppium.pages.AnyPage;
import org.openqa.selenium.By;

public abstract class BottomPanel extends AnyPage {

    public BottomPanel(RemoteWebDriver driver) {
        super(driver);
    }

    protected static By
            SAVE_BUTTON_ARTICLE_NAV_TAB,
            SAVED_BUTTON_NAVIGATION_TAB;


    public void clickSaveButton() {
        waitAndClick(
                SAVE_BUTTON_ARTICLE_NAV_TAB,
                "Unable to click on the 'Save' button in the bottom menu",
                10
        );
    }

    public void clickSavedButton(){
        waitAndClick(SAVED_BUTTON_NAVIGATION_TAB,
            "Unable to click on the 'Saved' button in the navigation tab",
                5);
    }
}
