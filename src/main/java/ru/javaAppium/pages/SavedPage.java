package ru.javaAppium.pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import ru.javaAppium.properties.Platform;


public abstract class SavedPage extends AnyPage {
    public SavedPage(RemoteWebDriver driver) {
        super(driver);
    }

    protected static By
            SAVED_GROUP;

    public void clickSavedGroup(){
        waitAndClick(SAVED_GROUP,
                "Can't open Saved group",
                5);
        checkSyncPopup();
    }

    protected void checkSyncPopup(){
        if(!Platform.getInstance().isAndroid()) {
            String locator1 = "xpath:=//XCUIElementTypeStaticText[@name='Sync your saved articles?']";
            By locator2 = By.xpath("//XCUIElementTypeButton[@name='Close']");

            if(waitElementVisibility(locator1,"").isDisplayed()){
                waitAndClick(locator2, "",5);
            }
        }
    }

}
