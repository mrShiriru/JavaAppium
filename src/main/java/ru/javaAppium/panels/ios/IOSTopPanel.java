package ru.javaAppium.panels.ios;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import ru.javaAppium.panels.TopPanel;

public class IOSTopPanel  extends TopPanel {

    public IOSTopPanel(RemoteWebDriver driver) {
        super(driver);
    }

    static {
        NAVIGATE_UP = By.xpath("//XCUIElementTypeButton[@name='Search']");
    }
}
