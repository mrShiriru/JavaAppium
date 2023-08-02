package ru.javaAppium.pages.ios;

import io.appium.java_client.AppiumDriver;
import ru.javaAppium.pages.MainPage;

public class IOSMainPage extends MainPage {
    public IOSMainPage(AppiumDriver driver) {
        super(driver);
    }

    static {
            SKIP_BUTTON = "xpath://XCUIElementTypeButton[@name='Skip']";
            FREE_ENC = "id:The free encyclopedia";
    }

}
