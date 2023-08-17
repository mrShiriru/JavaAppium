package ru.javaAppium.panels.android;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import ru.javaAppium.panels.TopPanel;

public class AndroidTopPanel extends TopPanel {

    public AndroidTopPanel(RemoteWebDriver driver) {
        super(driver);
    }

    static {
        NAVIGATE_UP = By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']");
    }

}
