package ru.javaAppium.pages;

import io.appium.java_client.AppiumDriver;
import ru.javaAppium.panels.BottomPanel;


public class MainPage extends AnyPage {

    BottomPanel bottomPanel;

    private final String
            SKIP_BUTTON = "//XCUIElementTypeButton[@name='Skip']",
            FREE_ENC = "The free encyclopedia";

    public MainPage(AppiumDriver driver) {
        super(driver);
        bottomPanel = new BottomPanel(driver);
    }

    public BottomPanel getBottomPanel() {
        return bottomPanel;
    }

    public void waitForFreeEncyclopedia(){
        waitElementVisibility("id:"+FREE_ENC,"cannot find element 'The free encyclopedia'");
    }

    public void skipOnboarding(){
        waitForFreeEncyclopedia();
        waitAndClick(
                "xpath:" + SKIP_BUTTON,
                "Cannot click Skip button",
                5);
    }

}
