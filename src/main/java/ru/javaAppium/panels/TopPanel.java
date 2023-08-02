package ru.javaAppium.panels;

import io.appium.java_client.AppiumDriver;
import ru.javaAppium.pages.AnyPage;
import org.openqa.selenium.By;

public class TopPanel extends AnyPage {

    public TopPanel(AppiumDriver driver) {
        super(driver);
    }

    public static final By NAVIGATE_UP = By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']");

    public void clickNavigateUpButton(){
        waitAndClick(
                NAVIGATE_UP,
                "Unable to click on the 'Navigate Up' button",
                5
        );
    }


}
