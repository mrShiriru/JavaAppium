package ru.javaAppium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AuthorizationPage extends AnyPage{

    public AuthorizationPage(RemoteWebDriver driver) {
        super(driver);
    }

    public static final By
            LOGIN_BUTTON = By.xpath("//a[@type='button' and ./span[text()='Log in']]"),
            LOGIN_INPUT = By.xpath("//input[@id='wpName1' and @name='wpName']"),
            LOGIN_PASSWORD = By.xpath("//input[@id='wpPassword1' and @name='wpPassword']"),
            SUBMIT_BUTTON= By.xpath("//button[@id='wpLoginAttempt' and @value='Log in']");


    public void clickAuthButton(){
        tryClick(LOGIN_BUTTON,"Cannot find and click login button", 3);
    }

    public void enterLoginData(String login, String password){
        waitAndSendKeys(LOGIN_INPUT, login ,"Cannot find and put a login to the login input",5);
        waitAndSendKeys(LOGIN_PASSWORD, password ,"Cannot find and put a password to the password input",5);
    }

    public void clickSubmitButton(){
        waitAndClick(SUBMIT_BUTTON,"Cannot find and click submit button", 5);
    }




}
