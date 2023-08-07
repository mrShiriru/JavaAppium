package ru.javaAppium.panels;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import ru.javaAppium.panels.android.AndroidTopPanel;
import ru.javaAppium.panels.ios.IOSTopPanel;
import ru.javaAppium.properties.Platform;

public class TopPanelFactory {

    public static TopPanel get(AppiumDriver<WebElement> driver){
        if (Platform.getInstance().isAndroid()){
            return new AndroidTopPanel(driver);
        }else {
            return new IOSTopPanel(driver);
        }
    }

}
