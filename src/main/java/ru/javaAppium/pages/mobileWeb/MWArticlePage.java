package ru.javaAppium.pages.mobileWeb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import ru.javaAppium.pages.ArticlePage;
import ru.javaAppium.pages.AuthorizationPage;

import static ru.javaAppium.properties.Property.findVariableInCredential;

public class MWArticlePage extends ArticlePage {

    public MWArticlePage(RemoteWebDriver driver) {
        super(driver);
    }

    static {
        FRAGMENT_PAGE_COORDINATOR =  By.xpath("//XCUIElementTypeStaticText[contains(@name,'to a reading list?')]");
        TITLE_TPL = "//span[@class='mw-page-title-main' and text()='{TITLE}']";
        STAR_LOCATOR_CLICKED = By.xpath("//a[.//span[text()='Unwatch']]");
    }
    static final By ELEMENT_DESCRIPTION = By.xpath("//XCUIElementTypeOther[@name='banner']/XCUIElementTypeOther[2]/XCUIElementTypeStaticText");

    @Override
    public void saveArticleInSavedList(){
        By starLocator = By.xpath("//a[.//span[text()='Watch']]");

        if (!isStarButtonClicked()){
            tryClick(starLocator,"Cannot find and click star button",5);
            checkLogin();
        }

        waitElementPresent(STAR_LOCATOR_CLICKED, "Cannot find clicked star button", 10);
    }

    private void checkLogin(){
        if (isElementPresent(AuthorizationPage.LOGIN_BUTTON)) {
            AuthorizationPage authorizationPage = new AuthorizationPage(driver);
            //проверка
            authorizationPage.clickAuthButton();
            authorizationPage.enterLoginData(findVariableInCredential("login"), findVariableInCredential("password"));
            authorizationPage.clickSubmitButton();
        }
    }

    @Override
    public String getDescription() {
        WebElement actualArticle =  waitElementPresent(
                ELEMENT_DESCRIPTION,
                "Article title not found",
                5);

        return actualArticle.getAttribute("name");
    }

}
