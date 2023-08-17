package ru.javaAppium.panels;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import ru.javaAppium.panels.android.AndroidBottomPanel;
import ru.javaAppium.panels.ios.IOSBottomPanel;
import ru.javaAppium.properties.Platform;

public class BottomPanelFactory {

    public static BottomPanel get(RemoteWebDriver driver){
        if (Platform.getInstance().isAndroid()){
            return new AndroidBottomPanel(driver);
        }else {
            return new IOSBottomPanel(driver);
        }
    }

}
