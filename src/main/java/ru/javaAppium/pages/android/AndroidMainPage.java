package ru.javaAppium.pages.android;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import ru.javaAppium.pages.MainPage;

public class AndroidMainPage extends MainPage {
    public AndroidMainPage(RemoteWebDriver driver) {
        super(driver);
    }

    static {
        SKIP_BUTTON = "id:=org.wikipedia:id/fragment_onboarding_skip_button";
        FREE_ENC = "id:=org.wikipedia:id/primaryTextView";
    }
}
