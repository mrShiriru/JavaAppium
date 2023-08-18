package ru.javaAppium.pages.mobileWeb;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import ru.javaAppium.pages.MainPage;

public class MWMainPage extends MainPage {
    public MWMainPage(RemoteWebDriver driver) {
        super(driver);
    }

    static {
            MAIN_MENU = By.xpath("//span[@class='mw-ui-icon mw-ui-icon-wikimedia-menu-base20']");
    }


    public void clickMainMenu(){
        By locator = By.xpath("//span[@class='mw-ui-icon mw-ui-icon-wikimedia-menu-base20']");
        tryClick(locator,"ERROR", 3);
    }

}
