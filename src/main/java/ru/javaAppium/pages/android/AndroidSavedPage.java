package ru.javaAppium.pages.android;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.javaAppium.pages.SavedPage;

public class AndroidSavedPage extends SavedPage {
    public AndroidSavedPage(AppiumDriver<WebElement> driver) {
        super(driver);
    }

    static {
        SAVED_GROUP = By.xpath("//android.view.ViewGroup" +
                "//android.widget.TextView[@resource-id='org.wikipedia:id/item_title' and @text='Saved']");
    }
}
