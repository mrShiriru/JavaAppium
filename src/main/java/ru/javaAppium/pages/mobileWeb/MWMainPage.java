package ru.javaAppium.pages.mobileWeb;

import org.openqa.selenium.remote.RemoteWebDriver;
import ru.javaAppium.pages.MainPage;

public class MWMainPage extends MainPage {
    public MWMainPage(RemoteWebDriver driver) {
        super(driver);
    }

    static {
            SKIP_BUTTON = "xpath:=//XCUIElementTypeButton[@name='Skip']";
            FREE_ENC = "id:=The free encyclopedia";
    }
}
