package com.sparta.greg.pom.pages.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public abstract class ChangePassword extends Page {


    By oldPassword = By.cssSelector("input[name='oldPassword'][type='password']");
    By newPassword = By.cssSelector("input[name='password'][type='password']");
    By submitButton = By.cssSelector("button[type='submit']");

    public ChangePassword(WebDriver webDriver) {
        super(webDriver);
    }

//    I commented out the click submit button for safety in case anyone runs any tests



    public void enterOldPassword(String password) {
        webDriver.findElement(oldPassword).sendKeys(password);
    }

    public void enterNewPassword(String password) {
        webDriver.findElement(newPassword).sendKeys(password);
    }

    public void clickSubmitButton() {
//        webDriver.findElement(submitButton).click();
    }

}
