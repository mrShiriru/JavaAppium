package ru.javaAppium.pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public abstract class AnyPage {
    protected AppiumDriver<WebElement> driver;

    public static final int FIRST_ARTICLE = 0;
    public static final int SECOND_ARTICLE = 1;

    public AnyPage(AppiumDriver<WebElement> driver){
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

    protected void waitElementVisibility(String locator, String errorMessage) {
        By by = getLocatorByString(locator);
        new WebDriverWait(driver, 5)
                .withMessage(errorMessage)
                .until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    private By getLocatorByString(String locatorWithBy){
        String[] parts = locatorWithBy.split(":");
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

    public void swipeUp(){}
//        TouchAction action = new TouchAction(driver);
//        Dimension size =driver.manage().window().getSize();
//        int x = size.getHeight()/2;
//        int yStart = (int) (size.getWidth() * 0.8);
//        int yEnd = (int) (size.getWidth() * 0.2);
//
//        action
//                .press(x,yStart)
//                .waitAction(1000)
//                .moveTo(x, yEnd)
//                .release()
//                .perform();
//    }

    public void swipeElementToLeft(WebElement element){
//        int left_x = element.getLocation().getX();
//        int right_x = left_x + element.getSize().getWidth();
//        int upper_y = element.getLocation().getY();
//        int lower_y = upper_y + element.getSize().getHeight();
//        int middle_y = (upper_y + lower_y) / 2;
//
//        new TouchAction(driver)
//                .press(right_x-10, middle_y)
//                .waitAction(200)
//                .moveTo(left_x+10, middle_y)
//                .release()
//                .perform();
    }


}
