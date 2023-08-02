package ru.javaAppium.lib;

import io.appium.java_client.AppiumDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebElement;
import ru.javaAppium.factories.MainPageFactory;
import ru.javaAppium.pages.*;
import ru.javaAppium.properties.Platform;


public class CoreTestCase {

    protected AppiumDriver<WebElement> driver;

    public static final String ERROR_MESSAGE = "Element not found";

    public MainPage mainPage;
    public SearchPage searchPage;
    public ArticlePage articlePage;
    public SavedPage savedPage;
    public GroupPage groupPage;


    @BeforeEach
    public void setUp() throws Exception
    {
        driver = Platform.getInstance().getDriver();
        this.loadingPages();
        mainPage.skipOnboarding();
    }

    private void loadingPages(){
        searchPage = new SearchPage(driver);
        articlePage = new ArticlePage(driver);
        savedPage = new SavedPage(driver);
        groupPage = new GroupPage(driver);
        mainPage = MainPageFactory.get(driver);
       // mainPage = new MainPage(driver);
    }

    @AfterEach
    public void tearDown(){
        driver.quit();
    }

}
