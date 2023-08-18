package ru.javaAppium.panels;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import ru.javaAppium.pages.AnyPage;
import org.openqa.selenium.By;
import ru.javaAppium.pages.SearchPage;
import ru.javaAppium.properties.Platform;

public abstract class TopPanel extends AnyPage {

    public TopPanel(RemoteWebDriver driver) {
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
