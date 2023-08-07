package ru.javaAppium.panels.android;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.javaAppium.panels.BottomPanel;

public class AndroidBottomPanel extends BottomPanel {

    public AndroidBottomPanel(AppiumDriver<WebElement> driver) {
        super(driver);
    }

    static {
        SAVE_BUTTON_ARTICLE_NAV_TAB = By.xpath(
                "//android.widget.TextView[@content-desc='Save' and @resource-id='org.wikipedia:id/page_save']");
        SAVED_BUTTON_NAVIGATION_TAB = By.xpath("//android.widget.FrameLayout[@content-desc='Saved']");
    }

}
