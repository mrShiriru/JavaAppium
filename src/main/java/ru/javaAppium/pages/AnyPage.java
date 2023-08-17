package ru.javaAppium.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.javaAppium.properties.Platform;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public abstract class AnyPage {
    protected RemoteWebDriver driver;

    public static final int FIRST_ARTICLE = 0;
    public static final int SECOND_ARTICLE = 1;

    public AnyPage(RemoteWebDriver driver){
        this.driver= driver;
    }


    public WebElement waitElementPresent(By locator, String errorMsg, long timeoutInSeconds){
        return new WebDriverWait(driver, timeoutInSeconds)
                .withMessage(errorMsg + "\n")
                .until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public List<WebElement> waitElementsPresent(By locator, String errorMsg, long timeoutInSeconds){
        return new WebDriverWait(driver, timeoutInSeconds)
                .withMessage(errorMsg + "\n")
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
    }

    public void waitElementNotPresent(By locator, String errorMsg, long timeoutInSeconds){
        new WebDriverWait(driver, timeoutInSeconds)
                .withMessage(errorMsg + "\n")
                .until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public void waitElementsNotPresent(List<WebElement> elements, String errorMsg, long timeoutInSeconds){
        new WebDriverWait(driver, timeoutInSeconds)
                .withMessage(errorMsg + "\n")
                .until(ExpectedConditions.invisibilityOfAllElements(elements));
    }

    public void waitAndClick(By locator, String errorMsg, long timeoutInSeconds){
        WebElement element = waitElementPresent(locator, errorMsg, timeoutInSeconds);
        element.click();
    }

    //

    public void waitAndClick(String locator, String errorMsg, long timeoutInSeconds){
        WebElement element = waitElementPresent(locator, errorMsg, timeoutInSeconds);
        element.click();
    }

    public WebElement waitElementPresent(String locator, String errorMsg, long timeoutInSeconds){
        By by = getLocatorByString(locator);
        return new WebDriverWait(driver, timeoutInSeconds)
                .withMessage(errorMsg + "\n")
                .until(ExpectedConditions.presenceOfElementLocated(by));
    }

    protected WebElement waitElementVisibility(String locator, String errorMessage) {
        By by = getLocatorByString(locator);
        return new WebDriverWait(driver, 5)
                .withMessage(errorMessage)
                .until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    private By getLocatorByString(String locatorWithBy){
        String[] parts = locatorWithBy.split(":=");
        String by = parts[0];
        String locator = parts[1];
        switch (by){
            case "xpath":
                return By.xpath(locator);
            case "id":
                return By.id(locator);
            default:
                throw new IllegalArgumentException("by not found " + by);
        }
    }

    //

    public void waitAndSendKeys(By by, String value, String errorMsg, long timeoutInSeconds){
        WebElement element = waitElementPresent(by, errorMsg, timeoutInSeconds);
        element.sendKeys(value);
    }

    public List<WebElement> findElements(By locator) {
        return driver.findElements(locator);
    }

    public void swipeUp(){
        Dimension size =driver.manage().window().getSize();
        int x = size.getHeight()/2;
        int yStart = (int) (size.getWidth() * 0.8);
        int yEnd = (int) (size.getWidth() * 0.2);

        if (driver instanceof AppiumDriver){
            AppiumDriver driver = (AppiumDriver) this.driver;

            new TouchAction<>(driver)
                    .press(PointOption.point(x,yStart))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                    .moveTo(PointOption.point(x, yEnd))
                    .release()
                    .perform();
        } else {
            log.info("swipeUP works only with Appium driver");
        }
    }

    public void swipeElementToLeft(WebElement element) {
        if(Platform.getInstance().isAndroid()){
            swipeElementToLeftAndroid(element);
        } else {
            swipeElementToLeftIOS(element);
        }
    }

    public void swipeElementToLeftAndroid(WebElement element){
        Map<String, Integer> eCord = getCoordinates(element);

        if (driver instanceof AppiumDriver) {
            AppiumDriver driver = (AppiumDriver) this.driver;

            new TouchAction<>(driver)
                    .press(PointOption.point(eCord.get("right_x") - 10, eCord.get("middle_y")))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(300)))
                    .moveTo(PointOption.point(eCord.get("left_x") + 10, eCord.get("middle_y")))
                    .release()
                    .perform();
        }
    }

    public void swipeElementToLeftIOS(WebElement element) {
        Map<String, Integer> eCord = getCoordinates(element);

        if (driver instanceof AppiumDriver) {
            AppiumDriver driver = (AppiumDriver) this.driver;
            new TouchAction<>(driver)
                    .press(PointOption.point(eCord.get("right_x") + 1000, eCord.get("middle_y")))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(300)))
                    .moveTo(PointOption.point(eCord.get("left_x") + 10, eCord.get("middle_y")))
                    .release()
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(300)))
                    .tap(PointOption.point(eCord.get("right_x"), eCord.get("middle_y")))
                    .perform();
        }
    }

    private Map<String, Integer> getCoordinates(WebElement element){
        Map<String,Integer> elementCoordinate = new HashMap<>();

        int left_x = element.getLocation().getX();
        int right_x = left_x + element.getSize().getWidth();
        int upper_y = element.getLocation().getY();
        int lower_y = upper_y + element.getSize().getHeight();
        int middle_y = (upper_y + lower_y) / 2;

        elementCoordinate.put("left_x", left_x);
        elementCoordinate.put("right_x",  right_x);
        elementCoordinate.put("upper_y", upper_y);
        elementCoordinate.put("lower_y", lower_y);
        elementCoordinate.put("middle_y", middle_y);
        return elementCoordinate;
    }
}
