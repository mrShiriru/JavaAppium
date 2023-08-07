package ru.javaAppium.pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import ru.javaAppium.panels.BottomPanel;
import ru.javaAppium.panels.BottomPanelFactory;


public abstract class MainPage extends AnyPage {

    BottomPanel bottomPanel;

    protected static String
            SKIP_BUTTON,
            FREE_ENC;

    public MainPage(AppiumDriver<WebElement> driver) {
        super(driver);
        bottomPanel = BottomPanelFactory.get(driver);
    }

    public BottomPanel getBottomPanel() {
        return bottomPanel;
    }

    public void waitForFreeEncyclopedia(){
        waitElementVisibility(FREE_ENC,"cannot find element 'The free encyclopedia'");
    }

    public void skipOnboarding(){
        waitForFreeEncyclopedia();
        waitAndClick(
                SKIP_BUTTON,
                "Cannot click Skip button",
                5);
    }

}
