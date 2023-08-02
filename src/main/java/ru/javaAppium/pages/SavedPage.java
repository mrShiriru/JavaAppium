package ru.javaAppium.pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;


public class SavedPage extends AnyPage {
    public SavedPage(AppiumDriver driver) {
        super(driver);
    }

    private static final By
            SAVED_GROUP = By.xpath("//android.view.ViewGroup" +
            "//android.widget.TextView[@resource-id='org.wikipedia:id/item_title' and @text='Saved']");

    public void clickSavedGroup(){
        waitAndClick(SAVED_GROUP,
                "Can't open Saved group",
                5);
    }
}
