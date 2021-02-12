package com.sparta.greg.pom.pages.components;

import com.sparta.greg.pom.pages.components.Login;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public abstract class Page {


    public WebDriver webDriver;
    By userDropDownPhoto = new By.ByCssSelector("ul[class*='navbar-nav'] a[id*='userDropdown']");
    By logout = new By.ByCssSelector("ul[class*='navbar-nav'] li > div > a[data-target*='logout']");
    By confirmLogout = new By.ByCssSelector("form[action='/logout']");

    public Page(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void selectProfileImage() {
        webDriver.findElement(userDropDownPhoto).click();
    }

    public Login logout() {
        webDriver.findElement(logout).click();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        webDriver.findElement(confirmLogout).click();
        return new Login(webDriver);
    }
    public String getURL() {
        return webDriver.getCurrentUrl();
    }
}