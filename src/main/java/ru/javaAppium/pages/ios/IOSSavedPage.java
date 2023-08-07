package ru.javaAppium.pages.ios;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.javaAppium.pages.SavedPage;

public class IOSSavedPage extends SavedPage {
    public IOSSavedPage(AppiumDriver<WebElement> driver) {
        super(driver);
    }

    static {
        SAVED_GROUP = By.xpath("//XCUIElementTypeButton[@name='Saved']");
    }
}
