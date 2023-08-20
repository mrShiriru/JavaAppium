package ru.javaAppium.lib;

import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import org.openqa.selenium.remote.RemoteWebDriver;
import ru.javaAppium.pages.factories.*;
import ru.javaAppium.pages.*;
import ru.javaAppium.properties.Platform;

import static ru.javaAppium.properties.Property.getCustomProperty;
import static ru.javaAppium.properties.Server.startAppiumServer;
import static ru.javaAppium.properties.Server.stopAppiumServer;

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
    @Step("run driver and loading pages")
    public void setUp() throws Exception
    {
        //startAppiumServer();
        driver = Platform.getInstance().getDriver();
        openWikiPageForMobileWeb();
        this.loadingPages();
        skipOnboarding();
    }

    private void loadingPages(){
        mainPage = new ThreadLocal<>();

        searchPage = SearchPageFactory.get(driver);
        articlePage = ArticlePageFactory.get(driver);
        savedPage = SavedPageFactory.get(driver);
        groupPage = GroupPageFactory.get(driver);
        mainPage.set(MainPageFactory.get(driver));
    }

    private void skipOnboarding(){
        if(!Platform.getInstance().isMW()){
            mainPage.get().skipOnboarding();
        }else {
            log.info("Method skipOnboarding() do nothing for platform "+ Platform.getInstance().getEnumPlatformName());
        }


    }

    private void openWikiPageForMobileWeb(){
        if(Platform.getInstance().isMW()){
            String url = getCustomProperty("mobileWebURL");
            log.info("url: {}", url);
            driver.get(url);
        }else {
            log.info("Method openWikiPageForMobileWeb() do nothing for platform "+ Platform.getInstance().getEnumPlatformName());
        }
    }

    @AfterEach
    @Step("Quit driver")
    public void tearDown(){
        driver.quit();
        //stopAppiumServer();
    }

}
