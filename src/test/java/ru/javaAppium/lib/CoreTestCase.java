package ru.javaAppium.lib;

import io.appium.java_client.AppiumDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebElement;
import ru.javaAppium.pages.factories.*;
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
        searchPage = SearchPageFactory.get(driver);
        articlePage = ArticlePageFactory.get(driver);
        savedPage = SavedPageFactory.get(driver);
        groupPage = GroupPageFactory.get(driver);
        mainPage = MainPageFactory.get(driver);
    }

    @AfterEach
    public void tearDown(){
        driver.quit();
    }

}
