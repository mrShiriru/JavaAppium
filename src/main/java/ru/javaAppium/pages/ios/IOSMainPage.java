package ru.javaAppium.pages.ios;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import ru.javaAppium.pages.MainPage;

public class IOSMainPage extends MainPage {
    public IOSMainPage(RemoteWebDriver driver) {
        super(driver);
    }

    static {
            SKIP_BUTTON = By.xpath("//XCUIElementTypeButton[@name='Skip']");
            FREE_ENC = By.id("The free encyclopedia");
    }
}
