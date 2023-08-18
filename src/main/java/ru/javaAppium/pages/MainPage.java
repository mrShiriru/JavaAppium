package ru.javaAppium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import ru.javaAppium.panels.BottomPanel;
import ru.javaAppium.pages.factories.BottomPanelFactory;


public abstract class MainPage extends AnyPage {

    BottomPanel bottomPanel;

    protected static By
            SKIP_BUTTON,
            MAIN_MENU,
            FREE_ENC;

    public MainPage(RemoteWebDriver driver) {
        super(driver);
        bottomPanel = BottomPanelFactory.get(driver);
    }

    public BottomPanel getBottomPanel() {
        return bottomPanel;
    }

    public void waitForFreeEncyclopedia(){
        waitElementVisibility(FREE_ENC,"cannot find element 'The free encyclopedia'");
    }

    public void clickMainMenu(){
        tryClick(MAIN_MENU,"ERROR", 3);
    }

    public void clickWatchList(){
        By locator = By.xpath("//a[@data-event-name='menu.watchlist']");
        tryClick(locator, "ERROR", 3);
    }

    public void skipOnboarding(){
        waitForFreeEncyclopedia();
        waitAndClick(
                SKIP_BUTTON,
                "Cannot click Skip button",
                5);
    }

}
