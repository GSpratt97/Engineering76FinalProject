package com.sparta.greg.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login {

    WebDriver webDriver;
    By loginEmail = By.cssSelector("input[name='username'][type='email']");
    By loginPassword = By.cssSelector("input[name='password'][type='password']");
    By rememberMeButton = By.cssSelector("input[name='remember-me'][type='checkbox']");
    By submitButton = By.cssSelector("button[type='submit']");
    By forgotPasswordLink = By.cssSelector("div[class='text-center'] a[class='small']");

    public Login(WebDriver webDriver) {
        this.webDriver = webDriver;
        webDriver.get("http://localhost:8080");
    }

    public HomeTrainer logInAsTrainer(String username, String password) {
        enterUsernameAddress(username);
        enterPassword(password);
        clickSubmitButton();
        return new HomeTrainer(webDriver);
    }

    public HomeTrainee logInAsTrainee(String username, String password) {
        enterUsernameAddress(username);
        enterPassword(password);
        clickSubmitButton();
        return new HomeTrainee(webDriver);
    }

    public void enterUsernameAddress(String username) {
        webDriver.findElement(loginEmail).sendKeys(username);
    }

    public void enterPassword(String password) {
        webDriver.findElement(loginPassword).sendKeys(password);
    }

    public void clickRememberMeButton() {
        webDriver.findElement(rememberMeButton).click();
    }

    public void clickSubmitButton() {
        webDriver.findElement(submitButton).click();
    }

    public void clickForgotPassword() {
        webDriver.findElement(forgotPasswordLink).click();
    }

    public String getUrl() {
        return webDriver.getCurrentUrl();
    }


}
