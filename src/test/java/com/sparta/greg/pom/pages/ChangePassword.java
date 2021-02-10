package com.sparta.greg.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ChangePassword extends Page{

    By oldPassword = By.cssSelector("input[name='oldPassword'][type='password']");
    By newPassword = By.cssSelector("input[name='password'][type='password']");
    By submitButton = By.cssSelector("button[type='submit']");

    public ChangePassword(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

//    I commented out the click submit button for safety in case anyone runs any tests

    public HomeTrainer changeTrainerPassword(String oldPassword, String newPassword) {
        enterOldPassword(oldPassword);
        enterNewPassword(newPassword);
//        clickSubmitButton();
        return new HomeTrainer(webDriver);
    }

    public HomeTrainee changeTraineePassword(String oldPassword, String newPassword) {
        enterOldPassword(oldPassword);
        enterNewPassword(newPassword);
//        clickSubmitButton();
        return new HomeTrainee(webDriver);
    }

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
