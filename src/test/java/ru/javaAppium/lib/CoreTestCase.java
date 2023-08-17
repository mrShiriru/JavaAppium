package ru.javaAppium.lib;

import io.appium.java_client.AppiumDriver;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Marker;
import ru.javaAppium.pages.factories.*;
import ru.javaAppium.pages.*;
import ru.javaAppium.properties.Platform;

@Slf4j
public class CoreTestCase {

    protected RemoteWebDriver driver;

    public static final String ERROR_MESSAGE = "Element not found";

    public static ThreadLocal<MainPage> mainPage;
    public SearchPage searchPage;
    public ArticlePage articlePage;
    public SavedPage savedPage;
    public GroupPage groupPage;

    @BeforeEach
    public void setUp() throws Exception
    {
        driver = Platform.getInstance().getDriver();
        openWikiPageForMobileWeb();
        this.loadingPages();
        mainPage.get().skipOnboarding();
    }

    private void loadingPages(){
        mainPage = new ThreadLocal<>();

        searchPage = SearchPageFactory.get(driver);
        articlePage = ArticlePageFactory.get(driver);
        savedPage = SavedPageFactory.get(driver);
        groupPage = GroupPageFactory.get(driver);
        mainPage.set(MainPageFactory.get(driver));
        //mainPage = MainPageFactory.get(driver);
    }

    private void openWikiPageForMobileWeb(){
        if(Platform.getInstance().isMW()){
            driver.get("https://en.m.wikipedia.org");
        }else {
            log.info("Method openWikiPageForMobileWeb() do nothing for platform "+ Platform.getInstance().getEnumPlatformName());
        }
    }

    @AfterEach
    public void tearDown(){
        driver.quit();
    }

}
