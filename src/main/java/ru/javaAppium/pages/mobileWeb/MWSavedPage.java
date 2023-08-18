package ru.javaAppium.pages.mobileWeb;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import ru.javaAppium.pages.SavedPage;

public class MWSavedPage extends SavedPage {
    public MWSavedPage(RemoteWebDriver driver) {
        super(driver);
    }

    static {
        SAVED_GROUP = By.xpath("//XCUIElementTypeButton[@name='Saved']");
    }
}
