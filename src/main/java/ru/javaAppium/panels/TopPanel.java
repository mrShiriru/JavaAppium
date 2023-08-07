package ru.javaAppium.panels;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import ru.javaAppium.pages.AnyPage;
import org.openqa.selenium.By;
import ru.javaAppium.properties.Platform;

public abstract class TopPanel extends AnyPage {

    public TopPanel(AppiumDriver<WebElement> driver) {
        super(driver);
    }

    public static By NAVIGATE_UP;


    public void clickNavigateUpButton(){
        waitAndClick(
                NAVIGATE_UP,
                "Unable to click on the 'Navigate Up' button",
                5
        );
    }


}
