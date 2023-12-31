package ru.javaAppium.panels.ios;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import ru.javaAppium.panels.BottomPanel;

public class IOSBottomPanel extends BottomPanel {

    public IOSBottomPanel(RemoteWebDriver driver) {
        super(driver);
    }

    static {
        SAVE_BUTTON_ARTICLE_NAV_TAB = By.xpath(
                "//XCUIElementTypeButton[@name='Save for later']");
        SAVED_BUTTON_NAVIGATION_TAB = By.xpath("//XCUIElementTypeButton[@name='Saved']");
    }
}
