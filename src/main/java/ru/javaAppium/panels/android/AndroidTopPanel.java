package ru.javaAppium.panels.android;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.javaAppium.panels.TopPanel;

public class AndroidTopPanel extends TopPanel {

    public AndroidTopPanel(AppiumDriver<WebElement> driver) {
        super(driver);
    }

    static {
        NAVIGATE_UP = By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']");
    }

}
