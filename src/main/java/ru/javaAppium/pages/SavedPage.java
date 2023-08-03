package ru.javaAppium.pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public abstract class SavedPage extends AnyPage {
    public SavedPage(AppiumDriver<WebElement> driver) {
        super(driver);
    }

    protected static By
            SAVED_GROUP = By.xpath("//android.view.ViewGroup" +
            "//android.widget.TextView[@resource-id='org.wikipedia:id/item_title' and @text='Saved']");

    public void clickSavedGroup(){
        waitAndClick(SAVED_GROUP,
                "Can't open Saved group",
                5);
    }
}
